package ad_t1a2;

import java.sql.*;
import java.util.*;
public class AD_T1A2 {

    public static void main(String[] args) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/academia","Damian","Rickyeselpro2");

        
        String sql="insert into curso values (1, 'Programacion PHP', 200, 'maniana', 'enero'";
        System.out.println(sql);
        Statement sentencia=conexion.createStatement();
        int filas=sentencia.executeUpdate(sql);
        System.out.println("Filas afectadas:" + filas);
        
        sql="insert into curso values (2, 'El SGBD Oracle', 150, 'tarde', 'abril'";
        System.out.println(sql);
        sentencia=conexion.createStatement();
        filas=sentencia.executeUpdate(sql);
        System.out.println("Filas afectadas:" + filas);
        
        sql="insert into curso values (3, 'Iniciacion a Java', 100, 'maniana', 'marzo'";
        System.out.println(sql);
        sentencia=conexion.createStatement();
        filas=sentencia.executeUpdate(sql);
        System.out.println("Filas afectadas:" + filas);
        
        sql="insert into curso values (1, 'El SGBD Oracle', 150, 'tarde', 'abril'";   
        System.out.println(sql);
        sentencia=conexion.createStatement();
        filas=sentencia.executeUpdate(sql);
        System.out.println("Filas afectadas:" + filas);
        
        
        sentencia.close();
        conexion.close();
        
        } catch (ClassNotFoundException e)
        {
            System.out.println("No se ha encontrado el Driver");
        } catch (SQLException e)
        {
            System.out.println("No se ha podido establecer una conexión con el servidor de MysQl");
        }
    }
    
}
