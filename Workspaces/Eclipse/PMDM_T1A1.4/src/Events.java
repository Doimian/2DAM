import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Events implements ActionListener 
{
	private Button btnFib;
	private TextField Fib;
	private Label lblFibRes;
	
	public Events(Button btnFib, TextField Fib, Label lblFibRes)
	{
		this.btnFib = btnFib;
		this.Fib = Fib;
		this.lblFibRes = lblFibRes;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int f = 0;
		int t1 = 1;
		int t2;
		String fibx = "";
		try
		{
			for(int lon = Integer.parseInt(Fib.getText()); lon > 0; lon--)
			{
				t2 = f;
				f = t1 + f;
				t1 = t2;
				fibx += t1;
			}
			lblFibRes.setText(fibx);
		} catch(NumberFormatException m)
		{
			lblFibRes.setText("Error");
		}
	}
}
