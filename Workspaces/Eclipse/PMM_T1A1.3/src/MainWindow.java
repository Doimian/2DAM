import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Frame;
import java.awt.GridLayout;

/*
 * Ventana principal de la aplicación 
 */
public class MainWindow extends Frame implements WindowListener
{
	//Atributos
	private Label lbTexto1;
	private Label lbTexto2;
	private Button btnTest;
	private Button btnClear;
	private Panel botonera;
	private TextField textInput;
	
	// Instancia la clase gestion de eventos de boton
	private ButtonEvent buttonEvent;
	
	//Constructor
	public MainWindow()
	{
		// Forma de la ventana
		this.setTitle("Actividad 1. Par-Impar");
		//this.setSize(400,370);
		
		// Añade componentes a la ventana
		//Layout
		this.setLayout(new BorderLayout());
			
		//Etiqueta1
		lbTexto1 = new Label("Numero");
		
		this.add(lbTexto1, BorderLayout.NORTH);
		
		// Crea el panel de botones
		
		botonera = new Panel();
		botonera.setLayout(new GridLayout(2,1));
		
			
		//Entrada de texto
		textInput = new TextField();
		this.add(textInput, BorderLayout.WEST);
		
		//Boton de comprobacion
		btnTest = new Button("Comprobar");
		botonera.add(btnTest);
		this.add(botonera, BorderLayout.SOUTH);
		
		//Boton de borrado
		btnClear = new Button("Limpiar");
		botonera.add(btnClear);
		
		//Etiqueta de resultado
		lbTexto2 = new Label();
		this.add(lbTexto2, BorderLayout.EAST);
		this.pack();
		
		// Asigna el listener
		this.addWindowListener(this);
		
		// Instancia la gestion de eventos
		buttonEvent = new ButtonEvent(btnTest, btnClear, lbTexto2, textInput);
		btnTest.addActionListener(buttonEvent);
		btnClear.addActionListener(buttonEvent);
		
		//Hacerla visible
		this.setVisible(true);
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) 
	{
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	

}
