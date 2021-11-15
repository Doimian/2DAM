import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class cpyCont
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> content= new ArrayList<String>();
        String lineContent;
        System.out.println("Indica:");
        System.out.println("El fichero destino (no debe existir)");
        File file = new File(sc.nextLine().trim());
        System.out.println("Escriba 20 lineas de contenido por el teclado:");
        for(int i= 0; i < 20; i++)
        {
            content.add(sc.nextLine() + "\n");
        }
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(file,true));
            for(int i = 0; i < 20; i++)
            {
                    bfw.write(content.get(i));
            }
            System.out.println("Fichero creado y escrito con exito");
            bfw.close();
        } catch (IOException e) {
            System.out.println("El fichero no ha podido ser creado o ya existe");
        }

    }
}
