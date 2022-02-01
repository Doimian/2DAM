import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
    //Iniciamos la sesión hibernate
    private static Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();
    private static Scanner sc = new Scanner(System.in);

    public static void main( String[] args )
    {

        //datosIniciales();

        menu();

        sesionHibernate.close();
    }

    public void datosIniciales()
    {
        //Creamos algunos libros y socios
        //Este conjunto de código sólamente se ejecuta la primera vez
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
    }

    public static void menu()
    {
        int index = 0;
        while(index <8)
        {
            System.out.println("\nElija una opción del menu:");
            System.out.println("1. Listar todos los libros");
            System.out.println("2. Listar todos los socios");
            System.out.println("3. Añadir un libro");
            System.out.println("4. Añadir un socio");
            System.out.println("5. Modificar un libro");
            System.out.println("6. Modificar un socio");
            System.out.println("7. Eliminar un libro");
            System.out.println("8. Eliminar un socio");
            System.out.println("9, Salir de la aplicación");
            index = sc.nextInt();
            String flush = sc.nextLine();
            switch(index)
            {
                case 1: listarLibros(); break;
                case 2: listarSocios(); break;
                case 3: insertarLibro(); break;
                case 4: insertarSocio(); break;
                case 5: modificarLibro(); break;
                case 6: modificarSocio(); break;
                case 7: borrarLibro(); break;
                case 8: borrarSocio(); break;
                case 9: System.out.println("Bye..."); return;
                default: System.out.println("Numero no soportado"); return;
            }
        }
    }

    private static void listarLibros() 
    {
        //Sacamos los datos de la base de datos a trabés de hibernate
        Query queryLibro = sesionHibernate.createQuery("from Libro");
        List<Libro> libros = queryLibro.list();
        Iterator<Libro> iterLibro = libros.iterator();

        //Mostramos la información en pantalla
        System.out.println("ISBN       Titulo       Autor");
        while(iterLibro.hasNext())
        {
            Libro libro = iterLibro.next();
            System.out.println(libro.getISBN() + " " + libro.getTitulo() + " " + libro.getAutor());
        }
    }

    private static void listarSocios() 
    {
        //Sacamos los datos de la base de datos a trabés de hibernate
        Query querySocio = sesionHibernate.createQuery("from Socio");
        List<Socio> socios = querySocio.list();        
        Iterator<Socio> iterSocio = socios.iterator();

        //Mostramos la información en pantalla
        System.out.println("\nDNI        Nombre     Apellidos     Telefono");
        while(iterSocio.hasNext())
        {
            Socio libro = iterSocio.next();
            System.out.println(libro.getDNI() + " " + libro.getNombre() + " " + libro.getApellidos() + " " + libro.getTelefono());
        }   
    }

    private static void insertarLibro() {
        //Pedimos los datos por pantalla
        System.out.println("Indica el ISBN del libro");
        String ISBN = sc.nextLine().trim();
        System.out.println("Indica el título del libro");
        String titulo = sc.nextLine().trim();
        System.out.println("Indica el autor del libro");
        String autor = sc.nextLine().trim();
        
        //Creamos el libro
        Libro libro = new Libro(ISBN, titulo, autor);

        //Comprobamos que no existe en la base de datos
        Query query = sesionHibernate.createQuery("from Libro l where l.ISBN =:ISBN");
        query.setParameter("ISBN", ISBN);
        List<Libro> libros = query.list();
        if(!libros.isEmpty())
        {
            System.out.println("El libro ya existe en la base de datos.");
        }else
        {
            //Comenzamos la transacción
            Transaction tx = sesionHibernate.beginTransaction();
            sesionHibernate.save(libro);
            tx.commit();

            System.out.println("El libro se ha guardado correctamente en la base de datos");
        }
    }

    private static void insertarSocio() {
        //Pedimos los datos al usuario
        System.out.println("Indica el DNI del socio");
        String DNI = sc.nextLine().trim();
        System.out.println("Indica el nombre del socio");
        String nombre = sc.nextLine().trim();
        System.out.println("Indica el apellidos del socio");
        String apellidos = sc.nextLine().trim();
        System.out.println("Indica el telefono del socio");
        String telefono = sc.nextLine().trim();

        //creamos el socio
        Socio socio = new Socio(DNI, nombre, apellidos, telefono);
        
        //Comprobamos que no existe en la base de datos
        Query query = sesionHibernate.createQuery("from Socio s where s.DNI = :DNI");
        query.setParameter("DNI", DNI);
        List<Socio> socios = query.list();
        if(!socios.isEmpty())
        {
            System.out.println("El socio ya existe en la base de datos.");
        }else
        {
            //Comenzamos la transacción
            Transaction tx = sesionHibernate.beginTransaction();
            sesionHibernate.save(socio);
            tx.commit();
            
            System.out.println("El socio se ha guardado correctamente en la base de datos");
        }
    }

    private static void modificarLibro() {
        //Pedimos el ISBN del libro al usuario
        System.out.println("Indica el ISBN del libro que quieres modificar");
        String ISBN = sc.nextLine().trim();

        //Sacamos el libro de la base de datos
        Query query = sesionHibernate.createQuery("from Libro l where l.ISBN = :ISBN");
        query.setParameter("ISBN", ISBN);
        Libro libro = (Libro) query.getSingleResult();

        //Nos aseguramos que el libro existe
        if(libro.equals(null))
        {
            System.out.println("El libro que has indicado no existe en la base de datos");
            return;
        }
        System.out.println("El libro que se ha encontrado es:");
        System.out.println("ISBN =\t" + libro.getISBN());
        System.out.println("Titulo =\t" + libro.getTitulo());
        System.out.println("Autor =\t" + libro.getAutor() + "\n");

        System.out.println("Indica el campo que quieres modificar del libro (titulo / autor / ambos)");
        String campo = sc.nextLine().toLowerCase().trim();
        String titulo = libro.getTitulo();
        String autor = libro.getAutor();

        switch(campo)
        {
            case "titulo":  
                            System.out.println("Indica el nuevo titulo del libro");
                            titulo = sc.nextLine().trim();
                            break;
            case "autor":   
                            System.out.println("Indica el nuevo autor del libro");
                            autor = sc.nextLine().trim();
                            break;
            case "ambos":
                            System.out.println("Indica el nuevo titulo del libro");
                            titulo = sc.nextLine().trim();
                            System.out.println("Indica el nuevo autor del libro");
                            autor = sc.nextLine().trim();
                            break;

            default: System.out.println("El campo que ha indicado no está registrado"); return;
        }

        //Modificamos el libro
        libro.setAutor(autor);
        libro.setTitulo(titulo);

        //Guardamos el libro
        sesionHibernate.update(libro);

        System.out.println("El libro ha sido modificado; sus nuevos campos son:");
        System.out.println("ISBN =\t" + libro.getISBN());
        System.out.println("Titulo =\t" + libro.getTitulo());
        System.out.println("Autor =\t" + libro.getAutor() + "\n");
    }

    private static void modificarSocio() {
        //Pedimos el ISBN del libro al usuario
        System.out.println("Indica el DNI del socio que quieres modificar");
        String DNI = sc.nextLine().trim();

        //Sacamos el libro de la base de datos
        Query query = sesionHibernate.createQuery("from socio s where s.DNI = :DNI");
        query.setParameter("DNI", DNI);
        Socio socio = (Socio) query.getSingleResult();

        //Nos aseguramos que el libro existe
        if(socio.equals(null))
        {
            System.out.println("El socio que has indicado no existe en la base de datos");
            return;
        }
        System.out.println("El socio que se ha encontrado es:");
        System.out.println("DNI =\t" + socio.getDNI());
        System.out.println("Nombre =\t" + socio.getNombre());
        System.out.println("Apellidos =\t" + socio.getApellidos() + "\n");
        System.out.println("Telefono =\t" + socio.getTelefono() + "\n");

        System.out.println("Indica el campo que quieres modificar del socio (nombre / apellidos / telefono / todo)");
        String campo = sc.nextLine().toLowerCase().trim();
        String nombre = socio.getNombre();
        String apellidos = socio.getApellidos();
        String telefono = socio.getTelefono();
        

        switch(campo)
        {
            case "nombre":  
                            System.out.println("Indica el nuevo nombre del socio");
                            nombre = sc.nextLine().trim();
                            break;
            case "apellidos":   
                            System.out.println("Indica los nuevos apellidos del socio");
                            apellidos = sc.nextLine().trim();
                            break;
            case "telefono":   
                            System.out.println("Indica el nuevo telefono del socio");
                            telefono = sc.nextLine().trim();
                            break;
            case "todos":
                            System.out.println("Indica el nuevo nombre del socio");
                            nombre = sc.nextLine().trim();
                            System.out.println("Indica los nuevos apellidos del socio");
                            apellidos = sc.nextLine().trim();
                            System.out.println("Indica el nuevo telefono del socio");
                            telefono = sc.nextLine().trim();
                            break;

            default: System.out.println("El campo que ha indicado no está registrado"); return;
        }

        //Modificamos el libro
        socio.setNombre(nombre);
        socio.setApellidos(apellidos);
        socio.setTelefono(telefono);

        //Guardamos el libro
        sesionHibernate.update(socio);

        System.out.println("El libro ha sido modificado; sus nuevos campos son:");
        System.out.println("DNI =\t" + socio.getDNI());
        System.out.println("Nombre =\t" + socio.getNombre());
        System.out.println("Apellidos =\t" + socio.getApellidos() + "\n");
        System.out.println("Telefono =\t" + socio.getTelefono() + "\n");
    }

    private static void borrarLibro() {
        //Pedimos el ISBN del libro que queremos eliminar
        System.out.println("Indica el ISBN del libro que quieres eliminar de la base de datos");
        String ISBN = sc.nextLine().trim();

        //Comprobamos que existe y que lo podemos sacar
        Query query = sesionHibernate.createQuery("from Libro l where l.ISBN = :ISBN");
        query.setParameter("ISBN", ISBN);

        Libro libro = (Libro) query.getSingleResult();
        if(libro.equals(null))
        {
            System.out.println("El libro que has especificado no existe");
            return;
        }

        System.out.println("Estas seguro de que deseas eliminar el siguiente libro? (Y/N)");
        System.out.println("ISBN: " + libro.getISBN());
        System.out.println("Titulo: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        String confirmacion = sc.nextLine().toLowerCase().trim();
        switch(confirmacion)
        {
            case "y"  :
            case "yes":
            case "si" : break;
            case "n"  :
            case "no" : System.out.println("Se ha cancelado la operación"); return;
            default   : System.out.println("Error en la confirmación");     return;
        }

        //Borramos el libro
        //Comenzamos la transacción
        Transaction tx = sesionHibernate.beginTransaction();
        sesionHibernate.delete(libro);
        tx.commit();

        System.out.println("El libro se ha eliminado correctamente");
    }

    private static void borrarSocio() {
        //Pedimos el DNI del socio que queremos eliminar
        System.out.println("Indica el DNI del socio que quieres eliminar de la base de datos");
        String DNI = sc.nextLine().trim();

        //Comprobamos que existe y que lo podemos sacar
        Query query = sesionHibernate.createQuery("from Socio l where l.DNI = :DNI");
        query.setParameter("DNI", DNI);

        Socio socio = (Socio) query.getSingleResult();
        if(socio.equals(null))
        {
            System.out.println("El socio que has especificado no existe");
            return;
        }

        System.out.println("Estas seguro de que deseas eliminar el siguiente socio? (Y/N)");
        System.out.println("DNI: " + socio.getDNI());
        System.out.println("Nombre: " + socio.getNombre());
        System.out.println("Apellidos: " + socio.getApellidos());
        System.out.println("Telefono: " + socio.getTelefono());
        String confirmacion = sc.nextLine().toLowerCase().trim();
        switch(confirmacion)
        {
            case "y"  :
            case "yes":
            case "si" : break;
            case "n"  :
            case "no" : System.out.println("Se ha cancelado la operación"); return;
            default   : System.out.println("Error en la confirmación");     return;
        }

        //Borramos el socio
        //Comenzamos la transacción
        Transaction tx = sesionHibernate.beginTransaction();
        sesionHibernate.delete(socio);
        tx.commit();

        System.out.println("El socio se ha eliminado correctamente");
    }
}