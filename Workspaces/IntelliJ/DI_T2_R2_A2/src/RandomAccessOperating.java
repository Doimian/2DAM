import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessOperating
{
    public static Scanner sc = new Scanner(System.in);
    public static char[] apellido = new char[15];
    public static Empleado[] empleados = new Empleado[10];
    public static StringBuffer tempApellido = null;
    public static int rafPos = 0;
    public static void main(String[] args)
    {
        //Creamos el fichero
        System.out.println("Indica el fichero de acceso aleatorio:");
        File file = new File(sc.nextLine());
        try {
            file.createNewFile();
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            //Creamos los empleados
            empleados[0] = new Empleado(1, "Martí Lara",21,2050.00);
            empleados[1] = new Empleado(2,"Casals Hervas",15,1850.00);
            empleados[2] = new Empleado(3,"Iglesia Osorio",35,1450.00);
            empleados[3] = new Empleado(4,"Barcelo Jordan",76,2750.00);
            empleados[4] = new Empleado(5,"Carbo Mur",5,3050.00);
            empleados[5] = new Empleado(6,"Marin Alcantara",2,9050.00);
            empleados[6] = new Empleado(7,"Mayo Reyes ",20,2550.00);
            empleados[7] = new Empleado(8,"Ayala Estevez",31,1050.00);
            empleados[8] = new Empleado(9,"Chamorro Macias",55,2550.00);
            empleados[9] = new Empleado(10,"Gonzalez Perez",38,20.00);

            //Insertamos los empleados
            for(int i = 0; i < 10; i++)
            {
               raf.writeInt(empleados[i].getId_empleado());
               tempApellido = new StringBuffer(empleados[i].getApellido());
               tempApellido.setLength(15);
               raf.writeChars(tempApellido.toString());
               raf.writeInt(empleados[i].getDepartamento());
               raf.writeDouble(empleados[i].getSalario());
            }

            //Leer los empleados desde el fichero
            Empleado empleadoEj = new Empleado();
            for(;;)
            {
                raf.seek(rafPos);
                empleadoEj.setId_empleado(raf.readInt());

                for(int i = 0; i < 15; i++)
                    apellido[i] = raf.readChar();

                empleadoEj.setApellido(String.valueOf(apellido));
                empleadoEj.setDepartamento(raf.readInt());
                empleadoEj.setSalario(raf.readDouble());

                //Mostramos la info
                System.out.println(empleadoEj.toString());

                //Pasamos al siguiente empleado
                rafPos += 46;

                //Salimos al llegar al final del fichero
                if(raf.getFilePointer()==raf.length()) {break;}
            }

            //Cerramos el fichero
            raf.close();
        } catch (IOException e) {
            System.out.println("El fichero ya existe");
         }
    }
}
