/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg1_innerclass;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class DI_T1A21_InnerClass extends Application {
        private Button btn;
        private Button btn2;
        private Circle circulo;
        double cambiarRadio = 5.00;
        private Scene scene;
        private HBox botones;
        private BorderPane root;
        
    @Override
    public void start(Stage primaryStage) {

        btn = new Button();
        btn2 = new Button();
        btn.setText("Aumentar tamaño");
        btn2.setText("Disminuir tamaño");
        circulo = new Circle(20, Color.GREY);
        circulo.setStroke(Color.BLACK);
        circulo.setFill(Color.TRANSPARENT);
        btn.addEventFilter(MouseEvent.MOUSE_PRESSED, new ManejadorBoton1());
        btn2.addEventFilter(MouseEvent.MOUSE_PRESSED, new ManejadorBoton2());
        botones = new HBox();
        botones.getChildren().addAll(btn,btn2);
        root = new BorderPane();
        root.setBottom(botones);
        botones.setAlignment(Pos.CENTER);
        root.setCenter(circulo);
        
        
        scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    class ManejadorBoton1 implements EventHandler<MouseEvent>
    {
        @Override
        public void handle(MouseEvent event) {
            if(circulo.getRadius() < 55.00)
                circulo.setRadius(circulo.getRadius()+cambiarRadio);
        } 
    }
    class ManejadorBoton2 implements EventHandler<MouseEvent>
    {

        @Override
        public void handle(MouseEvent event) {
            if(circulo.getRadius() > 5.00)
                circulo.setRadius(circulo.getRadius()-cambiarRadio);
        } 
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
