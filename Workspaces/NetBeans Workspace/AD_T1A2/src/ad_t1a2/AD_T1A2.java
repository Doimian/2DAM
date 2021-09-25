package ad_t1a2;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AD_T1A2 {

    public static void main(String[] args) {
        
        try{
        
        //Cargar el Driver (de mySql en este caso)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Establecer una Conexion con la base de datos
        Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/academia","root","Rickyeselpro2");
        
        //Crear el statement
        Statement sentencia=conexion.createStatement();
        
        //Insertamos los datos
        /*insertarDatos(sentencia);*/
        
        
        
        //Mostrar todos los datos de todos los cursos
        datosCursos(sentencia);
        
        //Mostrar todos los datos de todos los alumnos
        datosAlumnos(sentencia);
        
        //Mostrar para cada curso el numero de alumnos matriculados
        cursoMatriculados(sentencia);
        
        //Mostrar curso, nombre del alumno y fecha de matriculacion
        cursoAlumnoFecha(sentencia);
        
        //Actualizar el mes de comienzo del curso con codigo 3 de marzo a junio
        actualizaMes(sentencia);
        
        //Actualizar la fecha de nacimiento del alumno 278 a 16-01-1982
        actualizaFNAC(sentencia);
        
        //Cambiar el numero de telefono del alumno 123 a 667899045
        actualizaNTEF(sentencia);
        
        conexion.close();
        sentencia.close();
        
        } catch (ClassNotFoundException e)
        {
            System.out.println("No se ha encontrado el Driver");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void datosCursos(Statement sentencia)
    {
        
    }
    
    public static void datosAlumnos(Statement sentencia)
    {
        
    }
        
    public static void cursoMatriculados(Statement sentencia)
    {
        
    }
            
    public static void cursoAlumnoFecha(Statement sentencia)
    {
        
    }
                
    public static void actualizaMes(Statement sentencia)
    {
        
    }
                    
    public static void actualizaFNAC(Statement sentencia)
    {
        
    }
    
    public static void actualizaNTEF(Statement sentencia)
    {
        
    }
                    
    
    
    
    
    
    public static void insertarDatos(Statement sentencia)
    {
        String ins1="insert into curso values (1,'Programacion PHP',200,'maniana','enero');";
        String ins2="insert into curso values (2,'El SGBD Oracle',150,'tarde','abril');";
        String ins3="insert into curso values (3,'Iniciacion a Java',100,'maniana','marzo');";
        
        String ins4="insert into alumno values (123,'33396348X','Maria','Ruiz','C/La palma,6','Malaga','1987/06/24','607342310');";
        String ins5="insert into alumno values (345,'2589241A','Pedro','Lopez','C/Paseo,2','Cartama','1996/08/20','670145678');";
        String ins6="insert into alumno values (278,'33800678N','Alfonso','Carrasco','Avda. Fideo,S/N','Nerja',NULL,'616245567');";
        
        String ins7="insert into matricula values (1,123,'2017/09/15',NULL);";
        String ins8="insert into matricula values (1,345,'2017/03/20','Apto');";
        String ins9="insert into matricula values (2,345,'2017/10/02',NULL);";
        String ins10="insert into matricula values (2,278,'2017/02/10','No Apto');";
        String ins11="insert into matricula values (3,278,'2017/04/16','Apto');";
        //System.out.println(ins1);
        
        
        int registros = 0;
        try {
            registros = sentencia.executeUpdate(ins1);
            registros += sentencia.executeUpdate(ins2);
            registros += sentencia.executeUpdate(ins3);
            registros += sentencia.executeUpdate(ins4);
            registros += sentencia.executeUpdate(ins5);
            registros += sentencia.executeUpdate(ins6);
            registros += sentencia.executeUpdate(ins7);
            registros += sentencia.executeUpdate(ins8);
            registros += sentencia.executeUpdate(ins9);
            registros += sentencia.executeUpdate(ins10);
            registros += sentencia.executeUpdate(ins11);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        
        System.out.println("Registros afectados: " + registros);
    }
}