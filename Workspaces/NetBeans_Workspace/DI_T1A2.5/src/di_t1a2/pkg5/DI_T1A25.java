/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DI_T1A25 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text txt = new Text(20,20,"A");
        Pane root = new Pane();
        root.getChildren().add(txt);
        
        Scene scene = new Scene(root, 100, 100);
        scene.setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.DOWN)
            {
                txt.setY(txt.getY() + 10);
                
            } else if(e.getCode() == KeyCode.UP)
            {
                txt.setY(txt.getY() - 10);
            } else if(e.getCode() == KeyCode.LEFT)
            {
                txt.setX(txt.getX() - 10);
            } else if(e.getCode() == KeyCode.RIGHT)
            {
                txt.setX(txt.getX() + 10);
            } else if(e.getCode().isDigitKey() || e.getCode().isLetterKey())
            {
                txt.setText(e.getCode().getName());
            }
        });
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
