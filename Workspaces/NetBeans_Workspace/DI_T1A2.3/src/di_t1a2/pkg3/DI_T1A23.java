/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a2.pkg3;

import static java.lang.Double.parseDouble;
import java.text.DecimalFormat;
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
    private Text texto1 = new Text();
    private Text texto2 = new Text();
    private Text texto3 = new Text();
    private Text texto4 = new Text();
    private Text texto5 = new Text();
    private TextField tf1 = new TextField();
    private TextField tf2 = new TextField();
    private TextField tf3 = new TextField();
    private TextField tf4 = new TextField();
    private TextField tf5 = new TextField();
    private Insets matrizPad;
    private Insets boton;
    private GridPane matriz;
    private DecimalFormat df;
    private Button btn;
            
        @Override
        public void start(Stage primaryStage) {
        texto1.setText("Annual Interest Rate:");
        texto2.setText("Number of Years:");
        texto3.setText("Loan Amount:");
        texto4.setText("Monthly Payment:");
        texto5.setText("Total Payment:");
        
        matrizPad = new Insets(2, 2, 2, 2);
        boton = new Insets(20, 20, 20, 20);
        matriz = new GridPane();
        matriz.setHgap(10);
        matriz.setVgap(10);
        matriz.addColumn(0, texto1, texto2, texto3, texto4, texto5);
        matriz.addColumn(1, tf1, tf2, tf3, tf4, tf5);
        
        btn = new Button();
        
        btn.setText("Say 'Hello World'");
        btn.setOnAction(e -> 
        {
            if(!tf1.getText().isEmpty() && !tf2.getText().isEmpty() && !tf3.getText().isEmpty())
            {
                double m;
                double h  = parseDouble(tf3.getCharacters().toString());
                double n  = parseDouble(tf2.getCharacters().toString());
                double i  = parseDouble(tf1.getCharacters().toString());
                double r = i/(100*12);
                double den = 1-(Math.pow((1+r),(-12*n)));
                double num = h*r;
                double fin = num/den;
                double total;
                m = h*r/Math.pow(1-(1+r),(-12*n));
                df = new DecimalFormat("#.## ???");
                m = 2.34543;
                total = fin *12 * n;
                String mf = df.format(fin);
                String ff = df.format(total);
                tf4.setText(mf);
                tf5.setText(ff);
            }
            else
            {
                tf4.setText("Llena los 3 primeros");
                tf5.setText("campos con datos");
            }
        });
        
        BorderPane root = new BorderPane();
        root.setCenter(matriz);
        //root.setBottom(boton);
        matriz.setAlignment(Pos.CENTER);
        matriz.setPadding(matrizPad);
        root.setBottom(btn);
        root.setAlignment(btn, Pos.CENTER_RIGHT);
        root.setMargin(btn, boton);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
