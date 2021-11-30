import javax.swing.*;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class MenuApp
{
    private static Scanner sc;
    public static void main(String[] args)
    {
        sc = new Scanner(System.in);
        int codigo = 0;
        while(codigo != 8)
        {
            String flush;
            System.out.println("Elige una de las siguientes operaciones:");
            System.out.println("1. Crear un nuevo directorio");
            System.out.println("2. Crear un fichero vacio");
            System.out.println("3. Listar el contenido de un fichero o directorio");
            System.out.println("4. Renombrar un fichero o directorio");
            System.out.println("5. Borrar un fichero o directorio");
            System.out.println("6. Introducir una cadena de texto en un fichero");
            System.out.println("7. Añadir texto a un fichero existente");
            System.out.println("8. Cerrar el programa");
            codigo = sc.nextInt();
            flush = sc.nextLine();

            menu(codigo);
            System.out.println("\n");
        }
    }


    private static int menu(int n)
    {

        switch (n) {
            case 1:
                createDir();
                break;
            case 2:
                createFile();
                break;
            case 3:
                viewContent();
                break;
            case 4:
                rename();
                break;
            case 5:
                delFile();
                break;
            case 6:
                writeFile();
                break;
            case 7:
                appendFile();
                break;
            case 8:
                System.out.println("Bye...");
                return n;
            default:
                System.out.println("Introduzca un numero del menu");
                break;
        }
        return n;
    }
    private static void createDir()
    {
        System.out.println("Indica la ruta que quieres que tenga el directorio (incluyendo su nombre):");
        String dirName = sc.nextLine().trim();
        File file = new File(dirName);
        if(!file.exists())
        {
                file.mkdir();
                System.out.println("El directorio " + file.getName() + " ha sido creado en la ruta" + file.getAbsolutePath());

        }
        else
        {
            System.out.println("El Directorio ya existe");
        }

    }
    private static void createFile()
    {
        System.out.println("Indica la ruta que quieres que tenga el fichero (incluyendo su nombre):");
        String fileName = sc.nextLine().trim();
        File file = new File(fileName);
        if(!file.exists())
        {
            try
            {
                file.createNewFile();
                System.out.println("El fichero " + file.getName() + " ha sido creado en la ruta" + file.getAbsolutePath() + "");

            } catch (IOException e) {
                System.out.println("El Fichero no ha podido ser creado");
            }
        }
        else
        {
            System.out.println("El Fichero ya existe");
        }
    }
    private static void viewContent()
    {
        System.out.println("Indica la ruta del fichero:");
        String fileName = sc.nextLine().trim();
        File file = new File(fileName);
        if( file.exists())
        {
            if(file.isFile())
            {
                try
                {
                    FileReader fr = new FileReader(file);
                    long filelength = file.length();
                    char fileContent[] = new char[(int) filelength];
                    fr.read(fileContent, 0, (int) filelength);
                    System.out.println(fileContent);
                    fr.close();
                } catch (NullPointerException e) {
                    System.out.println("El fichero está vacio");
                } catch (IOException e) {
                    System.out.println("El fichero no existe o no es accesible");
                }
            }
            if(file.isDirectory())
            {
                    File[] archivos;
                    {
                        archivos = file.listFiles();
                        int len = archivos.length;
                        System.out.println("Archivos en el directorio " + file + "\":");
                        for (int i = 0; i < len; i++)
                        {
                            if(archivos[i].isFile())
                                System.out.println("    [Archivo]     " + archivos[i].getName());
                            else
                                System.out.println("   [Directorio]   " + archivos[i].getName());
                        }
                    }
            }
        }
        else
        {
            System.out.println("El Fichero no existe");
        }
    }
    private static void rename()
    {
        System.out.println("Indica la ruta del fichero a renombrar: ");
        String preName = sc.nextLine().trim();
        System.out.println("Indica el nuevo nombre del fichero (con el mismo tipo de ruta):");
        String postName = sc.nextLine().trim();
        File preFile = new File(preName);
        File postFile = new File(postName);
        if( preFile.exists())
        {
            if(!postFile.exists())
            {
                preFile.renameTo(postFile);
                System.out.println("El fichero \"" + preName + "\" ha sido renombrado a \"" + postName + "\"");
            }
            else
            {
                System.out.println("Ya existe un fichero llamado \"" + postName +"\"");
            }
        }
        else
        {
            System.out.println("El Fichero no existe");
        }
    }
    private static void delFile()
    {
        System.out.println("Indica la ruta del fichero para eliminar: ");
        String delFile = sc.nextLine().trim();
        File file = new File(delFile);
        if(file.exists())
        {
            file.delete();
            System.out.println("El fichero \"" + delFile + "\" se ha eliminado correctamente");
        }
        else
            System.out.println("El fichero \"" + delFile + "\" no ha sido encontrado");
    }
    private static void writeFile()
    {
        System.out.println("Indica la ruta del fichero para sobreescribir");
        String f = sc.nextLine().trim();
        File file = new File(f);
        if(file.exists())
        {
            try {
                FileWriter fw = new FileWriter(file, false);
                BufferedWriter bfw = new BufferedWriter(fw);
                System.out.println("¿Que texto quieres añadir?");
                String content = sc.nextLine();
                bfw.write(content);
                bfw.newLine();
                bfw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("El fichero no es accesible");
            }
        }
        else
        {
            System.out.println("El fichero no existe");
        }
    }
    private static void appendFile()
    {
        System.out.println("Indica la ruta del fichero para añadir contenido");
        String f = sc.nextLine().trim();
        File file = new File(f);
        if(file.exists())
        {
            try {
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bfw = new BufferedWriter(fw);
                System.out.println("¿Que texto quieres añadir?");
                String content = sc.nextLine();
                bfw.write(content);
                bfw.newLine();
                bfw.close();
                fw.close();

            } catch (IOException e) {
                System.out.println("El fichero no es accesible");
            }
        }
        else
        {
            System.out.println("El fichero no existe");
        }
    }
}

