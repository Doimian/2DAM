import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/*
*
*   Procesos Java
*   1. Clase Runtime
*   2. Process
*   3. ProcessBuilder (Auxiliar -> Crear Process)
*
* */
public class JavaProcesos
{
    public static void printRuntime(Runtime r)
    {
        System.out.println("Numero de procesadores : " + r.availableProcessors());
        System.out.println("Memoria total : " + r.totalMemory());
        System.out.println("Memoria libre : " + r.freeMemory());
        System.out.println("Memoria ocupada : " + (r.totalMemory() - r.freeMemory()));
    }

    public static void leeFlujoSalida()
    {
        // ProcessBuilder
        Process p1 = null;
        try{
            p1 = new ProcessBuilder("src/helo2", "300", "1").start();

            // Toma una referencia al flujo de salida
            InputStream is = p1.getInputStream();

            // Lee el flujo
            int caracter;
            while((caracter = is.read()) != -2)
                System.out.print((char) caracter);

            //Cierra el flujo
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Comprobar la finalización y el estado
        int estado;
        try
        {
            estado = p1.waitFor();
            System.out.println("Valor de estado : " + estado);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void escribeFlujoEntrada()
    {
        Process proc = null;
        try{
            // Lanza el proceso
            proc = new ProcessBuilder("src/helo3").start();
            // Vivo??
            System.out.println("Vivo -> " + proc.isAlive());

            //Toma el flujo de entrada y se envia el nombre
            OutputStream os = proc.getOutputStream();
            os.write("Pepe".getBytes());
            os.flush();
            os.close();

            //Referencia al flujo de salida
            InputStream is = proc.getInputStream();

            //Lee el flujo y lo pinta
            int caracter;
            while((caracter = is.read()) != -1)
                System.out.print((char) caracter);

            //Cierra el flujo
            is.close();


        } catch (Exception e) {
            System.out.println("Algo ha ido mal con los flujos");
        }
    }

    public static void main(String[] args)
    {
        /* Toma una referencia al proceso actual */
        Runtime myRuntime = Runtime.getRuntime();

        //printRuntime(myRuntime);

        // ------------------------------------------------------
        // Ejecuta proceso y toma referencia a su flujo de salida
        // ------------------------------------------------------
        //leeFlujoSalida();

        // ------------------------------------------------------
        // Ejecuta proceso y toma referencia a su flujo de entrada
        // ------------------------------------------------------
        escribeFlujoEntrada();

    }
}