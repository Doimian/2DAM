import java.io.*;

public class Libro implements Serializable {
    private long ISBN;
    private String titulo;
    private String autor;

    public Libro(long ISBN, String titulo, String autor)
    {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
    }

    public void grabarLibro(DataOutputStream fich) throws IOException
    {
        //Guardar libro en el fichero fich
        fich.writeLong(ISBN);
        fich.writeUTF(titulo);
        fich.writeUTF(autor);
    }

    public void leerLibro(DataInputStream fich) throws IOException
    {
        //Lee un libro desde fich y guarda los datos
        this.ISBN = fich.readLong();
        this.titulo = fich.readUTF();
        this.autor = fich.readUTF();
    }
    public void mostrarLibro()
    {
        //Muestra por consola los datos del libro
        System.out.println("[Libro]   ISBN: " + ISBN + ";   Titulo: " + titulo + ";   Autor : " + autor);
    }
    public long consultarISBN()
    {
        return ISBN;
    }
    public String consultarTitulo()
    {
        return titulo;
    }
    public String consultarAutor()
    {
        return autor;
    }
}
