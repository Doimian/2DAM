import java.util.Scanner;
import org.hibernate.Session;
import config.HibernateUtil;

public class Programa 
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

    private static void menu() {
        System.out.println("hey");
    }
}
