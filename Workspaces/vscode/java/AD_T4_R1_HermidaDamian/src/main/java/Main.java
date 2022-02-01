import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import config.HibernateUtil;
import entities.Libro;
import entities.Socio;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Iniciar la conexion: " );

        Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();

        System.out.println( "La sesión está iniciada" );

        //Creamos algunos libros y socios
        /* Este conjunto de código sólamente se ejecuta la primera vez
        Libro libro1 = new Libro("543354526T", "Harry Potter", "JK Rowling");
        Libro libro2 = new Libro("799267652P", "El Señor de los anillos", "George RR Martin");
        Libro libro3 = new Libro("156592625I", "Mi mono Amelio", "Shakespeare");
        
        Socio socio1 = new Socio("278948372A", "Juan", "Gomez", "623442675");
        Socio socio2 = new Socio("847720947N", "Amelia", "Torres", "693281076");
        Socio socio3 = new Socio("732094572D", "Pedro", "Picapiedra", "673828367");
        
        Transaction transaccion = sesionHibernate.beginTransaction();
        sesionHibernate.save(libro1);
        sesionHibernate.save(libro2);
        sesionHibernate.save(libro3);
        sesionHibernate.save(socio1);
        sesionHibernate.save(socio2);
        sesionHibernate.save(socio3);

        transaccion.commit();
        */

        //Sacamos los datos de la base de datos a trabés de hibernate
        Query queryLibro = sesionHibernate.createQuery("from Libro");
        Query querySocio = sesionHibernate.createQuery("from Socio");
        List<Libro> libros = queryLibro.list();
        List<Socio> socios = querySocio.list();        
        Iterator<Libro> iterLibro = libros.iterator();
        Iterator<Socio> iterSocio = socios.iterator();

        //Mostramos la información en pantalla
        System.out.println("ISBN       Titulo       Autor");
        while(iterLibro.hasNext())
        {
            Libro libro = iterLibro.next();
            System.out.println(libro.getISBN() + " " + libro.getTitulo() + " " + libro.getAutor());
        }

        System.out.println("\nDNI        Nombre     Apellidos     Telefono");
        while(iterSocio.hasNext())
        {
            Socio libro = iterSocio.next();
            System.out.println(libro.getDNI() + " " + libro.getNombre() + " " + libro.getApellidos() + " " + libro.getTelefono());
        }


        sesionHibernate.close();
        System.out.println( "La sesion se ha cerrado" );
    }
}