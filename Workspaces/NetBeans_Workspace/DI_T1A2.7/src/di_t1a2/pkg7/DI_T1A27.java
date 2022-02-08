/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg7;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author damian
 */
public class DI_T1A27 extends Application {
    private Ellipse ellipse;
    private FadeTransition ft;
    private StackPane root;
    private Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        ellipse = new Ellipse(10, 10, 100, 70);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.ORANGERED);
        
        ft = new FadeTransition(Duration.millis(2000),ellipse);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        
        ellipse.setOnMousePressed(e->ft.pause());
        ellipse.setOnMouseReleased(e->ft.play());
        root = new StackPane();
        root.getChildren().add(ellipse);
        
        scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
