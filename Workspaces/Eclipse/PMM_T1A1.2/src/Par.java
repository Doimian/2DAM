import java.awt.*;
import java.awt.event.*;

public class Par extends Frame implements ActionListener, WindowListener
{

	//Atributos
	private Label lbTexto1;
	private Label lbTexto2;
	private Button btnTest;
	private Button btnClear;
	private Panel botonera;
	private TextField textInput;
	
	public static void main(String[] args) 
	{
		// Instancia la clase
		Par par = new Par();

	}
	
	// Constructor
	public Par()
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
		btnTest.addActionListener(this);
		botonera.add(btnTest);
		this.add(botonera, BorderLayout.SOUTH);
		//Boton de borrado
		btnClear = new Button("Limpiar");
		btnClear.addActionListener(this);
		botonera.add(btnClear);
		
			//Etiqueta de resultado
		lbTexto2 = new Label();
		this.add(lbTexto2, BorderLayout.EAST);
		this.pack();
		
		// Asigna el listener
		this.addWindowListener(this);
		
		//Hacerla visible
		this.setVisible(true);
		
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) 
	{
		// Gestiona el evento Close de la Ventana
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

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
		// Identifica la fuente del evento
		Object source = arg0.getSource();
		if(source == btnTest)
		{
			// Comprueba que inputText no esta vacio
			if(textInput.getText().equals(""))
				lbTexto2.setText("Error");
			else
			{
				//Gestión del botón comprobar
				int numero = Integer.parseInt(textInput.getText());
				if(esPar(numero))
					lbTexto2.setText("Par");
				else 
					lbTexto2.setText("Impar");
			}

		}
		else if(source == btnClear)
		{
			//Gestión del botón clear
			textInput.setText("");
			lbTexto2.setText("");
		}
	}

	private boolean esPar(int n) 
	{
		return (n % 2 == 0);
	}

}
