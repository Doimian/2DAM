/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoeventosteclado;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author usuario
 */
public class DemoEventosTeclado extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = new TextField();
        tf1.addEventHandler(KeyEvent.KEY_TYPED, new ManejadorHandler());
        PasswordField tf2 = new PasswordField();
        tf2.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue) 
                {
                    System.out.println("Tf2 ha perdido el foco");    
                }
            }
        });
        
        TextArea tf3 = new TextArea();
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
