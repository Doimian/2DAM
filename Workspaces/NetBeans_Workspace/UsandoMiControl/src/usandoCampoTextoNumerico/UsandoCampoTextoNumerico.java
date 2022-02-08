/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usandoCampoTextoNumerico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import miscontroles.campotextonumerico.CampoTextoNumerico;
import miscontroles.selectordeslizamiento.SelectorDeslizamiento;

/**
 *
 * @author damian
 */
public class UsandoCampoTextoNumerico extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        
        HBox box  = new HBox();
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
                
        CampoTextoNumerico numtextfield = new CampoTextoNumerico();
        box.getChildren().add(numtextfield);
        
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
