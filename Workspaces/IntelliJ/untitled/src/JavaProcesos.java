import java.io.IOException;
import java.io.InputStream;
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

    public static void main(String[] args)
    {
        /* Toma una referencia al proceso actual */
        Runtime myRuntime = Runtime.getRuntime();
        printRuntime(myRuntime);

        //Lanza otro proceso
        /*
        try
        {
            Process p = myRuntime.exec("nemo");
            p.waitFor(12, TimeUnit.SECONDS);
            p.destroy();
        } catch (IOException | InterruptedException e)
        {
            System.out.println("Pues parece que algo ha ido mal...");
        }*/

        // ProcessBuilder
        Process p2 = null;
        try{
            p2 = new ProcessBuilder("src/helo2", "300", "1").start();

            // Toma una referencia al flujo de salida
            InputStream is = p2.getInputStream();

            // Lee el flujo
            int caracter;
            while((caracter = is.read()) != -1)
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
            estado = p2.waitFor();
            System.out.println("Valor de estado : " + estado);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
