package GdoSatisfaccion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class GdoSatisfaccion extends VBox {

    @FXML
    private Slider slider;
    @FXML
    private ProgressBar pBar;
    @FXML
    private ProgressIndicator pInd;
    
    //Propiedad gradoStf
    public DoubleProperty gradoStf = new SimpleDoubleProperty();
    
    //Propiedad propertyOnAction
    private ObjectProperty<EventHandler<MouseEvent>> propertyOnAction = new SimpleObjectProperty<EventHandler<MouseEvent>>();
    
    public GdoSatisfaccion()
    {
        //Cargamos el componente
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GdoSatisfaccion.fxml"));    
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        //prueba
        //setGradoStf(25.6);
 
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                pBar.setProgress(new_val.doubleValue()/100);
                pInd.setProgress(new_val.doubleValue()/100);
                setGradoStf(new_val.doubleValue());
        });
  
        slider.setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        onActionProperty().get().handle(event);
                    }
        });
        
        
    }
    
    //Métodos de la propiedad gradoStf
    public Double getGradoStf()
    {
        return gradoStfProperty().get();
    }
    
    public DoubleProperty gradoStfProperty()
    {
        return gradoStf;
    }
    
    public void setGradoStf(Double value)
    {
        gradoStfProperty().set(value);
    }
    
    //Métodos de la propiedad propertyonaction
        public final ObjectProperty<EventHandler<MouseEvent>> onActionProperty() 
    {
        return propertyOnAction;
    }
    
    public final void setOnAction(EventHandler<MouseEvent> handler) 
    {
        propertyOnAction.set(handler);
    }
    
    public final EventHandler<MouseEvent> getOnAction() 
    {
        return propertyOnAction.get();
    }
}
