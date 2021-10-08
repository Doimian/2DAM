package src;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private static DatabaseMetaData metadata;
	
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
			metadata = conexion.getMetaData();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//Menu
		if(error == true)
		{
			try {
				Menu();
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("Error en el menu");
			}
		}
		
		
		Conexion.closeConexion();
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
	
	public static void Menu() throws SQLException
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
					mostrarDatosGeneralesSGBD(); //done
					break;
				case 2:
					mostrarDatosGeneralesTablas(); //done
					break;
				case 3:
					mostrarDatosGeneralesTabla(); //
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


	private static void mostrarProcedimientosAlmacenados() throws SQLException
	{

	}


	private static void mostrarClavesExternas() throws SQLException 
	{
		ResultSet tableData = metadata.getImportedKeys("academia", null, null);
		while(tableData.next())
		{
			String PKtableName = tableData.getString(3);
			String FKtableName = tableData.getString(7);
			String FKcolName = tableData.getString(8);
			String FKName = tableData.getString(13);
			System.out.println("Tabla: " + PKtableName + " esta referenciada por la tabla " + FKtableName + " en la columna " + FKcolName + " y el nombre de la clave externa es " + FKName);
		}
	}


	private static void mostrarClavesPrimarias() throws SQLException 
	{
		ResultSet tableData = metadata.getPrimaryKeys("academia", null, null);
		while(tableData.next());
		{
			String tableName = tableData.getString(3);
			String tableKeyCol = tableData.getString(4);
			String tableKeyName = tableData.getString(6);
			System.out.println("Tabla: " + tableName + ", Columna Primaria: " + tableKeyCol + ", Nombre de la Clave: " + tableKeyName);
		}
	}


	private static void mostrarColumnasTabla() throws SQLException 
	{
		System.out.println("Indica el nombre de la tabla que quieres conocer sus datos:");		
		String tabla = sc.nextLine();
		if(tabla.equals("alumno") || tabla.equals("curso")||tabla.equals("matricula"))
		{
			ResultSet tableData = metadata.getColumns("academia", null, tabla, null);
			System.out.println("Datos Generales de la tabla " + tabla + ": ");
			while(tableData.next())
			{
				String tableName = tableData.getString(3);
				String colName = tableData.getString(4);
				String dataType = tableData.getString(6);
				String canNull = tableData.getString(18);
				System.out.println("Tabla: " + tableName + ", Columna: " + colName + ", Tipo de datos: " + dataType + ", Is_nullable?: " + canNull);
			}		
		} else
			System.out.println("Nombre de tabla incorrecto");
	}


	private static void mostrarDatosGeneralesTabla() throws SQLException 
	{
		System.out.println("Indica el nombre de la tabla que quieres conocer sus datos:");		
		String tabla = sc.nextLine();
		if(tabla.equals("alumno") || tabla.equals("curso")||tabla.equals("matricula"))
		{
			ResultSet tableData = metadata.getTables("academia", null, tabla, null);
			while(tableData.next())
			{
				String catalog = tableData.getString(1);
				String table = tableData.getString(3);
				String type = tableData.getString(4);
				System.out.println("Base de Datos: " + catalog + ", Nombre: " +  table + ", Tipo: " + type);
			}			
		} else
			System.out.println("Nombre de tabla incorrecto");
	}


	private static void mostrarDatosGeneralesTablas() throws SQLException 
	{
		ResultSet tablesData = metadata.getTables("academia", null, null, null);
		while(tablesData.next())
		{
			String catalog = tablesData.getString(1);
			String table = tablesData.getString(3);
			String type = tablesData.getString(4);
			System.out.println("Base de Datos: " + catalog + ", Nombre: " +  table + ", Tipo: " + type);
		}
	}


	private static void mostrarDatosGeneralesSGBD() throws SQLException 
	{
		String databaseName = metadata.getDatabaseProductName();
		String driverName = metadata.getDriverName();
		String url = metadata.getURL();
		String userName = metadata.getUserName();
		System.out.println("Datos Generales del SGBD y la base de datos:");
		System.out.println("Nombre del SGBD: " + databaseName);
		System.out.println("Nombre del driver activo en la conexion: " + driverName);
		System.out.println("URL del SGBD: " + url);
		System.out.println("Nombre del usuario conectado : " + userName);
	}
}
