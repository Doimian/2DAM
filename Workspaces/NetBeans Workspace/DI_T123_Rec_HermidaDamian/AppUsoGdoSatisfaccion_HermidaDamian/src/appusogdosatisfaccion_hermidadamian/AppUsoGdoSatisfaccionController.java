/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusogdosatisfaccion_hermidadamian;

import GdoSatisfaccion.GdoSatisfaccion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author damian
 */
public class AppUsoGdoSatisfaccionController implements Initializable {

    @FXML
    private Label lblSat;
    @FXML
    private GdoSatisfaccion gdoSat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* Comprobador de que la propiedad gradoStf funciona
        gdoSat.setGradoStf(25.3);
        lblSat.setText("" + gdoSat.getGradoStf());
        */
    }    
    
    @FXML
    public void actualizaValor()
    {
        lblSat.setText(gdoSat.getGradoStf().toString());
    }
    
    
    //GdoSatisfaccion.set
}
