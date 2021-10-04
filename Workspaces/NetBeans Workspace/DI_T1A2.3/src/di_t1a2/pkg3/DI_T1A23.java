/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class DI_T1A23 extends Application {
    Text texto1 = new Text();
    Text texto2 = new Text();
    Text texto3 = new Text();
    Text texto4 = new Text();
    Text texto5 = new Text();
    TextField tf1 = new TextField();
    TextField tf2 = new TextField();
    TextField tf3 = new TextField();
    TextField tf4 = new TextField();
    TextField tf5 = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        texto1.setText("Annual Interest Rate:");
        texto2.setText("Number of Years:");
        texto3.setText("Loan Amount:");
        texto4.setText("Monthly Payment:");
        texto5.setText("Total Payment:");
        
        Insets button = new Insets(0, 0, 0, 80.00);
        Insets matrizPad = new Insets(2, 2, 2, 2);
        
        GridPane matriz = new GridPane();
        
        matriz.addColumn(0, texto1, texto2, texto3, texto4, texto5);
        matriz.addColumn(1, tf1, tf2, tf3, tf4, tf5);
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        BorderPane root = new BorderPane();
        root.setCenter(matriz);
        matriz.setAlignment(Pos.CENTER);
        matriz.setPadding(matrizPad);
        btn.setPadding(button);
        root.setBottom(btn);
        
        
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
