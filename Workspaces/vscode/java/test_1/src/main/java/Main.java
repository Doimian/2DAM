

import org.hibernate.Session;
import org.hibernate.Transaction;

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

        sesionHibernate.close();
        System.out.println( "La sesion se ha cerrado" );
    }
}