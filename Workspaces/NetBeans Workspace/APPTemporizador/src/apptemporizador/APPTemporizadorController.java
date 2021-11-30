/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptemporizador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import miscontroles.campotextonumerico.CampoTextoNumerico;
import miscontroles.temporizador.Temporizador;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class APPTemporizadorController implements Initializable {

    @FXML
    private ComboBox<String> comboBoxMagnitud;
    @FXML
    private CampoTextoNumerico ctbUnidades;
    @FXML
    private HBox hboxTemp;
    @FXML
    private Button botonComp;

    private Temporizador temporizador;
            
    private int tiempo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //ComboBox que tiene las magnitudes
        comboBoxMagnitud.getItems().add("Segundos");
        comboBoxMagnitud.getItems().add("Minutos");
        comboBoxMagnitud.getItems().add("Horas");
        comboBoxMagnitud.setValue("Segundos");
        
        //Handler al pulsar el boton
        botonComp.setOnAction(((ActionEvent event) -> {
        
            
            //Sacamos las unidades
            tiempo = Integer.valueOf(ctbUnidades.getText());
            
            //Vaciamos el campo de texto
            ctbUnidades.setText("");
            
            //Sacamos la magnitud
            switch(comboBoxMagnitud.getValue())
            {
                case "Segundos" :
                                    temporizador = new Temporizador(tiempo,"s");
                                    break;
                case "Minutos" : 
                                    temporizador = new Temporizador(tiempo,"m");
                                    break;
                case "Horas" :
                                    temporizador = new Temporizador(tiempo,"h");
                                    break;
                default:
                                    break;
            }
            hboxTemp.getChildren().clear();
            hboxTemp.getChildren().addAll(temporizador, botonComp);

        }));
        
        //temporizador.
    }    
    
   

}
