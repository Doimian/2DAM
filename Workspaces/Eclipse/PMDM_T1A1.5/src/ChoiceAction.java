import java.awt.*;
import java.awt.event.*;
public class ChoiceAction implements ActionListener
{
	private Label content;
	private Choice choicemenu;
	public ChoiceAction(Label content, Choice choicemenu)
	{
		this.choicemenu = choicemenu;
		this.content = content;
	}
	public void actionPerformed(ActionEvent e) 
	{
			int x = choicemenu.getSelectedIndex();
			content.setText("" + x);
	}

}
