import java.awt.*;
import java.awt.event.*;
public class MainWindow extends Frame implements WindowListener
{
	private Choice choicemenu;
	private ChoiceAction choiceEvent;
	private Label content;
	public MainWindow()
	{
		setTitle("Choice Menu");
		setSize(400,400);
		setLayout(new FlowLayout());
		addWindowListener(this);
		
		choicemenu = new Choice();
		choicemenu.add("0");
		choicemenu.add("1");
		choicemenu.add("2");
		choicemenu.add("3");
		choicemenu.add("4");
		choicemenu.add("5");
		choicemenu.add("6");
		choicemenu.add("7");
		choicemenu.add("8");
		choicemenu.add("9");
		choicemenu.add("10");
		content = new Label("\n\n\n\n\n\n\n\n\n\n");
		
		add(choicemenu);
		choiceEvent = new ChoiceAction(content, choicemenu);
		
		choicemenu.addActionListener(choiceEvent);
		
		
		
		
		setVisible(true);
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
