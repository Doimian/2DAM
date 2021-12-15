import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Concesionario
{
    public static void main (String[] args) throws ParserConfigurationException, IOException, SAXException
    {
        File fichero = new File("/home/damian/2DAM/Asignaturas/Acceso a Datos/T2/Relacion 3/Concesionario.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document documento = db.parse(fichero);
        documento.getDocumentElement().normalize();

        Element elemento = documento.getDocumentElement();
        String nodoraiz = elemento.getTagName();
        System.out.println("Elemento raíz: " + nodoraiz);
        NodeList hijos = elemento.getElementsByTagName("coche");

        //Recorremos los nodos
        for (int i= 0 ; i < hijos.getLength(); i++)
        {
            Element aux = (Element) hijos.item(i);
            if( aux.getNodeType()== Node.ELEMENT_NODE)
            {
                //Mostrar el nombre del nodo y el valor del atributo
                System.out.println(aux.getNodeName() + "Id: " + aux.getAttributes().item(0).getNodeValue());
                System.out.println("=======================");
                NodeList n1 = aux.getChildNodes();
                for (int y = 0; y < n1.getLength(); y++)
                {
                    Node aux2 = n1.item(y);
                    if (aux2.getNodeType() == Node.ELEMENT_NODE)
                    {
                        //Recorremos los nodos y sacamos el nombre y valor
                        String valor = aux2.getChildNodes().item(0).getNodeValue();
                        System.out.println(aux2.getNodeName() + ": " + valor);
                    }
                }
            }
            System.out.println("\n");
        }
    }
}
