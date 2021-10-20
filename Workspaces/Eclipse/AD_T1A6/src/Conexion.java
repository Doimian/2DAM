import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Conexion 
{
	private static Connection conexion;
	private PreparedStatement stat;
	public Conexion(String SGBD)
	{ 
		
	} 
	public static Connection getConexion(String SGBD, String database, String usuario, String clave) throws SQLException, ClassNotFoundException
	{
		String con = "jdbc:" + SGBD + "://localhost/" + database + "?serverTimezone=UTC";
		conexion=DriverManager.getConnection(con, usuario, clave);
		return conexion;
	}
	public static Connection getConexion(String SGBD, String database) throws SQLException, ClassNotFoundException
	{
		Class.forName("org." + SGBD + ".jdbcDriver");
		conexion=DriverManager.getConnection("jdbc:" + SGBD + ":file:C:/hsqldb/data/" + database + "/" + database, "SA", "");
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
