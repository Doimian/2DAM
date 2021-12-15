import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertarLibros
{
    //Indicamos los ficheros de origen y destino
    static File origen = new File("BibliotecaOrigen");
    static File res = new File("Biblioteca.xml");
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        //Limpiamos la biblioteca
        try {
            res.delete();
            res.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Generamos una biblioteca con algunos libros de forma binaria
        generarBinario(new Libro(235252342,"El Señor de los Anillos", "J. R. R. Tolkien"));
        generarBinario(new Libro(682736325,"Harry Potter", "J. K. Rowling"));
        generarBinario(new Libro(823462364,"El Principito", "Hemingway"));
        generarBinario(new Libro(148326723,"Don Quijote", "Miguel de Cervantes"));

        //Menu
        int num = 1;
        while(num == 1 || num == 2)
        {
            System.out.println("Elija una opción");
            System.out.println("1. Añadir un libro a la base de datos");
            System.out.println("2. Ver la información de la base de datos");
            System.out.println("Salir del programa (cualquier otro numero)");
            try {
                num = sc.nextInt();
            } catch(InputMismatchException e)
            {
                num = 3;
            }
            String flush = sc.nextLine();

            switch(num)
            {
                case 1:
                    Libro  libro = generarLibro();
                    generarBinario(libro);
                    generarXML();
                    break;
                case 2:
                    verXML();
                    break;
                default:
                    System.out.println("Bye...");

            }
        }
    }
    public static Libro generarLibro()
    {
        System.out.println("Introduzca el ISBN del nuevo libro");
        long ISBN = sc.nextLong();
        String flush = sc.nextLine();

        System.out.println("Introduzca el autor del nuevo libro");
        String autor = sc.nextLine().trim();

        System.out.println("Introduzca el titulo del nuevo libro");
        String titulo = sc.nextLine().trim();
        return new Libro(ISBN, titulo, autor);
    }
    public static void generarBinario(Libro libro)
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(origen, true));
            oos.writeObject(libro);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void generarXML()
    {
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
    public static void verXML(){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse(res);
            documento.getDocumentElement().normalize();

            Element elemento = documento.getDocumentElement();
            String nodoraiz = elemento.getTagName();
            System.out.println("Elemento raíz: " + nodoraiz);
            NodeList hijos = elemento.getElementsByTagName("libro");

            //Recorremos los nodos
            for (int i = 0; i < hijos.getLength(); i++) {
                Element aux = (Element) hijos.item(i);
                if (aux.getNodeType() == Node.ELEMENT_NODE) {
                    //Mostrar el nombre del nodo y el valor del atributo
                    System.out.println(aux.getNodeName() + "=>\n\tISBN: " + aux.getAttributes().item(1).getNodeValue() + "\n\tTitulo: " + aux.getAttributes().item(2).getNodeValue() + "\n\tAutor: " + aux.getAttributes().item(0).getNodeValue());
                    System.out.println("=======================");
                }
                System.out.println("\n");
            }
        }catch( ParserConfigurationException | IOException | SAXException e)
        {
            e.printStackTrace();
        }
    }
}
