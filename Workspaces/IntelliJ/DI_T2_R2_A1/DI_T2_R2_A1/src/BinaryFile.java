import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinaryFile
{
    private static Scanner sc = new Scanner(System.in);
    private static final byte[] listabytes = new byte[] {1,2,4,32,32,5,'d',9,45,2,100,121,'x',6,1,6,7,'a',5,4,45,56,34,2,'z',56,7,'+',23,57,};
    private static final byte[] leerBytes = new byte[listabytes.length];
    public static void main(String[] args)
    {
        File file;
        System.out.println("Introduzca el nombre del fichero Binario (con ruta absoluta o relativa)");
        file = new File(sc.nextLine());
        try
        {
            //Creamos el fichero
            file.createNewFile();

            //Creamos los Streams
            InputStream is = new FileInputStream(file);
            OutputStream os = new FileOutputStream(file);

            //Escribimos el array de bytes
            os.write(listabytes);

            //Leemos los bytes del archivo
            is.read(leerBytes);

            //Cerramos los Streams
            is.close();
            os.close();

            //Mostramos los datos
            System.out.println("Los bytes originales son ==============> " + Arrays.toString(listabytes));
            System.out.println("Los bytes leidos desde el fichero son => " + Arrays.toString(leerBytes));
        } catch (IOException e) {
            System.out.println("El fichero ya existe");
        }
    }

}
