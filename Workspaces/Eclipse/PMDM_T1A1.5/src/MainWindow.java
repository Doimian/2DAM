import java.awt.*;
import java.awt.event.*;
public class MainWindow extends Frame implements WindowListener
{
	private Choice choicemenu;
	private TextArea content;
	public MainWindow()
	{
		setTitle("Choice Menu");
		setSize(500,400);
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
		content = new TextArea("");
		
		add(choicemenu);
		add(content);
		new ChoiceAction(content, choicemenu);
		
		choicemenu.addItemListener(new ItemListener()
				{
					@Override
					public void itemStateChanged(ItemEvent arg0) {
						int index = choicemenu.getSelectedIndex();
						String cont = "1 * " + index + " = " + 1 * index + 
									"\n2 * " + index + " = " + 2 * index + 
									"\n3 * " + index + " = " + 3 * index +
									"\n4 * " + index + " = " + 4 * index + 
									"\n5 * " + index + " = " + 5 * index +
									"\n6 * " + index + " = " + 6 * index +
									"\n7 * " + index + " = " + 7 * index +
									"\n8 * " + index + " = " + 8 * index + 
									"\n9 * " + index + " = " + 9 * index + 
									"\n10 * " + index + " = " + 10 * index + "\n";
						content.setText(cont);
					}});
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
