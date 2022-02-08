/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscontroles.temporizador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import miscontroles.campotextonumerico.CampoTextoNumerico;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class TemporizadorController implements Initializable {

    @FXML
    private CampoTextoNumerico ctn;
    @FXML
    private Label contador;
    @FXML
    private Label magnitud;
    @FXML
    private Button btnCrear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
