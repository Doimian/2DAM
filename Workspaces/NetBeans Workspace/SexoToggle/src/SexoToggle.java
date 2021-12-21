/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class SexoToggle extends VBox {

    @FXML
    private RadioButton rbFem;
    @FXML
    private ToggleGroup SexoToggleGroup;
    @FXML
    private RadioButton rbMas;
    @FXML
    private ImageView imgView;

    //properties
    private StringProperty sexo;
    
    public SexoToggle()
    {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SexoToggle.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        rbFem.setSelected(true);
        
        sexo = new SimpleStringProperty();
        
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    public StringProperty sexoProperty()
    {
        return sexo;
    }
    
    public void setSexo(String valor)
    {
        sexoProperty().set(valor);
    }
    
    public String getSexo()
    {
        return sexoProperty().get();
    }
    
}
