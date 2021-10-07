import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Rectangle extends Frame implements ActionListener, WindowListener
{
	private TextField base;
	private TextField altura;
	private Label lblBase;
	private Label lblAltura;
	private Label area;
	private Button comp;
	private Button clear;
	
	public static void main(String[] args)
	{
		Rectangle rec = new Rectangle();
	}
	
	public Rectangle()
	{
		setTitle("Ejercicio 2");
		setSize(200, 200);
		
		setLayout(new FlowLayout());
		
		lblBase = new Label("Base: ");
		lblAltura = new Label("Altura: ");
		base = new TextField();
		altura = new TextField();
		area = new Label("                         ");
		comp = new Button("Calcular area");
		clear = new Button("Limpiar");
		
		comp.addActionListener(this);
		clear.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
							area.setText("                         ");	
							base.setText("");
							altura.setText("");
					}
				});
		add(lblBase);
		add(base);
		add(lblAltura);
		add(altura);
		add(area);
		add(comp);
		add(clear);
		
		
		addWindowListener(this);
		
		setVisible(true);
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
		
		if(base.getText().equals("") || altura.getText().equals(""))
		{
			area.setText("Campos vacios");
		}
		else
		{
			try
			{
				int numero1 = Integer.parseInt(base.getText());
				int numero2 = Integer.parseInt(altura.getText());
				String x = "Area = " + numero1 * numero2;
				area.setText(x);
			} catch(NumberFormatException x)
			{
				area.setText("Error");
			};
			

		}
		
	}

	private boolean esPar(int n) 
	{
		return (n % 2 == 0);
	}

}
