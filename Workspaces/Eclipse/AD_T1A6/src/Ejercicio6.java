
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio6
{

	private static String SGBD;
	private static String database;
	private static String usuario;
	private static String clave;
	private static Conexion crearConexion;
	private static Statement statement;
	private static PreparedStatement pstatement;
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
		if(!SGBD.equals("mysql") && !SGBD.equals("hsqldb"))
		{
			System.out.println("Por ahora este programa solo soporta mysql y hsqldb");
			return;
		}
			
		
		//Conectar con la base de datos
		System.out.println("Base de datos: ");
		database = sc.nextLine();
		if(SGBD.equals("mysql"))
		{
			System.out.println("Usuario: ");
			usuario = sc.nextLine();
			System.out.println("Clave: ");
			clave = sc.nextLine();
		}

		if(SGBD.equals("mysql"))
		{
			try {
				conexion = Conexion.getConexion(SGBD, database, usuario, clave);
				System.out.println("Conexion exitosa con la base de datos");
				 error = true;
			} catch (SQLException e) {
				System.out.println("No se ha podido acceder a la base de datos");
				e.printStackTrace();
				
			} catch (ClassNotFoundException e) {
				System.out.println("La conexion no ha podido ser establecida");	
			}
		}
		else if(SGBD.equals("hsqldb"))
		{
			try {
				conexion = Conexion.getConexion(SGBD, database);
				statement = conexion.createStatement();
				System.out.println("Conexion exitosa con la base de datos");
				 error = true;
			} catch (SQLException e) {
				System.out.println("No se ha podido acceder a la base de datos");
				error = false;
				
			} catch (ClassNotFoundException e) {
				System.out.println("La conexion no ha podido ser establecida");
				error = false;
			}
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
			System.out.println("1. Mostrar todos los datos de los alumnos");
			System.out.println("2. Mostrar todos los datos de los profesores");
			System.out.println("3. Mostrar las asignaturas impartidas por un profesor");
			System.out.println("4. Mostrar los alumnos matriculados en una asignatura");
			System.out.println("5. Salir de la aplicacion");
			contador = sc.nextInt();
			limpiacarro = sc.nextLine();
			switch(contador)
			{
				case 1:
					mostrarDatosAlumnos();
					break;
				case 2:
					mostrarDatosProfesores();
					break;
				case 3:
					mostrarAsignaturasProfesores(); 
					break;
				case 4:
					mostrarAlumnosMatriculados();
					break;
				case 5:	
					System.out.println("Bye...");
					return;
			}
		}
	}


	private static void mostrarDatosAlumnos() throws SQLException 
	{
		String sql = "Select * from alumno";	
		ResultSet tableData = statement.executeQuery(sql);
		System.out.println("Datos de los alumnos:");
		while(tableData.next())
		{
			System.out.println(tableData.getString(1));
		}
	}


	private static void mostrarDatosProfesores() throws SQLException 
	{
		String sql = "Select * from profesor";
		ResultSet tableData = statement.executeQuery(sql);
		System.out.println("Datos de los profesores:");
		while(tableData.next())
		{
			System.out.println(tableData.getString(1) + ";\t" + tableData.getString(2) + ";\n" + tableData.getString(3) + ";\n" + tableData.getString(4));
		}
	}


	private static void mostrarAsignaturasProfesores() throws SQLException 
	{
		String dniProf;
		System.out.println("Indica el DNI del profesor:");
		dniProf = sc.nextLine();
		String sql = "Select profesor.nombre, asignatura.nombre from profesor join imparte on (profesor.dni_prof=imparte.dni_prof) join asignatura on (asignatura.cod_asig=imparte.cod_asig) where profesor.dni_prof = ?";
		pstatement = conexion.prepareStatement(sql);
		
		ResultSet tableData = pstatement.executeQuery();
		System.out.println("Profesor\tAsignatura");
		while(tableData.next())
		{
			System.out.println(tableData.getString(1) + ";\t" + tableData.getString(2));
		}
	}


	private static void mostrarAlumnosMatriculados() throws SQLException 
	{
		int codAsig;
		String limpiaScanner;
		System.out.println("Indica el codigo de la asignatura:");
		codAsig = sc.nextInt();
		limpiaScanner = sc.next();
		String sql = "Select asignatura.nombre, alumno.nombre from alumno join matricula on (alumno.dni=matricula.dni) join asignatura on (asignatura.cod_asig=matricula.cod_asig) where asignatura.cod =" + codAsig;
		ResultSet tableData = statement.executeQuery(sql);
		System.out.println("Datos de los alumnos:");
		System.out.println("Asignatura\tAlumno");
		while(tableData.next())
		{
			System.out.println(tableData.getString(1) + ";\t" + tableData.getString(2));
		}
	}


}
