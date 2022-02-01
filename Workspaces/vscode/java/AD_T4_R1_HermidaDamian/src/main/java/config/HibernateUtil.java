package config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sesion;

    static{
        try{
            sesion = new Configuration().configure().buildSessionFactory();
        }catch(Throwable ex){
            System.out.println("Error: " + ex.getMessage());
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sesion;
    }
}