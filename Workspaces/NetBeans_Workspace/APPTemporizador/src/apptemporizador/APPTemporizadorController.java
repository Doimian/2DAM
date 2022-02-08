/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptemporizador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    @FXML
    private Temporizador temp;
            
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
        botonComp.setOnAction(((ActionEvent event) -> 
        {
            
            //Sacamos las unidades
            tiempo = Integer.valueOf(ctbUnidades.getText());
            
            //Vaciamos el campo de texto
            ctbUnidades.setText("");
            
            temp.setTiempo(tiempo);
            
            /*
            //Sacamos la magnitud
            switch(comboBoxMagnitud.getValue())
            {
                case "Segundos" :
                                    temp = new Temporizador(tiempo, "s");
                                    break;
                case "Minutos" : 
                                    temp = new Temporizador(tiempo,"m");
                                    break;
                case "Horas" :
                                    temp = new Temporizador(tiempo,"h");
                                    break;
                default:
                                    break;
            }*/

        }));
        
        //temporizador.
    }    

    @FXML
    private void flashAlarm(ActionEvent event) 
    {
        // Creamos un alert de tipo informativo
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Fin del temporizador."); // Cuerpo del mensaje
        alert.setHeaderText(""); // Establecemos la cabecera del mensaje
        alert.setTitle("OUT OF TIME"); // Titulo del mensaje
        alert.show(); // Mostramos el mensaje
    }

}
