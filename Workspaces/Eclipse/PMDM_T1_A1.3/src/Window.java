import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends Frame implements WindowListener, ActionListener
{
	TextField numField;
	Label lblNum;
	Button calc;
	Label res;
	
	public Window()
	{
		this.setTitle("Factorial");
		this.setSize(200,200);
		setLayout(new FlowLayout());
		
		res = new Label("                   ");
		calc = new Button("Calcular Factorial");
		lblNum = new Label("Num para factorizar;");
		numField = new TextField();
		calc.addActionListener(this);
		
		add(lblNum);
		add(numField);
		add(res);
		add(calc);
		
		this.addWindowListener(this);
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
		if(numField.getText().equals(""))			
		{
			res.setText("");
		} else
		{
			int numero = Integer.parseInt(numField.getText());
			
			String str = "Area = " + calcFact(numero);
			res.setText(str);
		}
	}
	
	public int calcFact(int a)
	{
		int x = a;
		for(int i = (a-1); i > 0; i--)
		{
			x *= i;
		}
		return x;
	}
}
