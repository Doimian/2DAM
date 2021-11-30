import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Biblioteca
{
    private static DataInputStream dis;
    private static DataOutputStream dos;
    private final static String FILE = "Biblioteca";
    private static Scanner sc = new Scanner(System.in);
    private static long ISBN;
    private static String titulo;
    private static String autor;
    private static String flush;
    private static Libro libro;
    private static int libros = 0;

    public static void main(String[] args) throws IOException
    {
        dis = new DataInputStream(new FileInputStream(FILE));
        dos = new DataOutputStream(new FileOutputStream(FILE));

        //Introducimos libros en la biblioteca
        System.out.println("Desea añadir un libro? ('No' -> salir / otra cosa -> si)");
        flush = sc.nextLine().toLowerCase();
        if(!(flush.contentEquals("no")))
        {
            for (;;)
            {
                //Pedir libros
                try {
                    System.out.println("Introduciendo un nuevo libro en la biblioteca...\nIntroduzca el ISBN del libro: ");
                    ISBN = sc.nextLong();
                    flush = sc.nextLine();
                    System.out.println("Introduzca el titulo del libro: ");
                    titulo = sc.nextLine().trim();
                    System.out.println("Introduzca el autor del libro: ");
                    autor = sc.nextLine().trim();
                }catch(InputMismatchException e)
                {
                    System.out.println("Error al introducir los datos\n" + e.getMessage());
                    return;
                }
                //Almacenamos los datos en libro
                libro = new Libro(ISBN, titulo, autor);
                //Guardamos el libro
                libro.grabarLibro(dos);
                libros++;

                System.out.println("Libro guardado correctamente");
                System.out.println("\nDesea añadir otro libro? ('No' -> salir / otra cosa -> si)");
                flush = sc.nextLine().toLowerCase();
                if(flush.contentEquals("no"))
                    break;
            }
        }else
        {
            System.out.println("Bye...");
        }

        //Sacar y mostrar los contenidos
        System.out.println("Hay " + libros + " libros en la base de datos de la Biblioteca:");
        for (int i = 0; i < libros; i++) {
            libro.leerLibro(dis);
            libro.mostrarLibro();
        }
        //Cerramos Streams y Scanner
        dis.close();
        dos.close();
        sc.close();
    }
}
