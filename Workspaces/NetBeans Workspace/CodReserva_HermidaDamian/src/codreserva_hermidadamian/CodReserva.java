/*
 * Damián Hermida Ramos
 * Examen 1er Trimestre Desarrollo de Interfaces
 * Controlador del componente CodReserva
 */
package codreserva_hermidadamian;

import java.io.IOException;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CodReserva extends VBox 
{
    @FXML
    private TextField tfNumRes;
    @FXML
    private PasswordField tfCodPin;
    @FXML
    private Button btnIr;
    
    private StringProperty NumReserva = new SimpleStringProperty();
    private StringProperty CodePin = new SimpleStringProperty();
    private BooleanProperty Acceso = new SimpleBooleanProperty();
    
    private ObjectProperty<EventHandler<ActionEvent>> propertyOnAction = new SimpleObjectProperty<EventHandler<ActionEvent>>();

    public CodReserva()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CodReserva.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try
        {
            fxmlLoader.load();
        }catch(IOException exception) {
            throw new RuntimeException(exception);
        }
        setAcceso(Boolean.FALSE);

        btnIr.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event) 
            {
                setNumReserva(tfNumRes.getText());
                setCodePin(tfCodPin.getText());
                
                if(Integer.valueOf(getNumReserva()) > 10000000 && Integer.valueOf(getNumReserva()) < 20000000 && Integer.valueOf(getCodePin()).equals(1928)) {
                    setAcceso(Boolean.TRUE);
                } else {
                    setAcceso(Boolean.FALSE);
                }
                    
                onActionProperty().get().handle(event);
            }
        });
    }
    
    //Propiedad NumReserva
    public String getNumReserva() {
        return numReservaProperty().get();
    }
    
    public void setNumReserva(String value)
    {
        numReservaProperty().set(value);
    }

    public StringProperty numReservaProperty() 
    {
        return NumReserva;
    }
    
    
    //Propiedad CodPin
    public String getCodePin() {
        return codePinProperty().get();
    }

    public StringProperty codePinProperty() 
    {
        return CodePin;
    }    
    public void setCodePin(String value)
    {
        codePinProperty().set(value);
    }
    
    //Propiedad Acceso
    public Boolean getAcceso()
    {
        return AccesoProperty().get();
    }
    
    public void setAcceso(Boolean value)
    {
        AccesoProperty().set(value);
    }
    
    public BooleanProperty AccesoProperty()
    {
        return Acceso;
    }
    
    //Propiedad del Handler del boton
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() 
    {
        return propertyOnAction;
    }
    
    public final void setOnAction(EventHandler<ActionEvent> handler) 
    {
        propertyOnAction.set(handler);
    }
    
    public final EventHandler<ActionEvent> getOnAction() 
    {
        return propertyOnAction.get();
    }
}
