/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoeventosteclado;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Ailla
 */
public class DemoEventosTeclado extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        TextField tf1 = new TextField();
        tf1.addEventHandler(KeyEvent.KEY_TYPED, new ManejadorHandler());
        PasswordField tf2 = new PasswordField();
        tf2.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldValue, Boolean newValue) {
                if (!newValue){
                    System.out.println("Tf2 ha perdido el foco");
                }
            }
        });
        
        TextArea tf3 = new TextArea();

        VBox root = new VBox(tf1, tf2, tf3);
        root.setSpacing(5.0);
        root.setPadding(new Insets(5.0));

        Scene scene = new Scene(root, 350, 250);
        scene.addEventFilter(KeyEvent.KEY_TYPED, new ManejadorFilter()); 

        primaryStage.setTitle("JavaFX Manejo de Eventos");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    class ManejadorFilter implements EventHandler<KeyEvent> {
      
        @Override
        public void handle(KeyEvent e) {
            String type = e.getEventType().getName();
            String source = e.getSource().getClass().getSimpleName();
            String target = e.getTarget().getClass().getSimpleName();

            System.out.println("filter: " + type + ", " + source + ", " + target);

            if (Character.isDigit(e.getCharacter().charAt(0))) {
                System.out.println("filter...caracter: " + e.getCharacter() + ", no permitido.");
                e.consume();
            }
        }
    } 
    class ManejadorHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent e) {
            String type = e.getEventType().getName();
            String source = e.getSource().getClass().getSimpleName();
            String target = e.getTarget().getClass().getSimpleName();
                
            System.out.println("Handler: " + type + ", " + source + ", " + target);
                
            if (!Character.isDigit(e.getCharacter().charAt(0))) {
                System.out.println("Handler ...caracter: " + e.getCharacter() + ", permitido.");
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
