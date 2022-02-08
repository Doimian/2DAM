/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package appinformes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author damian
 */
public class AppInformes extends Application {
    
    public static  Connection conexion = null;
    String listadoElegido = "";
    public static TextField textField;
    
    @Override
    public void start(Stage primaryStage) {
        
        //Hacemos la conexión con la base de datos
        dbConnection();
        
        
        
        //Creamos los elementos visuales (Menu, Botón, TextField, Layout)
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(10));
        primaryStage.setWidth(500);
        primaryStage.setHeight(600);
        Button btn = new Button();
        btn.setPadding(new Insets(10));
        btn.setText("Selecciona un Informe");
        btn.setDisable(true);
        
        textField = new TextField("0");
        textField.setEditable(false);
        
        root.setMargin(textField, new Insets(10));
        
        //Menu que muestra las opciones de informes
        MenuItem item1 = new MenuItem("Listado Facturas");
        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn.setText("Generar Informe: Listado Facturas");
                listadoElegido = "listado_facturas";
                btn.setDisable(false);
            }
        });
        MenuItem item2 = new MenuItem("Ventas Totales");
        item2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn.setText("Generar Informe: Ventas Totales");
                listadoElegido = "ventas_totales";
                btn.setDisable(false);
            }
        });
        MenuItem item3 = new MenuItem("Facturas por Cliente");
        item3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textField.setEditable(true);
                btn.setText("Generar Informe: Facturas por Cliente");
                listadoElegido = "facturas_por_cliente";
                btn.setDisable(false);
            }
        });
        MenuItem item4 = new MenuItem("Listado Facturas (Subinforme)");
        item4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn.setText("Generar Informe: Listado Facturas con subinforme");
                listadoElegido = "listado_facturas_subinforme";
                btn.setDisable(false);
            }
        });
        final Menu menu = new Menu("Informe"); 
        menu.getItems().addAll(item1, item2, item3, item4);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);
        root.getChildren().add(menuBar);
        
        //Boton que genera el informe
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                switch(listadoElegido)
                {
                    case "listado_facturas": generaInformeListadoFacturas(); break;
                    case "ventas_totales": generaInformeVentasTotales(); break;
                    case "facturas_por_cliente": generaInformeFacturasPorCliente(); break;
                    case "listado_facturas_subinforme": generaInformeListadoFacturasSubinforme(); break;
                }
                
                
            }
        });
        
       
        root.getChildren().add(textField);
        
        root.getChildren().add(btn);
        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("AppInformes_Damian");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void dbConnection() {
        String db = "jdbc:hsqldb:hsql://localhost/xdb";
        String usuario = "SA";
        String passwd = "";
        
        try
        {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            conexion = DriverManager.getConnection(db,usuario,passwd);
        }
        catch (ClassNotFoundException cnfe)
        {
            System.err.println("Fallo al cargar JDBC");
            System.exit(1);
        }
        catch (SQLException sqle)
        {
            System.err.println("No se pudo conectar a BD");

            System.exit(1);
        }
        catch (java.lang.InstantiationException sqlex)
        {
            System.err.println("Imposible Conectar");
            System.exit(1);
        }
        catch (Exception ex)
        {
            System.err.println("Imposible Conectar");
            System.exit(1);
        }
    }
    
    @Override
    public void stop() throws Exception {
        try 
        {
            DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb;shutdown=true");
        } 
        catch (Exception ex) 
        {
            System.out.println("No se pudo cerrar la conexion a la BD");
        }
    }
    
    public void generaInforme(TextField textField)
    {
        try
        {
            JasperReport jr = (JasperReport) JRLoader.loadObject(AppInformes.class.getResource("Pedidos.jasper"));
            
            //Map parametros = new HashMap();
            //int nproducto = Integer.valueOf(textField.getText());
            //parametros.put("ParamProducto", nproducto);

            //JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr,parametros, conexion);
            
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, null, conexion);
            JasperViewer.viewReport(jp);
            
            
        } catch(JRException ex)
        {
            System.out.println("Error al recuperar el jasper");
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public void generaInformeListadoFacturas()
    {
        try
        {
            JasperReport jr = (JasperReport) JRLoader.loadObject(AppInformes.class.getResource("facturas.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, null, conexion);
            JasperViewer.viewReport(jp);
        } catch(JRException ex)
        {
            System.out.println("Error al recuperar el jasper");
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void generaInformeVentasTotales()
    {
        try
        {
            JasperReport jr = (JasperReport) JRLoader.loadObject(AppInformes.class.getResource("ventas.jasper"));
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, null, conexion);
            JasperViewer.viewReport(jp);
        } catch(JRException ex)
        {
            System.out.println("Error al recuperar el jasper");
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void generaInformeFacturasPorCliente()
    {
        try
        {
            JasperReport jr = (JasperReport) JRLoader.loadObject(AppInformes.class.getResource("facturas_id.jasper"));
            Map parametros = new HashMap();
            int nproducto = Integer.valueOf(textField.getText());
            parametros.put("ID_FACTURA", nproducto);

            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr,parametros, conexion);
            
            JasperViewer.viewReport(jp);
            
            
        } catch(JRException ex)
        {
            System.out.println("Error al recuperar el jasper");
            JOptionPane.showMessageDialog(null, ex);
        }
    }    
    
    public void generaInformeListadoFacturasSubinforme()
    {
        try
        {
            JasperReport jr = (JasperReport) JRLoader.loadObject(AppInformes.class.getResource("facturas_sub.jasper"));
            JasperReport jsr = (JasperReport) JRLoader.loadObject(AppInformes.class.getResource("sub.jasper"));
            
            //Map de parámetros
            Map parametros = new HashMap();
            parametros.put("subReportParameter", jsr);
            
            JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, parametros, conexion);
            JasperViewer.viewReport(jp, false);
            
        } catch(JRException ex)
        {
            System.out.println("Error al recuperar el jasper");
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
}
