/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusoselector;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import miscontroles.selectordeslizamiento.SelectorDeslizamiento;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class APPUsoSelectorController implements Initializable{

    @FXML
    private SelectorDeslizamiento sdUno;
    @FXML
    private SelectorDeslizamiento sdDos;
    @FXML
    private Label lblRes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void topSelector(ActionEvent event) 
    {
        lblRes.setText("Pulsado el selector de arriba");
    }

    @FXML
    private void botSelector(ActionEvent event) 
    {
        lblRes.setText("Pulsado el selector de abajo");
    }
    
}
