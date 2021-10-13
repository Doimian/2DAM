import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class Actions implements MouseInputListener
{

	@Override
	public void mouseClicked(MouseEvent e)
	{
		/*int num1 = Integer.parseInt(MainWindow.getValue1());
		int num2 = Integer.parseInt(MainWindow.getValue1());
		if(e.getSource().equals("suma"))
		{
			MainWindow.setResult("a");
		}*/
		MainWindow.setResult("hola");
	}

	@Override
	public void mousePressed(MouseEvent e){MainWindow.setResult("hola");}

	@Override
	public void mouseReleased(MouseEvent e){MainWindow.setResult("hola");}

	@Override
	public void mouseEntered(MouseEvent e){MainWindow.setResult("hola");}

	@Override
	public void mouseExited(MouseEvent e){MainWindow.setResult("hola");}

	@Override
	public void mouseDragged(MouseEvent e){MainWindow.setResult("hola");}

	@Override
	public void mouseMoved(MouseEvent e){MainWindow.setResult("hola");}
		
}
