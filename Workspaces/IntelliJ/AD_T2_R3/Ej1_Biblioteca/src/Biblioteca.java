import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String filepath = "BibliotecaObjetos.dat";
        Libro libro;
        ArrayList<Libro> libros = new ArrayList<Libro>();
        long libroISBN;
        String libroTitulo;
        String libroAutor;
        String flush;

        try {
            //Creamos los streams
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filepath)));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream( new File(filepath)));

            //Creamos libros
            for(;;)
            {
                //Pedimos información
                System.out.println("Vamos a crear un nuevo libro");
                System.out.println("Introduce el ISBN (0 para cancelar): ");
                libroISBN = sc.nextLong();
                flush = sc.nextLine();
                if(libroISBN == 0)
                {
                    break;
                }
                System.out.println("Introduce el título del libro:");
                libroTitulo = sc.nextLine().trim();
                System.out.println("Introduce el autor del libro:");
                libroAutor = sc.nextLine().trim();

                //Creamos el libro
                libro = new Libro(libroISBN, libroTitulo, libroAutor);
                libros.add(libro);
            }


            //Insertamos libros
            for (Libro l: libros)
            {
                oos.writeObject(l);
            }
            oos.close();

            //Extraemos libros
            libros.clear();
            for(;;)
            {
                try {
                    Libro l = (Libro) ois.readObject();
                    libros.add(l);
                } catch (ClassNotFoundException | EOFException e)
                {
                    // Se han leido todos los libros
                    break;
                }
            }

            //Mostramos libros
            System.out.println("Los libros que hay almacenados en la base de datos son:");
            for (Libro l : libros)
            {
                l.mostrarLibro();
            }
            ois.close();

        } catch (IOException e) {
            System.out.println("Error al operar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
