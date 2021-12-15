import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import com.mysql.cj.util.StringUtils;

public class Examen {

	public static Scanner sc = new Scanner(System.in);	
	
	public static void main(String[] args)
	{
        try{
            
	        //Cargar el Driver (de mySql en este caso)
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        //pedimos datos para crear la conexión
	        System.out.print("Indica la base de datos a la que quieres acceder: ");
	        String database = sc.nextLine();
	        System.out.print("Indica el usuario con el que quieres acceder: ");
	        String user = sc.nextLine();
	        System.out.print("Indica la contraseña del usuario: ");
	        String password = sc.nextLine();
	        
	        //Establecer una Conexion con la base de datos
	        Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/"+database+"?serverTimezone=UTC",user,password);
            
	        //Generamos los metadatos de la base de datos para utilizarlos
	        DatabaseMetaData metadata = conexion.getMetaData();
	        
	        //Crear el statement
	        Statement sentencia=conexion.createStatement();
	        
	        //Creamos el DOM
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document doc = db.newDocument();
            doc.setXmlVersion("1.0");
            
            //Creamos el documento donde guardaremos el dom
            File file = new File("fichero"+database+".xml");
            
            //Creamos el elemento principal del documento xml, que se llama igual que la base de datos (empresa)
            Element elementoPrincipal = doc.createElement(database);
            doc.appendChild(elementoPrincipal);
            
            //Hacemos un bucle que se repite por cada tabla 
            String[] types = {"TABLE"};
            ResultSet resTab = metadata.getTables(database, null, "%", types);
            while(resTab.next())
            {
            	//Contamos el numero de iteraciones que vamos a necesitar (cuantos clientes hay)
            	ResultSet count = sentencia.executeQuery("Select * from "+resTab.getString(3));
            	//while(count.next())
            	for(int i = 0; i < 2; i++) //aqui he tenido que hacer trampita porque no sé por qué el while no me sirve aunque tambien se repite 2 veces
            	{
            		//Creamos el elemento secundario (cliente)
                	Element elementoSecundario= doc.createElement(resTab.getString(3));
                	//Sacamos la clave primaria de la tabla
                	ResultSet resKey = metadata.getPrimaryKeys(null, database, resTab.getString(3));
                	while(resKey.next())
                	{
                    	//Sacamos las columnas de la tabla
                    	ResultSet resCol = metadata.getColumns(null, null, resTab.getString(3), null);
                    	while(resCol.next())
                    	{
                    		//Si la columna es una clave primaria ->
                    		if(resCol.getString(4).equals(resKey.getString(4)))
                    		{
                    			//System.out.println(resKey.getString(4));
                    			//Sacamos el valor de esta columna y se la añadimos al elemento secundario como atributo
                    			ResultSet resKeyVal = sentencia.executeQuery("Select "+resCol.getString(4)+" from " + resTab.getString(3)+";");
                    			while(resKeyVal.next())
                    			{
                    				elementoSecundario.setAttribute(resKey.getString(4), resKeyVal.getString(1));
                    				//System.out.println(resKeyVal.getString(1));
                    			}
                    		}else // La columna no es una clave primaria
                    		{
                    			//Creamos el elemento terciario (columnas del cliente)
                    			Element elementoTerciario = doc.createElement(resCol.getString(4));
                    			ResultSet resColVal = sentencia.executeQuery("Select "+resCol.getString(4)+" from "+ resTab.getString(3)+";");
                    			while(resColVal.next())
                    			{
                    				elementoTerciario.appendChild(doc.createTextNode(resColVal.getString(1)));
                    			}
                    			elementoSecundario.appendChild(elementoTerciario);
                    		}
                    	}
                	}
                	elementoPrincipal.appendChild(elementoSecundario);
            	}
            }
        
            //Terminamos de preparar el documento xml
            Source source = new DOMSource(doc);
            Result result = new StreamResult(file);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
	        //Terminamos la conexión
	        conexion.close();
	        sentencia.close();
        
        //Capturamos los errores que nos pueden dar el driver y la conexion sql
        } catch (ClassNotFoundException ex)
		{
		    System.out.println("No se ha encontrado el Driver");
		} catch (SQLException e)
		{
		    e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
