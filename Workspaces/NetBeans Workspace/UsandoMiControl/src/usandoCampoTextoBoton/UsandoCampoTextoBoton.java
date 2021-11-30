/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usandoCampoTextoBoton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import miscontroles.campotextoboton.CampoTextoBoton;

/**
 *
 * @author damian
 */
public class UsandoCampoTextoBoton extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        CampoTextoBoton campoTB = new CampoTextoBoton();
        campoTB.setText("foo");
        StackPane root = new StackPane();
        root.getChildren().add(campoTB);
        
        Scene scene = new Scene(root, 300, 300);
        
                
        stage.setTitle("UsandoMisControles - CampoTextoBoton");
        stage.setScene(scene);
        
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
