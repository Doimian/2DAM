
import java.util.Scanner;

import org.hibernate.Session;

import config.HibernateUtil;

public class Init
{
	//Iniciamos la sesión hibernate
    private static Session sesionHibernate = HibernateUtil.getSessionFactory().openSession();
    private static Scanner sc = new Scanner(System.in);

    public static void main( String[] args )
    {
        //datosIniciales();

        menu();
        
        sesionHibernate.close();
    }

	public static void menu()
	{
		int index = 0;
        while(index < 5)
        {
            System.out.println("\nSelecciona una opcion (otro numero para salir)");    
            System.out.println("1. Mostrar Estadísticas de un jugador");    
            System.out.println("2. Mostrar los equipos con las estadísticas de sus jugadores");
            System.out.println("3. Insertar estadísticas para un jugador");
            System.out.println("4. Modificar las estadísticas de un jugador");
            index = sc.nextInt();
            String flush = sc.nextLine();
            switch(index)
            {
                case 1: mostrarEstadisticasJugador(); break;
                case 2: mostrarEquipos(); break;
                case 3: insertarEstadisticas(); break;
                case 4: modificarEstadisticas(); break;
                default: System.out.println("Bye..."); return;
            }
        }
	}

    private static void modificarEstadisticas() 
    {
    
    }

    private static void insertarEstadisticas() 
    {
    
    }

    private static void mostrarEquipos() 
    {
    
    }

    private static void mostrarEstadisticasJugador() 
    {
    
    }

}