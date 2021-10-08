import java.awt.*;
import java.awt.event.*;
public class MainWindow extends Frame implements WindowListener
{
	private Label lblFib;
	private TextField Fib;
	private Button btnFib;
	private Label lblFibRes;
	private Events btnEvent;
	
	public MainWindow()
	{
		this.setTitle("Fibonacci");
		this.setSize(200,200);
		this.setLayout(new FlowLayout());
		
		Fib = new TextField("");
		lblFib = new Label("Digitos para mostrar");
		lblFibRes = new Label("                                         ");
		btnFib = new Button("Generar Serie");
		
		add(lblFib);
		add(Fib);
		add(lblFibRes);
		add(btnFib);
		
		btnEvent = new Events(btnFib, Fib, lblFibRes);
		
		btnFib.addActionListener(btnEvent);
		
		this.addWindowListener(this);
		this.setVisible(true);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
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
