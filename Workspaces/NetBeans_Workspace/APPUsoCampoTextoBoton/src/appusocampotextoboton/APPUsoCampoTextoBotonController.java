/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusocampotextoboton;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import miscontroles.campotextoboton.CampoTextoBoton;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class APPUsoCampoTextoBotonController implements Initializable {

    @FXML
    private CampoTextoBoton ctb1;
    @FXML
    private CampoTextoBoton ctb2;
    @FXML
    private Label lblctb;
    
    private static final String labeltext = "Se ha grabado: ";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ctb1.setText("Nombre");
        ctb2.setText("Apellido");
        lblctb.setText(" ");
    }
    
    @FXML
    private void botonNombre(ActionEvent event)
    {
        lblctb.setText(labeltext + ctb1.getText() + " ");
    }
    
    @FXML
    private void botonApellido(ActionEvent event)
    {
        if(lblctb.getText().contains(labeltext))
            if(lblctb.getText().contains(ctb1.getText()) || lblctb.getText().contains(ctb2.getText()))
                lblctb.setText(labeltext + ctb1.getText() + " " + ctb2.getText());
            else
                lblctb.setText(lblctb.getText() + ctb2.getText());
        else
            lblctb.setText(labeltext + ctb2.getText());
    }
}
