package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio5 
{

	private static String SGBD;
	private static String database;
	private static String usuario;
	private static String clave;
	private static Conexion crearConexion;
	private static Statement statement;
	private static PreparedStatement stat;
	private static Scanner sc;
	private static Connection conexion;
	
	public static void main(String[] args) 
	{
		boolean error = false;
		//Cargar el Driver
		sc = new Scanner(System.in);
		System.out.println("SGBD: ");
		SGBD = sc.nextLine();
		if(!SGBD.equals("mysql"))
		{
			System.out.println("Por ahora este programa solo soporta mysql");
			return;
		}
			
		
		//Conectar con la base de datos
		System.out.println("Base de datos: ");
		database = sc.nextLine();
		System.out.println("Usuario: ");
		usuario = sc.nextLine();
		System.out.println("Clave: ");
		clave = sc.nextLine();
		
		try {
			conexion = Conexion.getConexion(SGBD, database, usuario, clave);
			System.out.println("Conexion exitosa con la base de datos");
			 error = true;
		} catch (SQLException e) {
			System.out.println("No se ha podido acceder a la base de datos");
			e.printStackTrace();
			
		}
		try {
			statement = conexion.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//Menu
		if(error == true)
		{
			//Menu();
		}
		
		
		Conexion.closeConexion();
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
	
	public static void Menu()
	{
		int contador = 0;
		String limpiacarro;
		while(contador != 7)
		{
			System.out.println("\nMenu del ejercicio 5:");
			System.out.println("1. Mostrar datos generales del SGBD y la base de datos");
			System.out.println("2. Mostrar datos de todas las tablas");
			System.out.println("3. Mostrar los datos de una tabla");
			System.out.println("4. Mostrar las columnas de una tabla");
			System.out.println("5. Mostrar las claves primarias de una tabla");
			System.out.println("6. Mostrar las claves externas asociadas a la clave primaria de una tabla");
			System.out.println("7. Mostrar los procedimientos almacenados a la base de datos conectada");
			contador = sc.nextInt();
			limpiacarro = sc.nextLine();
			switch(contador)
			{
				case 1:
					mostrarDatosGeneralesSGBD();
					break;
				case 2:
					mostrarDatosGeneralesTablas();
					break;
				case 3:
					mostrarDatosGeneralesTabla();
					break;
				case 4:
					mostrarColumnasTabla();
					break;
				case 5:
					mostrarClavesPrimarias();
					break;
				case 6:
					mostrarClavesExternas();
					break;
				case 7:
					mostrarProcedimientosAlmacenados();
				case 8:
					System.out.println("Bye...");
					return;
			}
		}
	}


	private static void mostrarProcedimientosAlmacenados() 
	{

		
	}


	private static void mostrarClavesExternas() 
	{

		
	}


	private static void mostrarClavesPrimarias() 
	{

		
	}


	private static void mostrarColumnasTabla() 
	{

		
	}


	private static void mostrarDatosGeneralesTabla() 
	{

		
	}


	private static void mostrarDatosGeneralesTablas() 
	{
	
		
	}


	private static void mostrarDatosGeneralesSGBD() 
	{
	
		
	}
}
