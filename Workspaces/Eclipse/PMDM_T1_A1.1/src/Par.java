import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Par extends Frame implements ActionListener, WindowListener
{

	//Atributos
	private Label lbTexto1;
	private Label lbTexto2;
	private Button btnTest;
	private Button clear;
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
		this.setSize(200,200);
		
		// Añade componentes a la ventana
		
			//Layout
		this.setLayout(new FlowLayout());
			
			//Etiqueta1
		lbTexto1 = new Label("Numero: ");
		this.add(lbTexto1);
			
			//Entrada de texto
		textInput = new TextField();
		this.add(textInput);
		
			//Boton de comprobacion
		btnTest = new Button("Comprobar");
		btnTest.addActionListener(this);
		
			//Boton de limpieza
		clear = new Button("Clear");
		clear.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						lbTexto2.setText("");
						textInput.setText("");
					}
				});
		
		
			//Etiqueta de resultado
		lbTexto2 = new Label("                     ");
		add(lbTexto2);
		add(btnTest);
		add(clear);
		
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
		
		System.out.println("Pulsado");
		try
		{
			int numero = Integer.parseInt(textInput.getText());
			if(esPar(numero))
				lbTexto2.setText("Par");
			else 
				lbTexto2.setText("Impar");
		} catch(NumberFormatException x)
		{
			lbTexto2.setText("Error");
		}
	}

	private boolean esPar(int n) 
	{
		return (n % 2 == 0);
	}

}
