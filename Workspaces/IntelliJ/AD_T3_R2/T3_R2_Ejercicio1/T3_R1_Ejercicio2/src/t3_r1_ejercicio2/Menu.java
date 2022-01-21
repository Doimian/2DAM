/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3_r1_ejercicio2;

/**
 *
 * @author Luis
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    	
    	//Atributos
    	private String titulo;
	private HashMap<Integer, String>opciones;
	
	
	public Menu()
	{
		titulo = "";
		opciones = new HashMap<Integer, String>();
	}
	
	
	public void setTitulo(String titulo)
	{
		this.titulo = "..." + titulo + "...";
	}
	
	
	//Añade nueva opcion
	public void addOption(int index, String descripcion)
	{
		opciones.put(index, descripcion);
	}
	
	
	//Retorna la opcion de menu seleccionada
	public int getOpcion()
	{
		Scanner input = new Scanner(System.in);
		
		//Pide un entero
		int opcion = input.nextInt();
		
		//Crea un conjunto (conjunto = set), para almacenar las claves de clave valor
		Set<?> misClaves = opciones.keySet();
		
		//Comprueba si la opcion tecleda está en las claves del menu
		if(misClaves.contains(opcion))
			return opcion;
		else
			return -1;
		
		
		
	}

	
	public String toString() 
	{
		// titulo
		String menu = titulo + "\n";
		
		//Recorre el HashMap obteniendo el par (clave, valor). keySet devuelve el conjunto de clves.
		Set<?> misClaves = opciones.keySet();// No hay que añadorle el tipo al set, asi coge todos de forma generica
		Iterator<?> it = misClaves.iterator();
		while(it.hasNext())
		{
			//Toma la clave. En el iterador, siempre la fincion next() nos devuelve un objeto Object, hay que hacerle conversion de tipo obligatoriamente
			int clave = (int)it.next();
			
			//Concatena la clave al menu
			menu += clave + ". ";
			
			//Obtiene el valor de la clave (clave, valor), get(key), devuelve el valor de la clave
			menu += opciones.get(clave) + "\n";
		}
		
		return menu + "\n" + "[Opcion]: ";
	}
}
