import java.io.File;
import java.util.Scanner;

public class DirScanner
{
    public static void main(String[] args)
    {
        String nombreDirectorio;
        File directorio;
        File[] archivos;
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.print("Nombre del directorio a escanear: ");
        nombreDirectorio = sc.nextLine().trim();
        directorio = new File(nombreDirectorio);
        if (!directorio.isDirectory())
        {
            if (!directorio.exists())
                System.out.println("There is no such directory!");
            else
                System.out.println("That file is not a directory.");
        }
        else
        {
            archivos = directorio.listFiles();
            System.out.println("Archivos en el directorio " + directorio + "\":");
            for (int i = 0; i < archivos.length; i++)
            {
                if(archivos[i].isFile())
                    System.out.println("    [Archivo]     " + archivos[i].getName());
                else
                    System.out.println("   [Directorio]   " + archivos[i].getName());
            }
        }

    }
}
