/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg1_innerclass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class DI_T1A21_InnerClass extends Application {
        Button btn = new Button();
        Button btn2 = new Button();
        Circle circulo = new Circle(5);
        double cambiarRadio = 3.00;
    @Override
    public void start(Stage primaryStage) {

        btn.setText("Aumentar tamaño");
        btn2.setText("Disminuir tamaño");
        /*
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                circulo.setRadius(circulo.getRadius()+cambiarRadio);
            }
        });*/
        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, new ManejadorBoton1());
        /*
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                circulo.setRadius(circulo.getRadius()-cambiarRadio);
            }
        });
        */
        btn2.addEventFilter(MouseEvent.MOUSE_PRESSED, new ManejadorBoton2());
        HBox botones = new HBox();
        botones.getChildren().addAll(btn,btn2);
        BorderPane root = new BorderPane();
        root.setBottom(botones);
        botones.setAlignment(Pos.CENTER);
        root.setCenter(circulo);
        
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    class ManejadorBoton1 implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent event) {
            if(circulo.getRadius() < 50.00)
            circulo.setRadius(circulo.getRadius()+cambiarRadio);
        } 
    }
    class ManejadorBoton2 implements EventHandler<MouseEvent>
    {

        @Override
        public void handle(MouseEvent event) {
            if(circulo.getRadius() > 3.00)
            circulo.setRadius(circulo.getRadius()-cambiarRadio);
        } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
