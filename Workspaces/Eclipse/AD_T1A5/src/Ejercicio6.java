
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
			System.out.println("8. Ejecutar procedimiento matricula_alumno");
			System.out.println("9. Ejecutar procedimiento fecha_comienzo");
			System.out.println("10. Ejecutar funcion calificacion");
			System.out.println("11. Salir de la aplicación");
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
					break;
				case 8:
					callProcMatriculaAlumno();
					break;
				case 9:	
					callProcFechaComienzo();
					break;
				case 10:
					callFuncCalificacion();
					break;
				case 11:	
					System.out.println("Bye...");
					return;
			}
		}
	}


	private static void mostrarProcedimientosAlmacenados() throws SQLException
	{
		ResultSet procData = metadata.getProcedures(null , null, null);
		if(!procData.next())
			System.out.println("No hay procedimientos almacenados en esta base de datos");
		while(procData.next())
		{
			String cName = procData.getString(1);
			String pName = procData.getString(3);
			String pSpecName = procData.getString(9);
			System.out.println("Catalog name: " + cName + ", Procedure name: " + pName + ", Specific name: " + pSpecName);
		}
	}


	private static void mostrarClavesExternas() throws SQLException 
	{
		System.out.println("Indica el nombre de la tabla:");
		String tabla = sc.nextLine();
		ResultSet tableData = metadata.getImportedKeys(null, null, tabla);
		if(tabla.equals("alumno") || tabla.equals("curso"))
			System.out.println("Esta tabla no tiene clave externas");
		while(tableData.next())
		{
			String PKtableName = tableData.getString(3);
			String FKtableName = tableData.getString(7);
			String FKcolName = tableData.getString(8);
			String FKName = tableData.getString(13);
			System.out.println("Tabla: " + PKtableName + " esta referenciada por la tabla " + FKtableName + " en la columna " + FKcolName + " y el nombre de la clave externa es " + FKName);
		}
	}


	private static void mostrarClavesPrimarias()  throws SQLException
	{
		System.out.println("Indica el nombre de la tabla que quieres conocer su clave primaria:");		
		String tabla = sc.nextLine();
		if(tabla.equals("alumno") || tabla.equals("curso")||tabla.equals("matricula"))
		{
			ResultSet tableData = metadata.getPrimaryKeys("academia", null, tabla);
			System.out.println("Clave Primaria de la tabla " + tabla + ": ");
			while(tableData.next())
			{
				String tableName = tableData.getString(3);
				String colName = tableData.getString(4);
				String pkName = tableData.getString(6);
				System.out.println("Tabla: " + tableName + ", Columna: " + colName + ", Nombre de la clave: " + pkName);
			}		
		} else
			System.out.println("Nombre de tabla incorrecto");
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
				System.out.println("Tabla: " + tableName + ", Columna: " + colName + ", Tipo de datos: " + dataType + ", Acepta NULL?: " + canNull);
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
		System.out.println("Datos de todas las tablas en la base de datos " + database + " :");
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
	
	private static void callProcMatriculaAlumno() throws SQLException
	{
		int codAlumno, resultado;
		String limpiacarro;
		String param2 = "@m";
		String sql = "{ call matricula_alumno(?,?) }";
		CallableStatement llamada = conexion.prepareCall(sql);
		
		
		System.out.println("Introduce el codigo del alumno:");
		codAlumno = sc.nextInt();
		limpiacarro = sc.nextLine();
		
		llamada.setInt(1, codAlumno);
		llamada.setString(2, param2);
		llamada.registerOutParameter(2, java.sql.Types.VARCHAR);
		llamada.executeUpdate();
		resultado = llamada.getInt(2);
		System.out.println("El alumno con codigo " + codAlumno +" esta matriculado a " + resultado +" cursos");
	}
	
	private static void callProcFechaComienzo() throws SQLException
	{
		int codCurso; 
		String limpiacarro, resultado;
		
		String param2 = "@m";
		String sql = "{ call fecha_comienzo(?,?) }";
		CallableStatement llamada = conexion.prepareCall(sql);
		
		
		System.out.println("Introduce el codigo del curso:");
		codCurso = sc.nextInt();
		limpiacarro = sc.nextLine();
		
		llamada.setInt(1, codCurso);
		llamada.setString(2, param2);
		llamada.registerOutParameter(2, java.sql.Types.VARCHAR);
		llamada.executeUpdate();
		resultado = llamada.getString(2);
		System.out.println("El curso con codigo " + codCurso +" empieza en " + resultado);
	}

	private static void callFuncCalificacion() throws SQLException
	{
		int codCurso, codAlumno; 
		String limpiacarro, resultado;
		
		String sql = "{?=call calificacion(?,?)}";
		CallableStatement llamada = conexion.prepareCall(sql);
		
		System.out.println("Introduce el codigo del alumno:");
		codAlumno = sc.nextInt();
		limpiacarro = sc.nextLine();		
		System.out.println("Introduce el codigo del curso:");
		codCurso = sc.nextInt();
		limpiacarro = sc.nextLine();
		
		llamada.setInt(2, codAlumno);
		llamada.setInt(3, codCurso);
		llamada.registerOutParameter(1, java.sql.Types.VARCHAR);
		llamada.executeUpdate();
		resultado = llamada.getString(1);
		System.out.println("El alumno con codigo " + codAlumno+" tiene en el curso con codigo " + codCurso + " la calificacion: " + resultado);
	}
}
