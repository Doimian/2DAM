import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * Clase que se encarga de la gestión de los eventos del botón
 */

public class ButtonEvent implements ActionListener 
{
	
	// Atributos
	private Label lbTexto2;
	private Button btnTest;
	private Button btnClear;
	private TextField textInput;
	
	public ButtonEvent(Button btnTest, Button btnClear, Label lbTexto2, TextField textInput)
	{
		this.btnTest = btnTest;
		this.btnClear = btnClear;
		this.lbTexto2 = lbTexto2;
		this.textInput = textInput;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		// Identifica la fuente del evento
		Object source = e.getSource();
		if(source == btnTest)
		{
			// Comprueba que inputText no esta vacio
			if(textInput.getText().equals(""))
				lbTexto2.setText("Error");
			else
			{
				//Gestión del botón comprobar
				int numero = Integer.parseInt(textInput.getText());
				if(esPar(numero))
					lbTexto2.setText("Par");
				else 
					lbTexto2.setText("Impar");
			}

		}
		else if(source == btnClear)
		{
			//Gestión del botón clear
			textInput.setText("");
			lbTexto2.setText("");
		}
	}
	
	private boolean esPar(int n) 
	{
		return (n % 2 == 0);
	}	
}