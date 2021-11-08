import java.io.*;
import java.util.Scanner;

public class cpyCont
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] content = new String[0];
        String lineContent;
        System.out.println("Indica:");
        System.out.println("El nombre del fichero de origen: ");
        System.out.println("El fichero destino (no debe existir)");
        File file = new File(sc.nextLine().trim());
        File file2 = new File(sc.nextLine().trim());
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(file));
            BufferedWriter bfw = new BufferedWriter(new FileWriter(file,true));
            for(int i = 0; i < 20; i++)
            {
                if((lineContent = bfr.readLine()) != null)
                {
                    bfw.write(lineContent);
                    content[i] = lineContent;
                }
                else {
                    System.out.println("El fichero tiene menos de 20 lineas de contenido");
                    break;
                }
                System.out.println("El contenido de las primeras 20 lineas del fichero es:");
                for(int j = 0; j <= i; j++)
                {
                    System.out.println(content[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
