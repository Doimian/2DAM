import java.awt.*;
import java.awt.event.*;
public class ChoiceAction implements ActionListener
{
	private TextArea content;
	private Choice choicemenu;
	public ChoiceAction(TextArea content2, Choice choicemenu)
	{
		this.choicemenu = choicemenu;
		this.content = content2;
	}
	public void actionPerformed(ActionEvent e) 
	{
			int x = choicemenu.getSelectedIndex();
			content.setText("" + x);
	}

}
