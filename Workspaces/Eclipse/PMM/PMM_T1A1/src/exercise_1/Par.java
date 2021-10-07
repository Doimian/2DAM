package exercise_1;

import java.awt.*;
import java.awt.event.*;

public class Par extends Frame implements ActionListener, WindowListener
{

	//Atributos
	private Label lbTexto1;
	private Label lbTexto2;
	private Button btnTest;
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
		this.setSize(400,370);
		
		// Añade componentes a la ventana
		
			//Layout
		this.setLayout(new FlowLayout());
			
			//Etiqueta1
		lbTexto1 = new Label("Numero");
		this.add(lbTexto1);
			
			//Entrada de texto
		textInput = new TextField();
		this.add(textInput);
		
			//Boton de comprobacion
		btnTest = new Button("Comprobar");
		btnTest.addActionListener(this);
		add(btnTest);
		
			//Etiqueta de resultado
		lbTexto2 = new Label();
		add(lbTexto2);
		
		
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
	public void actionPerformed(ActionEvent e) 
	{
		// Codigo para gestionar el evento del boton btnText
		System.out.println("Pulsado");
		int numero = Integer.parseInt(textInput.getText());
		
		if(textInput.getText().equals(""))
			lbTexto2.setText("Vacio");
		else if(esPar(numero))
			lbTexto2.setText("Par");
		else 
			lbTexto2.setText("Impar");
	}

	private boolean esPar(int n) 
	{
		return (n % 2 == 0);
	}

}
