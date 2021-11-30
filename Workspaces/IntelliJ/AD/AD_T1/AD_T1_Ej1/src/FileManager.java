import java.io.File;

public class FileManager<filename>
{
    public static void main(String[] args)
    {
        File file = new File("/home/damian/2DAM/Workspaces/IntelliJ/src/verInf.java");
        System.out.println("Nombre del fichero: " + file.getName());
        System.out.println("Ruta del fichero" + file.getPath());
        System.out.println("Ruta absoluta del fichero: " + file.getAbsolutePath());
        System.out.println("Se puede escribir: " + file.canRead());
        System.out.println("Se puede Leer: " + file.canWrite());
        System.out.println("Tamaño del fichero: " + file.length());
        System.out.println("Es un directorio: " + file.isDirectory());
        System.out.println("Es un fichero: " + file.isFile());

    }

}
