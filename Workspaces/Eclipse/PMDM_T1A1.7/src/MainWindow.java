



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow extends JFrame 
{
	private static JTextField value1;
	private static JTextField value2;
	private static JLabel result;
	private JLabel resultlbl;
	private JLabel value1lbl;
	private JLabel value2lbl;
	private JButton suma;
	private JButton resta;
	private JButton multiplicacion;
	private JButton division;
	private JButton potencia;
	private JButton raiz;	
	private Actions actionHandler;
	
	public MainWindow() 
	{
		value1lbl = new JLabel("1er Numero:");
		value2lbl = new JLabel("2do Numero:");
		resultlbl = new JLabel("Resultado:");
		value1 = new JTextField("           ");
		value2 = new JTextField("           ");
		result = new JLabel("           ");
		suma = new JButton("+");
		resta = new JButton("-");
		multiplicacion = new JButton("*");
		division = new JButton("/");
		potencia = new JButton("^");
		raiz = new JButton("./");
	
		setTitle("Calculadora");
		setSize(400,100);
		setContentPane(new JPanel());
		
		suma.addMouseListener(actionHandler);
		resta.addMouseListener(actionHandler);
		multiplicacion.addMouseListener(actionHandler);
		division.addMouseListener(actionHandler);
		potencia.addMouseListener(actionHandler);
		raiz.addMouseListener(actionHandler);
		
		this.getContentPane().add(value1lbl);
		this.getContentPane().add(value1);
		this.getContentPane().add(value2lbl);
		this.getContentPane().add(value2);
		this.getContentPane().add(resultlbl);
		this.getContentPane().add(result);
		
		this.getContentPane().add(suma);
		this.getContentPane().add(resta);
		this.getContentPane().add(multiplicacion);
		this.getContentPane().add(division);
		this.getContentPane().add(potencia);
		this.getContentPane().add(raiz);
		
		result.setText("asdfasdf");
		
		setVisible(true);
	}
	public static String getValue1()
	{
		return value1.getText();
	}
	public static String getValue2()
	{
		return value2.getText();
	}
	public static void setResult(String a)
	{
		result.setText(a);
	}
}
