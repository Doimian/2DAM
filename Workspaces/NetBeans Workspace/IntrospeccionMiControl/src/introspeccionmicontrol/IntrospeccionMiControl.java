package introspeccionmicontrol;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import miscontroles.micontrol.MiControl;


public class IntrospeccionMiControl 
{

    public static void main(String[] args) 
    {
        MiControl micontrol = new MiControl();
        System.out.println("La clase a la que pertenece micontrol es: " + micontrol.getClass());
        
        Class c1 = micontrol.getClass();
        
        muestraLosCampos(c1);
        System.out.println("\n");
        muestraLosConstructores(c1);
        System.out.println("\n");
        muestraLosMetodos(c1);
        
    }

    private static void muestraLosConstructores(Class c1) 
    {
        Constructor[] constructores = c1.getDeclaredConstructors();
        System.out.println("Los constructores de la clase son: ");
        for(Constructor c: constructores)
        {
            String nombre = c.getName();
            Class[] tipoParams = c.getParameterTypes();
            System.out.print("  " + Modifier.toString(c.getModifiers()));
            System.out.print("  " + nombre + " (");
            for(int i=0; i<tipoParams.length;i++)
            {
                if(i>0) System.out.print(", ");
                System.out.print(tipoParams[i].getName());
            }
            System.out.print(")\n");
        }
    }

    private static void muestraLosCampos(Class c1) 
    {
        Field[] campos = c1.getDeclaredFields();
        System.out.println("Los campos de la clase son: ");
        for(Field c: campos)
        {
            String nombre = c.getName();
            System.out.print("  " + Modifier.toString(c.getModifiers()));
            System.out.print("  " + nombre + " (");
            for(int i=0; i<campos.length;i++)
            {
                if(i>0) System.out.print(", ");
                System.out.print(campos[i].getName());
            }
            System.out.print(")\n");
        }
    }

    private static void muestraLosMetodos(Class c1) 
    {
        Method[] metodos = c1.getDeclaredMethods();
        System.out.println("Los metodos de la clase son: ");
        for(Method m: metodos)
        {
            String nombre = m.getName();
            System.out.print("  " + Modifier.toString(m.getModifiers()));
            System.out.print("  " + nombre + " (");
            for(int i=0; i<metodos.length;i++)
            {
                if(i>0) System.out.print(", ");
                System.out.print(metodos[i].getName());
            }
            System.out.print(")\n");
        }
    }
}
