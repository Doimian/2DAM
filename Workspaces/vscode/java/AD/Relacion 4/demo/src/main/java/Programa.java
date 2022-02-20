import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import config.HibernateUtil;
import entities.Alumno;
import entities.Asignatura;

public class Programa 
{

    //Iniciamos la sesión hibernate
    private static Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();
    private static Scanner sc = new Scanner(System.in);

    public static void main( String[] args )
    {
        //datosIniciales();

        menu();
        
        sesionHibernate.close();
    }

    private static void menu() 
    {

        int index = 0;
        while(index < 10)
        {
            System.out.println("\nSelecciona una opcion (otro numero para salir)");    
            System.out.println("1. Insertar un alumno en la base de datos");    
            System.out.println("2. Insertar una asignatura en la base de datos");
            System.out.println("3. Inserción de una matrícula");
            System.out.println("4. Mostrar los alumnos");
            System.out.println("5. Mostrar las asignaturas");
            System.out.println("6. Mostrar las asignaturas en las que está matriculado un alumno");
            System.out.println("7. Mostrar los alumnos matriculados en una asignatura");
            System.out.println("8. Mostrar un listado de alumnos y las asignaturas en las que están matriculados");
            System.out.println("9. Mostrar el número de alumnos matriculados en cada asignatura");
            index = sc.nextInt();
            String flush = sc.nextLine();
            switch(index)
            {
                case 1: insertarAlumno(); break;
                case 2: insertarAsignatura(); break;
                case 3: insertarMatricula(); break;
                case 4: mostrarAlumnos(); break;
                case 5: mostrarAsignaturas(); break;
                case 6: mostrarAsignaturasDeAlumno(); break;
                case 7: mostrarAlumnosDeAsignatura(); break;
                case 8: mostrarAlumnosConAsignaturas(); break;
                case 9: mostrarNumAlumnosPorAsignatura(); break;
                default: System.out.println("Bye..."); return;
            }
        }
    }

    private static void insertarAlumno() 
    {
        //Pide Datos
        System.out.println("Introduce el codigo del alumno");
        int cod = sc.nextInt();
        String flush = sc.nextLine();
        System.out.println("Introduce el nombre del alumno");
        String nombre = sc.nextLine().trim();
        System.out.println("Introduce los apellidos del alumno");
        String apellidos = sc.nextLine().trim();
        System.out.println("Introduce el telefono del alumno");
        String tfno = sc.nextLine().trim();

        //Creamos el alumno
        Alumno alumno = new Alumno(cod, nombre, apellidos, tfno ,null);

        //Comenzamos una transacción
        Transaction tx = sesionHibernate.beginTransaction();
        //Guardamos el alumno
        sesionHibernate.save(alumno);
        //Finalizamos la transacción
        tx.commit();
        System.out.println("El alumno "+nombre+" se ha guardado correctamente");

    }

    private static void insertarAsignatura() 
    {
        //Pide Datos
        System.out.println("Introduce el codigo de la asignatura");
        int cod = sc.nextInt();
        String flush = sc.nextLine();
        System.out.println("Introduce el nombre de la asignatura");
        String nombre = sc.nextLine().trim();
        System.out.println("Introduce el número de créditos que vale la asignatura");
        Integer creditos = sc.nextInt();
        flush = sc.nextLine();

        //Creamos el alumno
        Asignatura asignatura = new Asignatura(cod, nombre, creditos, null);

        //Comenzamos una transacción
        Transaction tx = sesionHibernate.beginTransaction();
        //Guardamos el alumno
        sesionHibernate.save(asignatura);
        //Finalizamos la transacción
        tx.commit();
        System.out.println("La asignatura "+nombre+" se ha guardado correctamente");
    }

    private static void insertarMatricula() 
    {
        //Pide Datos
        System.out.println("Introduce el codigo del alumno");
        int cod_alumno = sc.nextInt();
        System.out.println("Introduce el código de la asignatura");
        int cod_asig = sc.nextInt();

        //Sacamos el alumno de la base de datos
        Query queryAlumno = sesionHibernate.createQuery("from Alumno where codigo = :cod_alumno");
        Query queryAsignatura = sesionHibernate.createQuery("from Asignatura where codigo = :cod_asig");
        queryAlumno.setParameter("cod_alumno", cod_alumno);
        queryAsignatura.setParameter("cod_asig", cod_asig);
        Alumno alumno = (Alumno) queryAlumno.getSingleResult();
        Asignatura asignatura = (Asignatura) queryAsignatura.getSingleResult();
        alumno.getAsignaturas().add(asignatura);

        //Comenzamos una transacción
        Transaction tx = sesionHibernate.beginTransaction();
        sesionHibernate.update(alumno);
        tx.commit();

        System.out.println("El alumno " + alumno.getNombre() + " se ha matriculado a " +asignatura.getNombre());

    }

