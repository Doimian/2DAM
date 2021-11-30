import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandomAccessOperating
{
    public final static int TAM_EMPLEADO = 46;
    
    public static Scanner sc = new Scanner(System.in);
    public static char[] apellido = new char[15];
    public static Empleado[] empleados = new Empleado[10];
    public static StringBuffer tempApellido = null;
    public static int pointer = 0;
    public static RandomAccessFile raf = null;
    
    public static void main(String[] args)
    {
        //Creamos el fichero
        System.out.println("Indica el fichero de acceso aleatorio:");
        File file = new File(sc.nextLine());
        try {
            //Creamos el fichero de acceso aleatorio
            file.createNewFile();
             raf = new RandomAccessFile(file, "rw");

            //Creamos los empleados
            createEmpleados();

            //Insertamos los empleados
            insertEmpleados();

            int j = 1;
            while(j > 0 && j < 4)
                 j = menu();

            //Cerramos el fichero
            raf.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error en el manejo del fichero\n" + e.getMessage());
         }
    }
    public static int menu()
    {
        System.out.println("Elija una opción del menú de la aplicación:");
        System.out.println("1. Mostrar los datos de todos los empleados");
        System.out.println("2. Mostrar los datos de un empleado según la ID");
        System.out.println("3. Modificar los datos de un empleado según la ID");
        System.out.println("4. Salir de la aplicación");
        int i = sc.nextInt();
        String flush = sc.nextLine();
        switch (i)
        {
            case 1:
                //Leer los empleados desde el fichero
                System.out.println("Empleados en el fichero: ");
                readEmpleados();
                break;

            case 2:
                //Pedimos la ID de un empleado para extraer solo su información
                pickEmpleado();
                break;

            case 3:
                //Pedimos la ID de un empleado para modificar sus datos
                modEmpleado();
                break;

            default:
                System.out.println("Bye...");
        }
        System.out.println("\n");
        return i;
    }

    public static void createEmpleados()
    {
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
    }

    public static void insertEmpleados() throws IOException {
        //poner el puntero al principio del fichero
        raf.seek(0);
        try {
            for (int i = 0; i < 10; i++) {
                raf.writeInt(empleados[i].getId_empleado());
                tempApellido = new StringBuffer(empleados[i].getApellido());
                tempApellido.setLength(15);
                raf.writeChars(tempApellido.toString());
                raf.writeInt(empleados[i].getDepartamento());
                raf.writeDouble(empleados[i].getSalario());
            }
        }catch(IOException e)
        {
            System.out.println("Ha ocurrido un error en la insercion de datos\n" + e.getMessage());
        }
    }

    public static void readEmpleados()
    {
        //Creamos un empleado temporal
        Empleado empleadoEj = new Empleado();

        //Colocamos el puntero del raf al principio del archivo por si acaso
        pointer = 0;

        //Hacemos un bucle que se rompa cuando el puntero del raf llega al final del archivo
        for(;;)
        {
            try {
                raf.seek(pointer);
                empleadoEj.setId_empleado(raf.readInt());

                for (int i = 0; i < 15; i++)
                    apellido[i] = raf.readChar();

                empleadoEj.setApellido(String.valueOf(apellido));
                empleadoEj.setDepartamento(raf.readInt());
                empleadoEj.setSalario(raf.readDouble());

                //Mostramos la info
                System.out.println(empleadoEj.toString());

                //Pasamos al siguiente empleado
                pointer += TAM_EMPLEADO;

                //Salimos al llegar al final del fichero
                if (raf.getFilePointer() == raf.length()) {
                    break;
                }
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error producido por el puntero del fichero \n"+ e.getMessage());
            }
        }
    }

    public static void pickEmpleado() {
        //Creamos un empleado temporal
        Empleado empleadoEj = new Empleado();

        //Introducimos la ID por pantalla
        System.out.println("\nEscribe la ID de un empleado para extraer solo su información: ");
        int empID = sc.nextInt();
        String flush = sc.nextLine();
        try {
            //Comprobamos que la ID es válida
            if (empID > 0 && empID < 11) {
                //Ponemos el puntero del raf en el principio del fichero
                raf.seek(0);

                //Buscamos el principio del Empleado que se haya solicitado
                raf.seek((empID-1) * TAM_EMPLEADO);

                //Leemos el empleado
                empleadoEj.setId_empleado(raf.readInt());

                for (int i = 0; i < 15; i++)
                    apellido[i] = raf.readChar();
                empleadoEj.setApellido(String.valueOf(apellido));
                empleadoEj.setDepartamento(raf.readInt());
                empleadoEj.setSalario(raf.readDouble());

                //Mostramos la info
                System.out.println("Empleado:");
                System.out.println(empleadoEj.toString());

            } else //La ID no es válida
                System.out.println("La id debe ser un número entre el 1 y el 10");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error producido por el puntero del fichero \n" + e.getMessage());
        }
    }

    public static void modEmpleado()
    {
        //Creamos un empleado temporal
        Empleado empleadoEj = new Empleado();

        //Introducimos la ID por pantalla
        System.out.println("\nEscribe la ID de un empleado para modificar sus datos: ");
        int empID = sc.nextInt();
        String flush = sc.nextLine();
        try {
            //Comprobamos que la ID es válida
            if (empID > 0 && empID < 11) {
                //Ponemos el puntero del raf en el principio del fichero
                raf.seek(0);

                //Buscamos el principio del Empleado que se haya solicitado
                raf.seek((empID-1) * TAM_EMPLEADO);

                //Solicitamos la nueva información del empleado
                empleadoEj.setId_empleado(empID);
                System.out.println("Escriba el nuevo apellido del empleado: ");
                empleadoEj.setApellido(sc.nextLine());
                System.out.println("Escriba el nuevo departamento del empleado: ");
                empleadoEj.setDepartamento(sc.nextInt());
                flush = sc.nextLine();
                System.out.println("Escriba el nuevo salario del empleado: ");
                empleadoEj.setSalario(sc.nextDouble());

                //Escribimos los datos en el fichero
                raf.writeInt(empleadoEj.getId_empleado());
                tempApellido = new StringBuffer(empleadoEj.getApellido());
                tempApellido.setLength(15);
                raf.writeChars(tempApellido.toString());
                raf.writeInt(empleadoEj.getDepartamento());
                raf.writeDouble(empleadoEj.getSalario());

                //Sacamos la información del fichero
                raf.seek((empID-1) * TAM_EMPLEADO);
                empleadoEj.setId_empleado(raf.readInt());

                for (int i = 0; i < 15; i++)
                    apellido[i] = raf.readChar();

                empleadoEj.setApellido(String.valueOf(apellido));
                empleadoEj.setDepartamento(raf.readInt());
                empleadoEj.setSalario(raf.readDouble());

                //Mostramos la info
                System.out.println(empleadoEj.toString());

            } else //La ID no es válida
                System.out.println("La id debe ser un número entre el 1 y el 10");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error producido por el puntero del fichero \n" + e.getMessage());
        }
    }
}
