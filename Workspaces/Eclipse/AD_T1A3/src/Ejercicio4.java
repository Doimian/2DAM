import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio4 {

	private static String SGBD;
	private static String database;
	private static String usuario;
	private static String clave;
	private static Conexion crearConexion;
	private static Connection conexion;
	private static Scanner sc;
	
	public static void main(String[] args) 
	{
		//Cargar el Driver
		sc = new Scanner(System.in);
		System.out.println("Indica el SGBD al que te quieres conectar: ");
		SGBD = sc.nextLine();
		
		crearConexion = new Conexion(SGBD);
		
		//Conectar con la base de datos
		System.out.println("Indica la base de datos a la que te quieres conectar");
		database = sc.nextLine();
		System.out.println("Indica el usuario con el que te vas a conectar");
		usuario = sc.nextLine();
		System.out.println("Indica la clave del usuario");
		clave = sc.nextLine();
		
		try {
			conexion = crearConexion.getConexion(SGBD, database, usuario, clave);
			System.out.println("Conexion exitosa con la base de datos");
		} catch (SQLException e) {
			System.out.println("No se ha podido acceder a la base de datos");
			e.printStackTrace();
		}
		
		//Menu
		Menu();
	}
	
	public static void Menu()
	{
		int contador = 0;
		while(contador != 7)
		{
			System.out.println("\nMenu de la aplicacion:");
			System.out.println("1. Insertar Alumno");
			System.out.println("2. Insertar Curso");
			System.out.println("3. Insertar Matrícula");
			System.out.println("4. Mostrar todos los alumnos");
			System.out.println("5. Mostrar todos los cursos");
			System.out.println("6. Mostrar todas las asignaturas");
			System.out.println("7. Salir de la aplicacion");
			contador = sc.nextInt();
			switch(contador)
			{
				case 1:
					insertarAlumno();
					break;
				case 2:
					insertarCurso();
					break;
				case 3:
					insertarMatricula();
					break;
				case 4:
					mostrarAlumnos();
					break;
				case 5:
					try {
						mostrarCursos();
					} catch (SQLException e) {
						e.printStackTrace();
}
					break;
				case 6:
					mostrarAsignaturas();
					break;
				case 7:
					System.out.println("Bye...");
					return;
			}
		}
	}

	private static void mostrarAsignaturas() 
	{
		System.out.println("");
	}

	private static void mostrarCursos() throws SQLException 
	{
		Statement sentencia = conexion.createStatement();
        ResultSet resul = sentencia.executeQuery("select * from curso;");
        System.out.println("cod_curso   nombre   horas   turno   mes_comienzo");
        //Recorremos el resultado
        while(resul.next())
        {
            System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getInt(3) + " " + resul.getString(4) + " " + resul.getString(5));
            
        }
        System.out.println("\n\n");
        resul.close();
	}

	private static void mostrarAlumnos() 
	{


	}

	private static void insertarMatricula() 
	{

		
	}

	private static void insertarCurso() 
	{
		
		
	}

	private static void insertarAlumno() 
	{
		
		
	}
	
}
