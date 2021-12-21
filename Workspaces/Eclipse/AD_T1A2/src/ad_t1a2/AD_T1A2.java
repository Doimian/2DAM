package ad_t1a2;

import java.sql.*;
public class AD_T1A2 {

    public static void main(String[] args) {
        
        try{
        
        //Cargar el Driver (de mySql en este caso)
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Establecer una Conexion con la base de datos
        Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/academia?serverTimezone=UTC","root","Rickyeselpro2");
        
        //Crear el statement
        Statement sentencia=conexion.createStatement();
        
        //Insertamos los datos
        insertarDatos(sentencia);

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

        //Terminamos la conexion y el statement
        conexion.close();
        sentencia.close();
        
        //Capturamos los errores que nos pueden dar el driver y la conexion sql
        } catch (ClassNotFoundException e)
        {
            System.out.println("No se ha encontrado el Driver");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void datosCursos(Statement sentencia) throws SQLException
    {
        System.out.println("Mostrar todos los datos de todos los cursos:");
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
    
    
    public static void cursoMatriculados(Statement sentencia) throws SQLException
    {
        System.out.println("Mostrar para cada curso (nombre del curso), el numero de alumnos matriculados en el:");
        ResultSet resul = sentencia.executeQuery("select curso.nombre, count(*) from curso join matricula on (matricula.cod_curso = curso.cod_curso) group by curso.nombre;");
        while(resul.next())
        {
            System.out.println(resul.getString(1) + " " + resul.getInt(2));
        }
        System.out.println("\n\n");
        resul.close();
    }
    
    public static void datosAlumnos(Statement sentencia) throws SQLException
    {
        System.out.println("Mostrar todos los datos de todos los alumnos:");
        ResultSet resul = sentencia.executeQuery("select * from alumno;");
        System.out.println("cod_alumno   DNI   nombre   apellidos   direccion   localidad   f_nac   tlfno");
        //Recorremos el resultado
        while(resul.next())
        {
            System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3) + " " + resul.getString(4) + " " + resul.getString(5) + " " + resul.getString(6) + " " + resul.getString(7) + " " + resul.getString(8));
            
        }
        System.out.println("\n\n");
        resul.close();
    }
   
    public static void cursoAlumnoFecha(Statement sentencia) throws SQLException
    {
        System.out.println("Mostrar un listado con el nombre del curso y el nombre del alumno matriculado, asi como la fecha de matriculacion:");
        ResultSet resul = sentencia.executeQuery("select curso.nombre, alumno.nombre, fecha_mat from curso join matricula on (matricula.cod_curso = curso.cod_curso) join alumno on (matricula.cod_alumno = alumno.cod_alumno);");
        while(resul.next())
        {
            System.out.println(resul.getString(1) + " " + resul.getString(2) + " " + resul.getString(3));
        }
        System.out.println("\n\n");
        resul.close();
    }
                
    public static void actualizaMes(Statement sentencia) throws SQLException
    {
        System.out.println("Actualizar el mes de comienzo del curso con codigo 3 de marzo a junio");
        sentencia.executeUpdate("update curso set mes_comienzo = 'junio' where cod_curso = 3;");
        System.out.println("Curso actualizado \n\n");
        
    }   
                    
    public static void actualizaFNAC(Statement sentencia) throws SQLException
    {
        System.out.println("Actualizar la fecha de nacimiento del alumno 278 a 16-01-1982");
        sentencia.executeUpdate("update alumno set f_nac='1982/01/16' where cod_alumno = 278");
        System.out.println("Alumno actualizado\n\n");
    }
    
    public static void actualizaNTEF(Statement sentencia) throws SQLException
    {
        System.out.println("Cambiar el numero de telefono del alumno 123 a '667899045'");
        sentencia.executeUpdate("update alumno set tfno = '667899045' where cod_alumno = 123");
        System.out.println("Alumno actualizado\n\n");
    }

    public static void insertarDatos(Statement sentencia) throws SQLException
    {
        String ins1="insert ignore into curso values (1,'Programacion PHP',200,'maniana','enero');";
        String ins2="insert ignore into curso values (2,'El SGBD Oracle',150,'tarde','abril');";
        String ins3="insert ignore into curso values (3,'Iniciacion a Java',100,'maniana','marzo');";
        String ins4="insert ignore into alumno values (123,'33396348X','Maria','Ruiz','C/La palma,6','Malaga','1987/06/24','607342310');";
        String ins5="insert ignore into alumno values (345,'2589241A','Pedro','Lopez','C/Paseo,2','Cartama','1996/08/20','670145678');";
        String ins6="insert ignore into alumno values (278,'33800678N','Alfonso','Carrasco','Avda. Fideo,S/N','Nerja',NULL,'616245567');";
        String ins7="insert ignore into matricula values (1,123,'2017/09/15',NULL);";
        String ins8="insert ignore into matricula values (1,345,'2017/03/20','Apto');";
        String ins9="insert ignore into matricula values (2,345,'2017/10/02',NULL);";
        String ins10="insert ignore into matricula values (2,278,'2017/02/10','No Apto');";
        String ins11="insert ignore into matricula values (3,278,'2017/04/16','Apto');";
        int registros;
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
        System.out.println("Registros afectados: " + registros);
    }
}