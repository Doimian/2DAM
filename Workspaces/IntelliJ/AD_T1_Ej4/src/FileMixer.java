import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileMixer
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica:");
        System.out.println("Primer fichero de origen: ");
        String fileName1 = sc.nextLine().trim();

        System.out.println("Segundo fichero de origen: ");
        String fileName2 = sc.nextLine().trim();
        System.out.println("Fichero resultado (no debe existir)");
        String fileName3 = sc.nextLine().trim();

        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File file3 = new File(fileName3);
        if(!file3.exists())
        {
            try
            {
                int i = 0;
                ArrayList<String> file1Content = new ArrayList<String>();;
                ArrayList<String> file2Content = new ArrayList<String>();;

                String temp = null;

                String temp2 = null;
                file3.createNewFile();
                BufferedReader bfr = new BufferedReader(new FileReader(file1));
                BufferedReader bfr2 = new BufferedReader(new FileReader(file2));
                BufferedWriter bfw = new BufferedWriter(new FileWriter(file3));

                while((temp = bfr.readLine()) != null || (temp2 = bfr2.readLine()) != null )
                {
                    if(temp != null)
                        file1Content.add(temp + "\n");
                    if(temp2 != null)
                        file2Content.add(temp2 + "\n");
                }
                for(i = 0; i < file1Content.size() || i < file2Content.size(); i++)
                {
                    try {
                        System.out.println(file1Content.get(i));
                        bfw.write(file1Content.get(i));

                    }catch(IndexOutOfBoundsException e)
                    {
                        //Fin del 1er fichero
                    }
                    try
                    {
                        System.out.println(file2Content.get(i));
                        bfw.write(file2Content.get(i));
                    }catch(IndexOutOfBoundsException e)
                    {
                        //Fin del 1er fichero
                    }

                }
                bfw.close();
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
