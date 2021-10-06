import java.sql.*;
public class Conexion 
{
	private Connection conexion;
	private Statement sentencia;
	private PreparedStatement stat;
	public Conexion(String SGBD)
	{ 
		try	{
			String driver = "com." + SGBD + ".cj.jdbc.Driver";
			Class.forName(driver);
			System.out.println("Conexión exitosa");

		} catch(ClassNotFoundException e)
		{
			System.out.println("No se ha encontrado el Driver");
		}
	} 
	public Statement getConexion(String SGBD, String database, String usuario, String clave) throws SQLException
	{
		
		String con = "jdbc:" + SGBD + "://localhost/" + database + "?serverTimezone=UTC";
		conexion=DriverManager.getConnection(con, usuario, clave);
		sentencia = conexion.createStatement();
		return sentencia;
	}
	public PreparedStatement getPSConexion(String SGBD, String database, String usuario, String clave ,String sql) throws SQLException
	{
		
		String con = "jdbc:" + SGBD + "://localhost/" + database + "?serverTimezone=UTC";
		conexion=DriverManager.getConnection(con, usuario, clave);
		stat = conexion.prepareStatement(sql);
		return stat;
	}
	public void closeConexion()
	{
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
