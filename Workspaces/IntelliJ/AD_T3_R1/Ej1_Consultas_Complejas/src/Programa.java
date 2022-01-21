import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    private static Scanner sc = new Scanner(System.in);

    //creamos la base de datos
    private static ODB odb = ODBFactory.open("/home/damian/2DAM/Workspaces/Neodatis/EQUIPOS.DB");

    public static void main(String[] args) {
        //Creamos paises por defecto
        Paises p1 = new Paises(1, "España");
        Paises p2 = new Paises(2, "Francia");
        Paises p3 = new Paises(3, "USA");
        Paises p4 = new Paises(4, "Inglaterra");

        //Creamos jugadores para tener algo en la base de datos
        Jugadores j1 = new Jugadores("Maria", "voleibol", "Madrid", 11, p1);
        Jugadores j2 = new Jugadores("Juan", "baloncesto", "Málaga", 20, p1);
        Jugadores j3 = new Jugadores("Elena", "tenis", "Barcelona", 15, p3);
        Jugadores j4 = new Jugadores("Alicia", "fútbol", "Teruel", 16, p1);
        Jugadores j5 = new Jugadores("Federico", "furbo", "Madrid", 50, p4);

        //Guardamos los datos

        odb.store(p1);
        odb.store(p2);
        odb.store(p3);
        odb.store(p4);
        odb.store(j1);
        odb.store(j2);
        odb.store(j3);
        odb.store(j4);
        odb.store(j5);

        //Hacemos el menú
        menu();

        //Cerramos la base de datos
        odb.close();
    }

    private static void menu() {
        int i = 0;
        while (i != 7)
        {
            System.out.println("\nElige tu próxima acción en la base de datos");
            System.out.println("1.  Crear un país");
            System.out.println("2.  Insertar un jugador");
            System.out.println("3.  Mostrar los paises");
            System.out.println("4.  Mostrar los jugadores");
            System.out.println("5.  Mostrar los países cuyo nombre empiece por la \"E\"");
            System.out.println("6.  Mostrar los jugadores de \"baloncesto\" de \"España\"");
            System.out.println("7.  Modificar el nombre de un país");
            System.out.println("8.  Obtener la edad media de todos los jugadores");
            System.out.println("9.  Obtener la edad máxima y mínima de los jugadores");
            System.out.println("10. Obtener por cada país el número de jugadores");
            System.out.println("11. Mostrar para cada deporte, la edad del jugador más joven");
            System.out.println("12. Mostrar el nombre de los jugadores mayores de 12 años que sean españoles");
            System.out.println("13. Salir de la aplicación");

            int opcion = sc.nextInt();
            String flush = sc.nextLine();
            switch(opcion)
            {
                case 1: crearPais(); break;

                case 2: insertarJugador(); break;

                case 3: mostrarPaises(); break;

                case 4: mostrarJugadores(); break;

                case 5: consulta1(); break;

                case 6: consulta2(); break;

                case 7: modificarPais(); break;

                case 8: edadMedia(); break;

                case 9: edadMaxima(); break;

                case 10: jugadoresPorPais(); break;

                case 11: edadMinimaPorDeporte(); break;

                case 12: edadMayorEspaña(); break;

                case 13: System.out.println("Bye..."); return;

                default: System.out.println("Error, valor no contemplado.");return;
            }
        }
    }

    private static void edadMedia()
    {
        Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).avg("edad"));
        ObjectValues obv = valores.nextValues();
        BigDecimal edadMedia = (BigDecimal) obv.getByAlias("edad");
        System.out.println("La edad media de los jugadores es de "+ edadMedia + " años");
    }

    private static void edadMaxima() {
        Values valoresMax = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).max("edad"));
        ObjectValues obvMax = valoresMax.nextValues();

        Values valoresMin = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).min("edad"));
        ObjectValues obvMin = valoresMin.nextValues();

        BigDecimal edadMax = (BigDecimal) obvMax.getByAlias("edad");
        BigDecimal edadMin = (BigDecimal) obvMin.getByAlias("edad");

        System.out.println("El jugador más mayor tiene " + edadMax + " años, y el más joven tiene " + edadMin + " años");
    }

    private static void jugadoresPorPais()
    {
        Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).field("pais.nombrepais", "p").count("nombre").groupBy("pais.nombrepais"));

        while(valores.hasNext())
        {
            ObjectValues objetos = (ObjectValues) valores.next();
            System.out.println("En el país " + objetos.getByAlias("p") + " hay " + objetos.getByAlias("nombre") + " jugadores");
        }
    }

    private static void edadMinimaPorDeporte()
    {
        Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).min("edad").field("deporte").groupBy("deporte"));

        while(valores.hasNext())
        {
            ObjectValues objetos = (ObjectValues) valores.next();
            System.out.println("Para el deporte " + objetos.getByAlias("deporte") + " el jugador más joven tiene "+ objetos.getByAlias("edad") + " años");
        }
    }

    private static void edadMayorEspaña()
    {
        ValuesCriteriaQuery vcq = new ValuesCriteriaQuery(Jugadores.class, new And().add(Where.like("pais.nombrepais", "España")).add(Where.gt("edad", 12)));

        Values valores = odb.getValues(vcq.field("nombre"));

        while(valores.hasNext()){
            ObjectValues objetos = (ObjectValues) valores.next();

            System.out.println("Nombre: " + objetos.getByAlias("nombre"));
        }

    }

    private static void crearPais()
    {
        //Pedimos datos
        System.out.println("Introduce el id del nuevo país: ");
        int id = sc.nextInt();
        String flush = sc.nextLine();
        System.out.println("Introduce el nombre del nuevo país:");
        String nombre = sc.nextLine().trim();

        //Creamos una criterio para comprobar que no existe un país con el misno nombre e id
        ICriterion criterio = new And().add(Where.equal("id",id)).add(Where.equal("nombrepais",nombre));

        //Montamos la consulta
        IQuery query = new CriteriaQuery(Paises.class, criterio);

        //Obtenemos los jugadores que cumplen el criterio
        Objects<Paises> paises = odb.getObjects(query);

        if(!paises.isEmpty())
        {
            System.out.println("El país ya existe en la base de datos");
            return;
        }

        //Si el pais no existe lo guardamos
        Paises pais = new Paises(id, nombre);
        odb.store(pais);

        //Informamos el resultado
        System.out.println("El país \"" + nombre + "\" con id " + id + " se ha guardado en la base de datos");
    }

    private static void insertarJugador()
    {
        //Pedimos datos
        System.out.println("Nombre del Jugador: ");
        String nombre = sc.nextLine().trim();
        System.out.println("Deporte que practica el jugaodr: ");
        String deporte = sc.nextLine().trim();
        System.out.println("Ciudad del jugador: ");
        String ciudad = sc.nextLine().trim();
        System.out.println("Edad del jugador: ");
        int edad = sc.nextInt();
        String flush = sc.nextLine();
        System.out.println("País del jugador:");
        String nombrePais = sc.nextLine().trim();

        //buscamos el pais en la base de datos
        ICriterion criterioPais = Where.equal("nombrepais", nombrePais);
        IQuery queryPais = new CriteriaQuery(Paises.class, criterioPais);
        Objects<Paises> paises = odb.getObjects(queryPais);
        if(paises.isEmpty())
        {
            System.out.println("El país no existe en la base de datos");
            return;
        }
        Paises pais = paises.getFirst();

        //Sacamos los jugadores de la base de datos para comprobar que no existe
        ICriterion criterioJugador = new And().add(Where.equal("nombre",nombre)).add(Where.equal("deporte",deporte)).add(Where.equal("ciudad",ciudad)).add(Where.equal("edad",edad)).add(Where.equal("pais",pais));
        IQuery queryJugador = new CriteriaQuery(Jugadores.class, criterioJugador);
        Objects<Jugadores> jugadores = odb.getObjects(queryJugador);
        if(!jugadores.isEmpty())
        {
            System.out.println("El jugador ya existe en la base de datos");
            return;
        }

        //Si el jugador no existe lo guardamos
        Jugadores jugador = new Jugadores(nombre, deporte, ciudad, edad, pais);
        odb.store(jugador);

        //Informamos del resultado
        System.out.println("El jugador ha sido guardado en la base de datos");
    }

    private static void mostrarPaises()
    {
        //Sacamos los paises de la base de datos
        Objects<Paises> paises = odb.getObjects(Paises.class);
        System.out.println(paises.size() + " Paises:");

        //Los recorremos mostrando la información de cada uno
        for(Paises pais : paises)
        {
            System.out.println(pais.getNombrepais() + ", con Id " + pais.getId());
        }

    }

    private static void mostrarJugadores()
    {
        //Sacamos los jugadores de la base de datos
        Objects<Jugadores> jugadores = odb.getObjects(Jugadores.class);
        System.out.println(jugadores.size() + " Jugadores:");

        //Los recorremos mostrando su información y la información de su país
        int i = 1;
        while(jugadores.hasNext())
        {
            Jugadores jugador = jugadores.next();
            System.out.println(i + ": " + jugador.getNombre() + " (" +jugador.getPais().getNombrepais() + ", con id " +jugador.getPais().getId() + "), practica " + jugador.getDeporte() + " en " + jugador.getCiudad() + " con " +jugador.getEdad() + " años");
            i++;
        }
    }

    private static void consulta1()
    {
        //Creamos el criterio para los paises "el campo nombre debe empezar por E"
        ICriterion criterio = Where.like("nombrepais","E%");

        //Montamos la consulta
        IQuery query = new CriteriaQuery(Paises.class, criterio);

        //Obtenemos los Paises que cumplen el criterio
        Objects<Paises> paises = odb.getObjects(query);

        //Mostramos la información
        for(Paises pais : paises)
        {
            System.out.println(pais.getNombrepais() + ", con Id " + pais.getId());
        }
    }

    private static void consulta2()
    {
        //Creamos el criterio para los jugadores "el campo deporte debe ser "baloncesto" y el campo Pais.nombre debe ser "España""
        ICriterion criterio = new And().add(Where.equal("deporte","baloncesto")).add(Where.equal("pais.nombrepais","España"));

        //Montamos la consulta
        IQuery query = new CriteriaQuery(Jugadores.class,criterio);

        //Obtenemos los Jugadores que cumplen el criterio
        Objects<Jugadores> jugadores = odb.getObjects(query);

        //Mostramos la información
        int i = 1;
        while(jugadores.hasNext())
        {
            Jugadores jugador = jugadores.next();
            System.out.println(i + ": " + jugador.getNombre() + " (" +jugador.getPais().getNombrepais() + ", con id " +jugador.getPais().getId() + "), practica " + jugador.getDeporte() + " en " + jugador.getCiudad() + " con " +jugador.getEdad() + " años");
            i++;
        }
    }

    private static void modificarPais()
    {
        //Mostramos los paises
        mostrarPaises();

        //Pedimos el id del pais que se quiere modificar
        System.out.println("Indica el id del país que quieres modificar: ");
        int idPais = sc.nextInt();
        String flush = sc.nextLine();

        //Pedimos el nuevo nombre del pais
        System.out.println("Indica el nuevo nombre que quieres que tenga el país");
        String nuevoNombre = sc.nextLine().trim();

        //Sacamos el país de la base de datos
        ICriterion criterio = Where.equal("id",idPais);
        IQuery query = new CriteriaQuery(Paises.class,criterio);
        Objects<Paises> paises = odb.getObjects(query);

        //Si no hay ningún país con el id no se hace nada
        if(paises.isEmpty())
        {
            System.out.println("No hay ningún país con ese id");
            return;
        }

        //cambiamos el campo del nombre
        paises.getFirst().setNombrepais(nuevoNombre);

        //Informamos
        System.out.println("El nombre del país ha sido modificado a \"" + paises.getFirst().getNombrepais() + "\"");
    }


}