    private static void mostrarAlumnos() 
    {
        Query query = sesionHibernate.createQuery("from Alumno");

        List<Alumno> alumnos = query.getResultList();
        for (Alumno alumno : alumnos) 
        {
            System.out.println("( " + alumno.getCodigo() + " ) " + alumno.getNombre() + " " + alumno.getApellidos() + "; Tfno: " + alumno.getTfno());
        }
    }

    private static void mostrarAsignaturas() 
    {
        Query query = sesionHibernate.createQuery("from Asignatura");
        List<Asignatura> asignaturas = query.getResultList();
        for(Asignatura asignatura : asignaturas)
        {
            System.out.println("( " + asignatura.getCodigo() + " ) " + asignatura.getNombre() + " vale " + asignatura.getCreditos() + " créditos");
        }
    }

    private static void mostrarAsignaturasDeAlumno() 
    {
        System.out.println("Introduce el código del Alumno");
        int cod = sc.nextInt();
        String flush = sc.nextLine();
        Query query = sesionHibernate.createQuery("from Alumno where codigo = :cod_alumno");
        query.setParameter("cod_alumno", cod);
        Alumno alumno = (Alumno) query.getSingleResult();
        if(alumno.getAsignaturas().size() == 0)
        {
            System.out.println("El alumno " + alumno.getNombre() + " no está matriculado a ninguna asignatura");
        }
        else
        {
            System.out.println("El alumno " + alumno.getNombre() + " está matriculado a " + alumno.getAsignaturas().size() + " asignaturas: ");
            for (Asignatura asignatura : alumno.getAsignaturas()) 
            {
                System.out.println("\t" + "("+asignatura.getCodigo()+")" + asignatura.getNombre() + ", que vale " + asignatura.getCreditos() + " créditos");
            }
        }
    }

    private static void mostrarAlumnosDeAsignatura() 
    {
        System.out.println("Introduce el código de la Asignatura");
        int cod = sc.nextInt();
        String flush = sc.nextLine();
        Query query = sesionHibernate.createQuery("from Asignatura where codigo = :cod_asig");
        query.setParameter("cod_asig", cod);
        Asignatura asignatura = (Asignatura) query.getSingleResult();
        if(asignatura.getAlumnos().size() == 0)
        {
            System.out.println("La asignatura " + asignatura.getNombre() + " no tiene ningún alumno matriculado");
        }
        else
        {
            System.out.println("La asignatura " + asignatura.getNombre() + " tiene " + asignatura.getAlumnos().size() + " alumnos matriculados: ");
            for (Alumno alumno : asignatura.getAlumnos()) 
            {
                System.out.println("\t" + "("+alumno.getCodigo()+")" + alumno.getNombre() + " " + alumno.getApellidos());
            }
        }
    }

    private static void mostrarAlumnosConAsignaturas() 
    {
        Query query = sesionHibernate.createQuery("from Alumno");
        List<Alumno> alumnos = query.getResultList();
        for (Alumno alumno : alumnos) 
        {
            if(alumno.getAsignaturas().size() == 0)
            {
                System.out.println("( " + alumno.getCodigo() + " )" + alumno.getNombre() + " "+ alumno.getApellidos() + " no está matriculado a ninguna asignatura");
            }
            else
            {
                System.out.println("( " + alumno.getCodigo() + " )" + alumno.getNombre() + " "+ alumno.getApellidos() + " está matriculado a " + alumno.getAsignaturas().size() + " asignaturas: ");
                for (Asignatura asignatura : alumno.getAsignaturas()) 
                {
                    System.out.println("\t" + "("+asignatura.getCodigo()+")" + asignatura.getNombre() + ", que vale " + asignatura.getCreditos() + " créditos");
                }
            }
        }
    }

    private static void mostrarNumAlumnosPorAsignatura() 
    {
        Query query = sesionHibernate.createQuery("from Alumno");
        List<Alumno> alumnos = query.getResultList();
        for (Alumno alumno : alumnos) 
        {
            System.out.println("( " + alumno.getCodigo() + " )" + alumno.getNombre() + " "+ alumno.getApellidos() + " está matriculado a " + alumno.getAsignaturas().size() + " asignaturas");
        }
    }

}
