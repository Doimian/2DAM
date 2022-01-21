import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.Scanner;

public class EjemploNeodatis {

    private static Scanner sc = new Scanner(System.in);

    //Creamos la base de datos
    private static ODB odb = ODBFactory.open("/home/damian/2DAM/Workspaces/Neodatis/test.neodatis");

    public static void main(String[] args)
    {
        //Creaoms jugadores
        Jugadores j1 = new Jugadores("Maria","voleibol","Madrid",17);
        Jugadores j2 = new Jugadores("Juan","baloncesto","Málaga",20);
        Jugadores j3 = new Jugadores("Elena","tenis","Barcelona",15);
        Jugadores j4 = new Jugadores("Alicia","fútbol","Teruel",16);


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
            System.out.println("1. Insertar un nuevo jugador");
            System.out.println("2. Visualizar los jugadores en pantalla");
            System.out.println("3. Buscar un jugador específico");
            System.out.println("4. Realizar una consulta simple");
            System.out.println("5. Realizar una modificación en un objeto");
            System.out.println("6. Eliminar un objeto de la base de datos");
            System.out.println("7. Salir de la aplicación");
            int opcion = sc.nextInt();
            String flush = sc.nextLine();
            switch(opcion)
            {
                case 1: insertarJugador();
                        break;

                case 2: mostrarJugadores();
                        break;

                case 3: mostrarJugador();
                        break;

                case 4: consultaSimple();
                        break;

                case 5: modificarObjeto();
                        break;

                case 6: eliminarObjeto();
                        break;

                case 7: System.out.println("Bye...");
                        return;
            }
        }
    }
    private  static void insertarJugador()
    {
        //Pedimos los datos del nuevo jugador
        System.out.println("Nombre del Jugador: ");
        String nombre = sc.nextLine().trim();
        System.out.println("Deporte que practica el jugaodr: ");
        String deporte = sc.nextLine().trim();
        System.out.println("Ciudad del jugador: ");
        String ciudad = sc.nextLine().trim();
        System.out.println("Edad del jugador: ");
        int edad = sc.nextInt();
        String flush = sc.nextLine();

        //Creamos el nuevo jugador
        Jugadores nuevoJugador = new Jugadores(nombre, deporte, ciudad, edad);

        //Guardamos el nuevo jugador en la base de datos
        odb.store(nuevoJugador);

        //Informamos
        System.out.println( nombre + " ha sido añadido a la base de datos de jugadores.\n");

    }

    private static void mostrarJugadores()
    {
        //Sacamos los jugadores
        Objects<Jugadores> jugadores = odb.getObjects(Jugadores.class);
        System.out.println(jugadores.size() + " Jugadores:");

        //visualizamos los jugadores
        int i = 1;
        while(jugadores.hasNext())
        {
            Jugadores jugador = jugadores.next();
            System.out.println(i + ": " + jugador.getNombre() + " practica " + jugador.getDeporte() + " en " + jugador.getCiudad() + " con " +jugador.getEdad() + " años");
            i++;
        }
    }

    private static void mostrarJugador()
    {
        System.out.println("Escribe el criterio por el que filtrar al jugador (nombre, deporte, ciudad, edad): ");
        String campo = sc.nextLine().trim();
        switch(campo) {
            case "nombre":
            case "deporte":
            case "ciudad":
            case "edad":
                break;
            default:
                System.out.println("Error, revisa el criterio");
                return;
        }
        System.out.println("Escribe el valor del criterio para filtrar");
        String valor = sc.nextLine().trim();

        //Creamos el criterio
        ICriterion criterio = Where.equal(campo, valor);

        //Montamos la consulta
        IQuery query = new CriteriaQuery(Jugadores.class, criterio);

        //Obtenemos los jugadores que cumplen el criterio
        Objects<Jugadores> jugadores = odb.getObjects(query);

        //Mostramos la información
        System.out.println("Hay " + jugadores.size() + " jugadores que cumplen con el criterio: ");
        int i = 1;
        while(jugadores.hasNext())
        {
            Jugadores jugador = jugadores.next();
            System.out.println(i + ": " + jugador.getNombre() + " practica " + jugador.getDeporte() + " en " + jugador.getCiudad() + " con " +jugador.getEdad() + " años");
            i++;
        }
    }

    private static void consultaSimple()
    {
        ICriterion criterio = null;
        System.out.println("Elige la consulta que quieres realizar:");
        System.out.println("1. Mostrar los jugadores de edad > 10 y que sean de la ciudad = “Madrid”");
        System.out.println("2. Mostrar los jugadores que jueguen al “baloncesto” o cuyo nombre empiece por la letra “M”");
        int opcion = sc.nextInt();
        String flush = sc.nextLine();

        //Creamos el criterio
        switch (opcion)
        {
            case 1:
                criterio = new And().add(Where.gt("edad",10)).add(Where.equal("ciudad","Madrid"));
                break;
            case 2:
                criterio = new And().add(Where.like("nombre","M%")).add(Where.equal("deporte","baloncesto"));
                break;
            default:
                System.out.println("Error, solo se aceptan los valores 1 y 2");
                return;
        }

        //Montamos la consulta
        IQuery query = new CriteriaQuery(Jugadores.class, criterio);

        //Obtenemos los jugadores que cumplen el criterio
        Objects<Jugadores> jugadores = odb.getObjects(query);

        //Mostramos la información
        System.out.println("Hay " + jugadores.size() + " jugadores que cumplen con el criterio: ");
        int i = 1;
        while(jugadores.hasNext())
        {
            Jugadores jugador = jugadores.next();
            System.out.println(i + ": " + jugador.getNombre() + " practica " + jugador.getDeporte() + " en " + jugador.getCiudad() + " con " +jugador.getEdad() + " años");
            i++;
        }
    }

    private static void modificarObjeto()
    {
        System.out.println("Escribe el criterio por el que filtrar al jugador (nombre, deporte, ciudad, edad): ");
        String campo = sc.nextLine().trim();
        switch(campo) {
            case "nombre":
            case "deporte":
            case "ciudad":
            case "edad":
                break;
            default:
                System.out.println("Error, revisa el criterio");
                return;
        }
        System.out.println("Escribe el valor del criterio para filtrar");
        String valor = sc.nextLine().trim();

        //Creamos el criterio
        ICriterion criterio = Where.equal(campo, valor);

        //Montamos la consulta
        IQuery query = new CriteriaQuery(Jugadores.class, criterio);

        //Obtenemos los jugadores que cumplen el criterio
        Objects<Jugadores> jugadores = odb.getObjects(query);

        //Aislamos el primer objeto y lo borramos de la base de datos
        Jugadores jugador = jugadores.getFirst();
        odb.delete(jugador);
        System.out.println(jugador.getNombre() + " practica " + jugador.getDeporte() + " en " + jugador.getCiudad() + " con " +jugador.getEdad() + " años");

        //Lo modificamos
        System.out.println("Escribe el criterio para modificarle al jugador (nombre, deporte, ciudad, edad): ");
        campo = sc.nextLine().trim();
        System.out.println("Escribe el nuevo valor");
        valor = sc.nextLine().trim();
        switch(campo) {
            case "nombre": jugador.setNombre(valor); break;
            case "deporte": jugador.setDeporte(valor); break;
            case "ciudad": jugador.setCiudad(valor); break;
            case "edad": jugador.setEdad(Integer.parseInt(valor)); break;
            default:
                System.out.println("Error, revisa el criterio");
                return;
        }

        //Guardamos el jugador
        odb.store(jugador);
        System.out.println("El jugador " + jugador.getNombre() + " ha sido modificado con exito");
    }

    private static void eliminarObjeto()
    {
        System.out.println("Escribe el criterio por el que filtrar al jugador (nombre, deporte, ciudad, edad): ");
        String campo = sc.nextLine().trim();
        switch(campo) {
            case "nombre":
            case "deporte":
            case "ciudad":
            case "edad":
                break;
            default:
                System.out.println("Error, revisa el criterio");
                return;
        }
        System.out.println("Escribe el valor del criterio para filtrar");
        String valor = sc.nextLine().trim();

        //Creamos el criterio
        ICriterion criterio = Where.equal(campo, valor);

        //Montamos la consulta
        IQuery query = new CriteriaQuery(Jugadores.class, criterio);

        //Obtenemos los jugadores que cumplen el criterio
        Objects<Jugadores> jugadores = odb.getObjects(query);

        //Borramos el jugador
        Jugadores jugador = jugadores.getFirst();
        odb.delete(jugador);

        //Indicamos que el jugador ha sido eliminado de la base de datos
        System.out.println("El jugador "+ jugador.getNombre() + " ha sido eliminado de la base de datos");
    }
}
