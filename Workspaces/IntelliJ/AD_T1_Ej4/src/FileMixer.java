import java.io.*;
import java.util.Scanner;

public class FileMixer
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica:");
        System.out.println("Primer fichero de origen: ");
        System.out.println("Segundo fichero de origen: ");
        System.out.println("Fichero resultado (no debe existir)");

        String fileName1 = sc.nextLine().trim();
        String fileName2 = sc.nextLine().trim();
        String fileName3 = sc.nextLine().trim();

        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File file3 = new File(fileName3);
        if(!file3.exists())
        {
            try
            {
                int i = 0;
                String[] file1Content = null;
                String[] file2Content = null;
                String temp;
                file3.createNewFile();
                BufferedReader bfr = new BufferedReader(new FileReader(file1));
                BufferedReader bfr2 = new BufferedReader(new FileReader(file2));
                BufferedWriter bfw = new BufferedWriter(new FileWriter((file3)));
                while((temp = bfr.readLine()) != null)
                {
                    file1Content[i] = temp;
                    i++;
                }
                i = 0;
                while((temp = bfr.readLine()) != null)
                {
                    file2Content[i] = temp;
                    i++;
                }
                for(i = 0;file1Content[i] != null || file2Content[i] != null; i++)
                {
                    bfw.write(file1Content[i]);
                    bfw.write(file2Content[i]);
                }
            } catch (FileNotFoundException e)
            {
                System.out.println("Alguno de los ficheros no existe");
            } catch (IOException e)
            {
                System.out.println("El fichero resultado no ha podido ser creado");
            }
        }
        else
        {
            System.out.println("Ya existe un fichero resultado, eliminalo o renombralo");
        }
    }
}
