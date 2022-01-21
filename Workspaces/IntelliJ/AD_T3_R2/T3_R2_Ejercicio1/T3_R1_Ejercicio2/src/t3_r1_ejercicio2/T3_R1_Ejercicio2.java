/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3_r1_ejercicio2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author Luis
 */
public class T3_R1_Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    private static Paises paisEncontrado;
    
    public static void main(String[] args) {
        
        Menu menu = new Menu();
        Boolean salir = false;
        Scanner input = new Scanner(System.in);
        
        //Atributos pais
        Paises pais;
        int id;
        String nombrePais;
        
        //Atributos jugadores
        Jugadores jugador;
        String nombre;
        String deporte;
        String ciudad;
        int edad;
        
        //creamos base de datos 
        ODB odb = ODBFactory.open("EQUIPOS.DB1.test");
        
        
        menu.setTitulo("EJERCICIO 2 - RELACION 4");
        menu.addOption(1, "Insertar pais");
        menu.addOption(2, "Insertar jugador");
        menu.addOption(3, "Muestra todos los paises");
        menu.addOption(4, "Muestra todos los jugadores");
        menu.addOption(5, "Consultas simples");
        menu.addOption(6, "Modificar el nombre de un pais");
        menu.addOption(7, "Consultas complejas");
        menu.addOption(8, "Salir");
        
        //menu con las opciones
        while(!salir){
            System.out.println(menu);
            switch(menu.getOpcion()){
                
                case 1: //insertar nuevo pais
                    System.out.println("Introduce el id del pais: ");
                    id = input.nextInt();
                    input.nextLine();

                    System.out.println("Introduce el nombre del pais: ");
                    nombrePais = input.nextLine();
                    
                    if(!comprobarPaises(odb, "id", String.valueOf(id))){
                        pais = new Paises(id, nombrePais);
                        odb.store(pais);
                        System.out.println("Pais creado con exito en la BD.");
                    }           
                    else
                        System.out.println("El pais con id: " + id + " ya existe.");
                        
                    break;
                
                case 2: //Insertar un nueva jugador
                    System.out.println("Introduce el nombre del nuevo jugador");
                    nombre = input.nextLine();

                    System.out.println("Introduce el deporte del nuevo jugador");
                    deporte = input.nextLine();

                    System.out.println("Introduce la ciudad del nuevo jugador");
                    ciudad = input.nextLine();

                    System.out.println("Introduce la edad del nuevo jugador");
                    edad = input.nextInt();
                    input.nextLine();
                    
                    System.out.println("Introduce el nombre del pais: ");
                    nombrePais = input.nextLine();
                    
                    if(comprobarPaises(odb, "nombrePais", nombrePais) && !comprobarJugadores(odb, "nombre", nombre)){
                        Jugadores j = new Jugadores(nombre, deporte, ciudad, edad, paisEncontrado);
                        odb.store(j);
                        System.out.println("Jugador creado con exito en la BD.");
                    }           
                    else{
                        if(!comprobarPaises(odb, "nombrePais", nombrePais))
                            System.out.println("El pais con nombre: " + nombrePais + " no se encuentra en la base de datos.");
                        if(comprobarJugadores(odb, "nombre", nombre))
                            System.out.println("El Jugador con nombre: " + nombre + " ya existe.");               
                    }
                    break;
                    
                case 3: //muestra paises
                    mostrarPaises(odb);
                    break;
                    
                case 4: //muestra Jugadores
                    mostrarJugadores(odb);
                    break;
                    
                case 5: // consultas simples
                    Menu menu2 = new Menu();
                    menu2.addOption(1, "Mostrar todos países cuyo nombre empiece por “E”.");
                    menu2.addOption(2, "Mostrar todos los jugadores de “baloncesto” de “España”.");
                    
                    System.out.println(menu2);
                    
                    switch(menu2.getOpcion()){
                        case 1: //Mostrar todos países cuyo nombre empiece por “E”.
                            ArrayList<Paises> listPaises= new ArrayList<>();
                            listPaises = consultaSencilla1(odb);
                            
                            mostrarPorDato(listPaises);
                            break;
                            
                        case 2: //Mostrar todos los jugadores de “baloncesto” de “España”.
                            ArrayList<Jugadores> listJugadores= new ArrayList<>();
                            listJugadores = consultaSencilla2(odb);

                            mostrarPorDato(listJugadores);
                            break;
                    }
                    break;
                    
                case 6: //modificar nombre pais
                    System.out.println("Introduce el id del pais: ");
                    id = input.nextInt();
                    input.nextLine();

                    System.out.println("Introduce el nombre del pais: ");
                    nombrePais = input.nextLine();
                    
                    System.out.println("Introduce el nuevo nombre del pais: ");
                    String nuevoNombre = input.nextLine();
                    
                    modificarNombrePais(odb, id, nombrePais, nuevoNombre);
                    break;
                
                case 7: //Consultas complejas
                    Menu menu3 = new Menu();
                    
                    menu3.addOption(1, "Obtener la edad media de todos los jugadores (select avg(edad) from jugadores)");
                    menu3.addOption(2, "Obtener la edad máxima y mínima (select max(edad), min(edad) from jugadores)");
                    menu3.addOption(3, "Obtener por cada país el número de jugadores. Mostrar el país y el número de\n" +
                                       "jugadores para ese país (select pais.nombrepais, count(nombre) from jugadores\n" +
                                       "group by (pais.nombrepais))");
                    menu3.addOption(4, "Mostrar para cada deporte, la edad del jugador más joven que practica ese deporte.\n" +
                                       "(select deporte, min(edad) from jugadores group by deporte).");
                    menu3.addOption(5, "Mostrar el nombre de los jugadores mayores de 12 años que sean españoles. (Select\n" +
                                       "nombre from jugadores where edad>12 and pais.nombrepais=”España”)");
                    
                    System.out.println(menu3.toString());
                    
                    switch(menu3.getOpcion()){
                        
                        case 1: 
                            consultaCompleja1(odb);
                            break;
                            
                        case 2: 
                            consultaCompleja2(odb);
                            break;
                            
                        case 3: 
                            consultaCompleja3(odb);
                            break;
                            
                        case 4: 
                            consultaCompleja4(odb);
                            break;
                            
                        case 5: 
                            consultaCompleja5(odb);
                            break;
                    }
                    break;
                    
                    
                case 8: //salir
                    salir = true;
                    break;
                        
                    
                    
                    
                    
                    
                    
                    
            }
        }
        
        odb.close();
    }
    
    //Vamos a comprobar paises no con el ID, si no por el nombnre del pais para reciclar esta funcion para el apasrtado dos del menu
    public static boolean comprobarPaises(ODB odb, String atributo, String dato){
        
        boolean existe;
        
        //ArrayList de paises
        ArrayList<Paises> ArrayListPaises = new ArrayList<>();
        boolean isNumeric = dato.matches("[+-]?\\d*(\\.\\d+)?");
        ICriterion criterio;
        
        //Si el dato introducido es numerico o si no lo es se ejecutara la funcion correctamente
        if(isNumeric)
            criterio = Where.equal(atributo, Integer.parseInt(dato)); 
        else
           criterio = Where.equal(atributo, dato); 
        
        //Montamos la consulta
        IQuery query = new CriteriaQuery(Paises.class, criterio);
        Objects<Paises> objetos = odb.getObjects(query);
        
        //Añadimos los datos al array list y hacemos las comrpobaciones
        Paises p = null;
        while(objetos.hasNext()){
            p = objetos.next();
            ArrayListPaises.add(p);
        }
        
        if(ArrayListPaises.isEmpty())
            existe = false;
        else{
            existe = true;
            paisEncontrado = p; //Variable para asignar el pais si se encuentra
        }
            
        return existe;
        
    }
    
   
    public static boolean comprobarJugadores(ODB odb, String atributo, String dato){
        
        boolean existe;
        
        //ArrayList de paises
        ArrayList<Jugadores> ArrayListJugadores = new ArrayList<>();
        ICriterion criterio;
        
        criterio = Where.equal(atributo, dato); 
        
        //Montamos la consulta
        IQuery query = new CriteriaQuery(Jugadores.class, criterio);
        Objects<Jugadores> objetos = odb.getObjects(query);
        
        //Añadimos los datos al array list y hacemos las comrpobaciones
        Jugadores j = null;
        while(objetos.hasNext()){
            j = objetos.next();
            ArrayListJugadores.add(j);
        }
        
        if(ArrayListJugadores.isEmpty())
            existe = false;
        else{
            existe = true;
        }
            
        return existe;
        
    }
    
    //Mostramos los datos de la base de datos paises
    private static void mostrarPaises(ODB odb){
        
        int i = 1;
        Objects<Paises> objetos = odb.getObjects(Paises.class);
        System.out.println("Hay un total de: " + objetos.size() + " Paises");
        
        //Mostramos los objetos
        while(objetos.hasNext()){
            //Recogemos el valor que nos devuelve la base de datos
            Paises p = objetos.next();
            
            System.out.println(i + ". "+ p.toString());
            i++;
            
        }
    }
    
     //Mostramos los datos de la base de datos jugadores
    private static void mostrarJugadores(ODB odb){
        
        int i = 1;
        Objects<Jugadores> objetos = odb.getObjects(Jugadores.class);
        System.out.println("Hay un total de: " + objetos.size() + " Jugadores");
        
        //Mostramos los objetos
        while(objetos.hasNext()){
            //Recogemos el valor que nos devuelve la base de datos
            Jugadores j = objetos.next();
            
            System.out.println(i + ". "+ j.toString());
            i++;
            
        }
    }
    
    //consulta sencilla Mostrar todos países cuyo nombre empiece por “E”.
    private static ArrayList<Paises> consultaSencilla1(ODB odb){
        //Creamos la lista de jugadores 
        ArrayList<Paises> ArrayListPaises = new ArrayList<>();
        
        //Montamos el criterio
        ICriterion criterio = Where.like("nombrePais", "E%");
        
        //Montamos la consulta
        IQuery query = new CriteriaQuery(Paises.class, criterio);
        Objects<Paises> objetos = odb.getObjects(query);
        
        //Añadimos datos al arrayList
        while(objetos.hasNext()){
            Paises p = objetos.next();
            ArrayListPaises.add(p);
        }
        
        return ArrayListPaises;   
    }
    
    //consulta sencilla Mostrar todos países cuyo nombre empiece por “E”.
    private static ArrayList<Jugadores> consultaSencilla2(ODB odb){
        //Creamos la lista de jugadores 
        ArrayList<Jugadores> ArrayListJugadores = new ArrayList<>();
        
        //Montamos el criterio
        ICriterion criterio = new And().add(Where.equal("deporte", "baloncesto")).add(Where.equal("pais.nombrePais", "Espania"));
        
        //Montamos la consulta
        IQuery query = new CriteriaQuery(Jugadores.class, criterio);
        Objects<Jugadores> objetos = odb.getObjects(query);
        
        //Añadimos datos al arrayList
        while(objetos.hasNext()){
            Jugadores j = objetos.next();
            ArrayListJugadores.add(j);
        }
        
        return ArrayListJugadores;   
    }
    
    //Mostramos los jugadores pasandole un ArrayList
    private static void mostrarPorDato(ArrayList a){
        
        //creamos el iterator para mostrar los datos
        Iterator<Object> it = a.iterator();

        while(it.hasNext()){
            Object j = it.next();
            System.out.println(j.toString());

        }
    }
    
    //modificar nombre de un pais
    private static void modificarNombrePais(ODB odb, int id, String nombre, String nuevoNombre){
        Objects<Paises> objetos = odb.getObjects(Paises.class);
        
        
        while(objetos.hasNext()){
            Paises p = objetos.next();
            
            if(p.getId() == id && p.getNombrePais().equals(nombre)){
                //Seteamos los valores
                p.setId(id);
                p.setNombrePais(nuevoNombre);
                
                odb.store(p);
            }   
        }
    }
    
    //Consultas complejas 
    //consulta compleja 1 - Obtener la edad media de todos los jugadores (select avg(edad) from jugadores)
    private static void consultaCompleja1(ODB odb){
        //criterio SELECT AVG(EDAD) FROM JUGADORES
        Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).avg("edad"));
        
        ObjectValues obv = valores.nextValues();
        
        BigDecimal avgEdad = (BigDecimal) obv.getByAlias("edad");
        
        System.out.println("La media de edad de todos los jugadores es: " + avgEdad);       
        
    }
    
    //Consulta compleja 2 - Obtener la edad máxima y mínima (select max(edad), min(edad) from jugadores)
    private static void consultaCompleja2(ODB odb){
        Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).min("edad", "edadMinimo").max("edad", "edadMaximo"));
        
        ObjectValues obv = valores.nextValues();
        
        BigDecimal maxEdad = (BigDecimal) obv.getByAlias("edadMaximo");
        BigDecimal minEdad = (BigDecimal) obv.getByAlias("edadMinimo");
        
        System.out.println("La edad minima es: " + minEdad + " y la edad maxima es: " + maxEdad);   
    }
    
    
     //Consulta compleja 3 - Obtener por cada país el número de jugadores. Mostrar el país y el número de jugadores para ese país (select pais.nombrepais, count(nombre) from jugadores group by (pais.nombrepais))
    private static void consultaCompleja3(ODB odb){
        Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).field("pais.nombrePais").count("nombre").groupBy("pais.nombrePais"));
        
        while(valores.hasNext()){
            ObjectValues objetos = (ObjectValues) valores.next();
            
            System.out.println("Pais: " + objetos.getByAlias("pais.nombrePais") + ", Cantidad de jugadores: " + objetos.getByAlias("nombre"));
        }
    }
    
    //Consulta compleja 4 - Mostrar para cada deporte, la edad del jugador más joven que practica ese deporte.(select deporte, min(edad) from jugadores group by deporte).
    private static void consultaCompleja4(ODB odb){

        Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).min("edad").field("deporte").groupBy("deporte"));
        
        while(valores.hasNext()){
            ObjectValues objetos = (ObjectValues) valores.next();
            
            System.out.println("Deporte: " + objetos.getByAlias("deporte") + ", Jugador mas joven tiene edad de: " + objetos.getByAlias("edad"));
        }
    }
    
    //Consulta compleja 5 - Mostrar el nombre de los jugadores mayores de 12 años que sean españoles. (Select nombre from jugadores where edad>12 and pais.nombrepais=”España”)
    private static void consultaCompleja5(ODB odb){
        
        ValuesCriteriaQuery vcq = new ValuesCriteriaQuery(Jugadores.class, new And().add(Where.like("pais.nombrePais", "Espania")).add(Where.gt("edad", 12)));
        
        Values valores = odb.getValues(vcq.field("nombre"));
        
        while(valores.hasNext()){
            ObjectValues objetos = (ObjectValues) valores.next();
            
            System.out.println("Nombre: " + objetos.getByAlias("nombre"));
        }
    }
    
    
    
    
    
}
