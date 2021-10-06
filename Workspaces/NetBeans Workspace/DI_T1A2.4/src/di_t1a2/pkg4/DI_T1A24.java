/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class DI_T1A24 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Text txt = new Text(30,30,"Arrastra este texto");
        
        txt.setText("Arrastra este texto");
        txt.setOnMouseDragged(e -> {
                double x = txt.getX();
                double y = txt.getY();
                String txt2 = "Arrastra este texto: (" + txt.getX() +"),("+ txt.getY()+")";
                txt.setText(txt2);
                txt.setX(e.getX());
                txt.setY(e.getX());
        });
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        Pane root = new Pane();
        root.getChildren().add(txt);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
