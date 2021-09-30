package prueba;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BorderPane extends Application {
    
    @Override
    public void init()
    {
        System.out.println("Inicio init");
    }
    
    @Override
    public void stop()
    {
        System.out.println("Inicio stop");
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Pane root = new Pane();
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
        @Override
        public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                showStage2(scene);
            }
        });
        
        
        
        /*
        Button btn2 = new Button();
        btn2.setText("Say 'Bye World'");
                btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Bye World!");
            }
        });
        root.getChildren().addAll(btn, btn2);
        */
        root.getChildren().add(btn);

        

    }
    public void showStage2(Scene e)
    {
        Stage stage2 = new Stage(StageStyle.UTILITY);
        stage2.setTitle("Otra ventana");
        stage2.setScene(e);
        stage2.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}