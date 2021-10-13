import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
public class MainWindow extends JFrame 
{
	private JButton boton;
	private BufferedImage image;
	private JLabel lblimage;
	public MainWindow() throws MalformedURLException, IOException
	{
		setTitle("Calcular Triangulo");
		image = ImageIO.read(new URL("/images/triangulo.jpg"));
		lblimage = new JLabel();
		
		
		setVisible(true);
		
	}
}
