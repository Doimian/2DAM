package src;
import java.sql.*;
public class Conexion 
{
	private static Connection conexion;
	private PreparedStatement stat;
	public Conexion(String SGBD)
	{ 
		try	{
			String driver = "com." + SGBD + ".cj.jdbc.Driver";
			Class.forName(driver);
			System.out.println("Conexi?n exitosa");

		} catch(ClassNotFoundException e)
		{
			System.out.println("No se ha encontrado el Driver");
		}
	} 
	public static Connection getConexion(String SGBD, String database, String usuario, String clave) throws SQLException
	{
		String con = "jdbc:" + SGBD + "://localhost/" + database + "?serverTimezone=UTC";
		conexion=DriverManager.getConnection(con, usuario, clave);
		return conexion;
	}

	public static void closeConexion()
	{
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
