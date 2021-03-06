/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class DI_T1A22 extends Application {
    private Button btn = new Button();
    private Button btn2 = new Button();
    private Button btn3 = new Button();
    private Button btn4 = new Button();
    private Insets margen = new Insets(10, 10, 10, 10);
    private HBox botones;
    private StackPane root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {

        btn.setText("Nuevo");
        btn2.setText("Abrir");
        btn3.setText("Guardar");
        btn4.setText("Imprimir");
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                System.out.println("Nuevo Proceso");
            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                System.out.println("Abrir Proceso");
            }
        });
        btn3.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                System.out.println("Guardar Proceso");
            }
        });
        btn4.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                System.out.println("Imprimir Proceso");
            }
        });
        
        botones = new HBox();
        botones.getChildren().addAll(btn, btn2, btn3, btn4);
        botones.setMargin(btn, margen);
        botones.setMargin(btn2, margen);
        botones.setMargin(btn3, margen);
        botones.setMargin(btn4, margen);
        root = new StackPane();
        root.getChildren().add(botones);
        scene = new Scene(root);   
        primaryStage.setTitle("AnonymousInnerClass");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
