import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Almacena los datos para escritura en fichero
 * 
 */
public class Data 
{
	// Atributos para escritura en fichero
	private String nombre;
	private String apellidos;
	private String domicilio;
	private String dni;
	private int anioNacimiento;
	private String estadoCivil;
	private int numeroHijos;
	private String situacionLaboral;
	private String observaciones;
	private JFrame window;
	//Constructor
	public Data(JFrame window)
	{
		// Inicializan los atributos
		
		//Se enlaza con la ventana padre
		this.window = window;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) 
	{
		this.apellidos = apellidos;
	}

	public void setDomicilio(String domicilio) 
	{
		this.domicilio = domicilio;
	}

	public void setDni(String dni) 
	{
		this.dni = dni;
	}

	public void setAnioNacimiento(int anioNacimiento) 
	{
		this.anioNacimiento = anioNacimiento;
	}

	public void setEstadoCivil(String estadoCivil) 
	{
		this.estadoCivil = estadoCivil;
	}

	public void setNumeroHijos(int numeroHijos) 
	{
		this.numeroHijos = numeroHijos;
	}

	public void setSituacionLaboral(String situacionLaboral) 
	{
		this.situacionLaboral = situacionLaboral;
	}

	public void setObservaciones(String observaciones) 
	{
		this.observaciones = observaciones;
	}
	
	//Método para escritura TEXTO ASCII
	public void toTextFile(String fileName)
	{
		FileWriter file = null;
		
		try
		{
			// Crea fichero
			file = new FileWriter(fileName);
			
			// Escribe los datos
			file.write(nombre);
			file.write(apellidos);
			file.write(domicilio);
			file.write(dni);
			file.write("" + anioNacimiento);//String.valueOf(anioNacimiento));
			file.write(estadoCivil);
			file.write(String.valueOf(numeroHijos));
			file.write(String.valueOf(situacionLaboral));
			file.write(String.valueOf(observaciones));
		} catch(FileNotFoundException e)
		{
			JOptionPane msg = new JOptionPane();
			msg.showMessageDialog(this.window, "Error al crear fichero");
		} catch(IOException e)
		{
			JOptionPane msg = new JOptionPane();
			msg.showMessageDialog(this.window, "Error de escritura en el fichero");
		}
		
		// Cierra fichero
		try
		{
			file.close();
			JOptionPane msg = new JOptionPane();
			msg.showMessageDialog(this.window, "Escritura correcta");
		}catch(IOException e)
		{
			JOptionPane msg = new JOptionPane();
			msg.showMessageDialog(this.window, "Error al cerrar fichero");	
		}
	}
}
