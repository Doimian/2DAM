/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusocodreserva_hermidadamian;

import codreserva_hermidadamian.CodReserva;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class AppUsoCodReservaController implements Initializable {

    @FXML
    private CodReserva cRes;
    @FXML
    private Label lblComp;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void comprobarValidez(ActionEvent event) 
    {
        cRes.setAcceso(Boolean.TRUE);
        
        if(cRes.getAcceso() == Boolean.TRUE)
        {
            lblComp.setStyle("-fx-text-fill: green");
            lblComp.setText("Num Reserva: " +  cRes.getNumReserva());
        }
        else
        {
            lblComp.setStyle("-fx-text-fill: red");
            lblComp.setText("Número de reserva o pin erróneo");
        }
        
    }
    
}
