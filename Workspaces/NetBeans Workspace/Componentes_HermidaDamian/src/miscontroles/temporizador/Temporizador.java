/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscontroles.temporizador;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import javafx.util.StringConverter;
import miscontroles.campotextonumerico.CampoTextoNumerico;

/**
 * FXML Controller class
 *
 * @author damian
 */
public class Temporizador extends HBox 
{
    @FXML
    private CampoTextoNumerico ctn;
    @FXML
    private Label contador;
    @FXML
    private Label magnitud;
    @FXML
    private Button btnCrear;

    //propiedad del tiempo
    private IntegerProperty tiempo = new SimpleIntegerProperty();
    
    public Temporizador()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        
        contador.setText("0");
        setTiempo(0);
        contador.textProperty().bind(tiempo.asString());
        
        magnitud.setText("s");
    }
    
    public Temporizador(int unidades, String magnitud)
    {
        //Cargamos el fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        //Ponemos el tiempo
        this.contador.setText("" + tiempo);
        
        //Definimos el interpolator
        
        //Iniciamos el valor tiempo
        setTiempo(unidades);
        
        //contador.textProperty().bind(tiempo.asString());
        
        //Conectamos el valor del label contador
        Bindings.bindBidirectional(contador.textProperty(), tiempoProperty(), new StringConverter<Number>() 
        {
            @Override
            public Integer fromString(String string) 
            {
                return getTiempo();
            }
            
            @Override
            public String toString(Number i) 
            {
                return "" + i;
            }
        });
        
        //Ponemos la magnitud
        this.magnitud.setText(magnitud);

        //Creamos el Timeline
        final Timeline timeline = new Timeline();
        Duration duracion = Duration.seconds(1);
        switch(magnitud)
        {
            case "s" :
                        duracion = Duration.seconds(unidades);
                        break;
            case "m" :
                        duracion = Duration.minutes(unidades);                            
                        break;
            case "h" :
                        duracion = Duration.hours(unidades);
                        break;
        }
        
        timeline.getKeyFrames().add( new KeyFrame(duracion, new KeyValue(tiempoProperty(), 0)));
        
        //contador.setText("" + String.valueOf(contador.getText()));
        //setTiempo("" + String.valueOf(contador.getText()));
        timeline.setOnFinished((ActionEvent event) -> {
        // Intentamos gestionar el evento con el handler que se le establezca a la propiedad onAction del componente. Si no mensaje.
        try {propertyOnAction.get().handle(event);}
        catch(NullPointerException npex) {System.out.println("\nNo hay manejador establecido, puede darle mayor funcionalidad al temporizador asignandole una accion a realizar cuando finalice el tiempo\n");}
            });

        timeline.play();
    }
    
    public final void setTiempo()
    {
        System.out.println("hola");
        Timeline timeline = new Timeline();
         timeline.getKeyFrames().add( new KeyFrame(Duration.seconds(1), new KeyValue(tiempoProperty(), 0)));
        
        //contador.setText("" + String.valueOf(contador.getText()));
        //setTiempo("" + String.valueOf(contador.getText()));
        
        timeline.setOnFinished((ActionEvent event) -> {
            fireEvent(event);
        });

        timeline.play();
    }
    
    
    public final IntegerProperty tiempoProperty() 
    {
        return tiempo;
    }
    public final void setTiempo(Integer value) 
    {
        tiempoProperty().set(value);
    }
    public final Integer getTiempo() 
    {
        return tiempoProperty().get();
    }
    
        // Propiedad para darle accion al componete que se ejecutará al finalizar el temporizador
    private ObjectProperty<EventHandler<ActionEvent>> propertyOnAction = new SimpleObjectProperty<>();

    
        // Metodo que devuelve el wrapper con el manejador de evento de la propiedad
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return propertyOnAction;
    }
    
    // Metodo que devuelve el manejador
    public final EventHandler<ActionEvent> getOnAction() {
        return propertyOnAction.get();
    }
    
    // Metodo que establece el manejador
    public final void setOnAction(EventHandler<ActionEvent> handler) {
        propertyOnAction.set(handler);
    }
}
