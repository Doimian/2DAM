import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
public class Ejercicio4 {

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
		System.out.println("Indica el SGBD al que te quieres conectar: ");
		SGBD = sc.nextLine();
		if(!SGBD.equals("mysql"))
		{
			System.out.println("Por ahora este programa solo soporta mysql");
			return;
		}
			
		
		//Conectar con la base de datos
		System.out.println("Indica la base de datos a la que te quieres conectar");
		database = sc.nextLine();
		System.out.println("Indica el usuario con el que te vas a conectar");
		usuario = sc.nextLine();
		System.out.println("Indica la clave del usuario");
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
			Menu();
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
			System.out.println("\nMenu de la aplicacion:");
			System.out.println("1. Insertar Alumno");
			System.out.println("2. Insertar Curso");
			System.out.println("3. Insertar Matrícula");
			System.out.println("4. Mostrar todos los alumnos");
			System.out.println("5. Mostrar todos los cursos");
			System.out.println("6. Mostrar todas las asignaturas");
			System.out.println("7. Salir de la aplicacion");
			contador = sc.nextInt();
			limpiacarro = sc.nextLine();
			switch(contador)
			{
				case 1:
					try {
						insertarAlumno(statement);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						insertarCurso(statement);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						insertarMatricula(statement);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 4:
					try {
						mostrarAlumnos(statement);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 5:
					try {
						mostrarCursos(statement);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 6:
					try {
						mostrarMatriculas(statement);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 7:
					System.out.println("Bye...");
					return;
			}
		}
	}

	private static void mostrarMatriculas(Statement statement)  throws SQLException
	{
		System.out.println("Mostrar Asignaturas de la base de datos:");

        ResultSet resul = statement.executeQuery("select alumno.nombre, curso.nombre from curso join matricula on (matricula.cod_curso = curso.cod_curso) join alumno on (alumno.cod_alumno = matricula.cod_alumno);");
        System.out.println("Alumno    Asignatura");
        //Recorremos el resultado
        while(resul.next())
        {
            System.out.println(resul.getString(1) + "   " + resul.getString(2));
            
        }
        System.out.println("\n\n");
        resul.close();
	}

	private static void mostrarCursos(Statement statement) throws SQLException 
	{
		System.out.println("Mostrar Cursos de la base de datos:");
		
        ResultSet resul = statement.executeQuery("select * from curso;");
        System.out.println("cod_curso   nombre   horas   turno   mes_comienzo");
        //Recorremos el resultado
        while(resul.next())
        {
            System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getInt(3) + " " + resul.getString(4) + " " + resul.getString(5));
            
        }
        System.out.println("\n\n");
        resul.close();
	}

	private static void mostrarAlumnos(Statement statement) throws SQLException
	{
		System.out.println("Mostrar Cursos de la base de datos:");

        ResultSet resul = statement.executeQuery("select * from alumno;");
        System.out.println("cod_alumno   DNI   nombre   apellidos   direccion   localidad   f_nac   tfno");

        //Recorremos el resultado
        while(resul.next())
        {
            System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3) + " " + resul.getString(4) + " " + resul.getString(5) + " " + resul.getString(6) + " " + resul.getString(7) + " " + resul.getString(8));
            
        }
        System.out.println("\n\n");
        resul.close();
	}

	private static void insertarMatricula(Statement statement) throws SQLException 
	{
		String sql = "insert into matricula values(?,?,?,?)";
		stat = conexion.prepareStatement(sql);
		int cod_curso, cod_alumno;
		String fecha_mat, calificacion, limpiacarro;
		
		System.out.println("Vas a añadir una matricula a la base de datos:");
		System.out.println("Codigo del alumno matriculado: ");
		cod_alumno = sc.nextInt();
		limpiacarro = sc.nextLine();
		System.out.println("Codigo del curso al que se matricula: ");
		cod_curso = sc.nextInt();
		limpiacarro = sc.nextLine();
		System.out.println("Fecha de matriculación (formato anno/mes/dia): ");
		fecha_mat = sc.nextLine();
		System.out.println("Calificación del alumno (Apto / No apto): ");
		calificacion = sc.nextLine();
		stat.setInt(1, cod_curso);
		stat.setInt(2, cod_alumno);
		stat.setString(3, fecha_mat);
		stat.setString(4, calificacion);
		stat.executeUpdate();
		stat.close();
	}

	private static void insertarCurso(Statement statement) throws SQLException 
	{
		String sql = "insert into curso values(?,?,?,?,?)";
		stat = conexion.prepareStatement(sql);
		int cod_curso, horas;
		String nombre, turno, mes_comienzo, limpiacarro;
		
		System.out.println("Vas a añadir un curso a la base de datos:");
		System.out.println("Codigo del curso: ");
		cod_curso = sc.nextInt();
		limpiacarro = sc.nextLine();
		System.out.println("nombre del curso: ");
		nombre = sc.nextLine();
		System.out.println("horas del curso: ");
		horas = sc.nextInt();
		limpiacarro = sc.nextLine();
		System.out.println("turno del curso (maniana / tarde): ");
		turno = sc.nextLine();
		System.out.println("mes de comienzo del curso (escrito, no numerico): ");
		mes_comienzo = sc.nextLine();
		stat.setInt(1, cod_curso);
		stat.setString(2, nombre);
		stat.setInt(3, horas);
		stat.setString(4, turno);
		stat.setString(5, mes_comienzo);
		stat.executeUpdate();
		stat.close();
	}

	private static void insertarAlumno(Statement statement) throws SQLException
	{
		String sql = "insert into alumno values(?,?,?,?,?,?,?,?)";
		stat = conexion.prepareStatement(sql);
		int cod_alumno;
		String DNI, nombre, apellidos, direccion, localidad, f_nac, tfno, limpiacarro;
		
		System.out.println("Vas a añadir un alumno a la base de datos:");
		System.out.println("Codigo del alumno: ");
		cod_alumno = sc.nextInt();
		limpiacarro = sc.nextLine();
		System.out.println("DNI del alumno: ");
		DNI = sc.nextLine();
		System.out.println("nombre del alumno: ");
		nombre = sc.nextLine();
		System.out.println("apellidos del alumno: ");
		apellidos = sc.nextLine();
		System.out.println("direccion del alumno: ");
		direccion = sc.nextLine();
		System.out.println("localidad del alumno: ");
		localidad = sc.nextLine();
		System.out.println("fecha de nacimiento del alumno (con formato anno/mes/dia): ");
		f_nac = sc.nextLine();
		System.out.println("telefono del alumno: ");
		tfno = sc.nextLine();
		stat.setInt(1,cod_alumno);
		stat.setString(2, DNI);
		stat.setString(3, nombre);
		stat.setString(4, apellidos);
		stat.setString(5, direccion);
		stat.setString(6, localidad);
		stat.setString(7, f_nac);
		stat.setString(8, tfno);
		stat.executeUpdate();
		stat.close();
	}
}
