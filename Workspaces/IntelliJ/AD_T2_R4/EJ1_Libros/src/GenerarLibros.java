import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class GenerarLibros
{
    public static void main(String[] args)
    {
        //Indicamos los ficheros de origen y destino
        File origen = new File("BibliotecaOrigen");
        File res = new File("Biblioteca.xml");



        //Generamos una biblioteca con algunos libros de forma binaria
        ArrayList<Libro> librosOriginales = new ArrayList<Libro>();
        librosOriginales.add(new Libro(235252342,"El Señor de los Anillos", "J. R. R. Tolkien"));
        librosOriginales.add(new Libro(682736325,"Harry Potter", "J. K. Rowling"));
        librosOriginales.add(new Libro(823462364,"El Principito", "Hemingway"));
        librosOriginales.add(new Libro(148326723,"Don Quijote", "Miguel de Cervantes"));
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(origen));
            for(Libro libro : librosOriginales) {
                oos.writeObject(libro);
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Generamos el documento DOM
        try {
            //Creamos un documento tipo DOM
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            doc.setXmlVersion("1.0");

            Element elBiblioteca = doc.createElement("biblioteca");
            doc.appendChild(elBiblioteca);

            //Leemos la biblioteca y añadimos los libros al DOM
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(origen));
            for(;;) {
                try {
                    Libro libro = (Libro) ois.readObject();
                    Element elLibro = doc.createElement("libro");
                    elLibro.setAttribute("ISBN", "" + libro.consultarISBN());
                    elLibro.setAttribute("Autor", libro.consultarAutor());
                    elLibro.setAttribute("Titulo", libro.consultarTitulo());
                    elBiblioteca.appendChild(elLibro);
                } catch (EOFException e) {
                    //Ignoramos esta ç
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            ois.close();

            //Generamos un Transformer para poder serializar el documento
            Source source = new DOMSource(doc);
            Result result = new StreamResult(res);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            //Generamos el documento XML
            transformer.transform(source,result);

        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
