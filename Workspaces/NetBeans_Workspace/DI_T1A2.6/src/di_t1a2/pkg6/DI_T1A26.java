/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg6;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Usuario
 */
public class DI_T1A26 extends Application {
    private Circle circle;
    private Rectangle rectangle;
    private PathTransition pt;
    private StackPane root;
    private Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        root = new StackPane();
        scene = new Scene(root, 300, 250);
        circle = new Circle(125, 100, 50);
        circle.centerXProperty().bind(root.widthProperty().divide(2));
        circle.centerYProperty().bind(root.heightProperty().divide(2));
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        
        rectangle = new Rectangle(20,40);
        rectangle.setFill(Color.ORANGE);
        rectangle.setX(circle.getCenterX() - 10);
        rectangle.setY(circle.getCenterY() - 20);
        
        pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circle);
        pt.setNode(rectangle);
        
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();// Start animation
        
        circle.setOnMousePressed(e->pt.pause());
        circle.setOnMouseReleased(e->pt.play());
        
        
        root.getChildren().addAll(circle,rectangle);
        

        
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
