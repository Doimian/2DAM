/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_fxml.version1._test2_tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class DI_FXMLVersion1_Test2_TableView extends Application 
{
    private final TableView table = new TableView();
    private Scene scene;
    private final Label label = new Label("Address Book");
    private TableColumn firstNameCol;
    private TableColumn lastNameCol;
    private TableColumn emailCol;
    private final VBox vbox = new VBox();
    private TableColumn firstEmailCol;
    private TableColumn secondEmailCol;
    private final ObservableList<Person> data = 
            FXCollections.observableArrayList
            (
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")
            );
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) 
    {
        
        scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(400);
        stage.setHeight(500);
        
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        
        //Primer registro de informacion
        firstNameCol = new TableColumn("First Name");
        firstNameCol.setResizable(false);
        firstNameCol.setCellValueFactory
        (
            new PropertyValueFactory<>("firstName")
        );
        
        lastNameCol = new TableColumn("Last Name");
        lastNameCol.setResizable(false);
        lastNameCol.setCellValueFactory
        (
            new PropertyValueFactory<>("lastName")
        );
        
        emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setResizable(false);
        emailCol.setCellValueFactory
        (
            new PropertyValueFactory<>("email")
        );
        
        




        
        
        
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        table.setItems(data);
        
        ((Group)scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
}
    
}   



