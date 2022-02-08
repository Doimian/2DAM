/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg8;

import com.sun.javafx.perf.PerformanceTracker;
import static java.lang.Math.random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Usuario
 */
public class DI_T1A28 extends Application {
    
    private static double ballXSpeed = ((Math.random()-0.5)*10);
    private static double ballYSpeed = ((Math.random()-0.5)*10);
    private Group pane;
    private Circle ball;
    private Label label;
    private Scene scene;
    private PerformanceTracker perfTracker;
    private Timeline animation;
    
    @Override
    public void start(Stage primaryStage) {
        pane = new Group();
        ball = new Circle(10);
        ball.setTranslateX(300 * 0.5);
        ball.setTranslateY(250 * 0.5);
        ball.setFill(Color.BLACK);
        label = new Label();
        label.setTranslateX(10);
        label.setTranslateY(10);
        pane.getChildren().addAll(ball,label);
        scene = new Scene(pane, 300, 300);
        EventHandler<ActionEvent> eH = e->{
             perfTracker = PerformanceTracker.getSceneTracker(scene);
            label.setText("FPS (Timeline) = "+perfTracker.getInstantFPS());
        
            if(ball.getTranslateX()< 0 || ball.getTranslateX()> 300)
            {
                ballXSpeed*=-1;
            }else if(ball.getTranslateY()< 0 || ball.getTranslateY()> 300)
            {
                ballYSpeed*=-1;
            }
            ball.setTranslateX(ball.getTranslateX()+ballXSpeed);
            ball.setTranslateY(ball.getTranslateY()+ballYSpeed);  
        };
        animation = new Timeline(new KeyFrame(Duration.millis(300),eH));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
