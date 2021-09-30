import java.sql.*;
public class Conexion 
{
	private Connection conexion;
	public Conexion(String SGBD)
	{ 
		if(SGBD.equals("mysql"))
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Conexión exitosa");

			} catch(ClassNotFoundException e)
			{
				System.out.println("No se ha encontrado el Driver");
			}
		}
		else
			System.out.println("Por ahora este programa solo soporta mysql");
	} 
	public Connection getConexion(String SGBD, String database, String usuario, String clave) throws SQLException
	{
		
		String con = "jdbc:" + SGBD + "://localhost/" + database + "?serverTimezone=UTC";
		conexion=DriverManager.getConnection(con, usuario, clave);
		return conexion;
		
	}
}
