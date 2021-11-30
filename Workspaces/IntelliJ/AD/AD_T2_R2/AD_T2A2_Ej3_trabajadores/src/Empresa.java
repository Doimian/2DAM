import java.awt.font.TransformAttribute;
import java.io.*;
import java.util.*;

public class Empresa
{
    public static Scanner sc = new Scanner(System.in);
    public static final String file = "ftrabajadores.dat";
    public static ObjectOutputStream oos1;
    public static ObjectOutputStream oos2;
    public static ObjectInputStream ois1;
    public static ObjectInputStream ois2;
    public static final String file_2 = "ftrabajadores_pobres.dat";

    public static Trabajador trabajador;
    public static ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
    private static String trabajadorDni;
    private static String trabajadorNombre;
    private static String trabajadorTelefono;
    private static String trabajadorFecha;
    private static Double trabajadorSalario;

    public static void main(String[] args)
    {
        try {
            //Crear ficheros binarios "ftrabajador.dat" / "ftrabajadores_pobres.dat" y sus Streams correspondientes
            oos1 = new ObjectOutputStream(new FileOutputStream(file));
            oos2 = new ObjectOutputStream(new FileOutputStream(file_2));
            ois1 = new ObjectInputStream(new FileInputStream(file));
            ois2 = new ObjectInputStream(new FileInputStream(file_2));

            //Pedir trabajadores por teclado e ir metiendolos en el fichero
            for(;;)
            {
                //Crear un trabajador
                System.out.println("Crear un nuevo trabajador");
                System.out.println("Introduzca el DNI del trabajador (no para terminar):");
                trabajadorDni = sc.nextLine().trim();
                if(trabajadorDni.toLowerCase().equals("no"))
                    break;
                trabajador = new Trabajador();
                trabajador.setDni(trabajadorDni);
                System.out.println("Introduzca el Nombre del trabajador");
                trabajadorNombre = sc.nextLine().trim();
                trabajador.setNombre(trabajadorNombre);

                System.out.println("Introduzca el teléfono del trabajador");
                trabajadorTelefono = sc.nextLine().trim();
                trabajador.setTelefono(trabajadorTelefono);

                System.out.println("Introduzca la fecha de nacimiento del trabajador");
                trabajadorFecha = sc.nextLine().trim();
                trabajador.setFecha_nacimiento(trabajadorFecha);

                System.out.println("Introduzca el salario del trabajador");
                trabajadorSalario = sc.nextDouble();
                String flush = sc.nextLine();
                trabajador.setSalario(trabajadorSalario);

                //Meter el trabajador que acabamos de crear en el fichero
                oos1.writeObject(trabajador);
            }
            oos1.close();
            //Calcular la media de los salarios leyéndolos todos desde el fichero
            try {
                while(true) {
                    trabajador = (Trabajador) ois1.readObject();
                    System.out.println("[Trabajador] " + trabajador);
                    trabajadores.add(trabajador);
                    //System.out.println("[Trabajador]" + trabajador);
                }
            }catch(EOFException e){/*Utilizamos esta excepcion como rotura del bucle*/}
            ois1.close();
            // Calculamos el sueldo medio
            double mediaSalario = 0.0;
            for (Trabajador t : trabajadores)
            {
                mediaSalario += t.getSalario();
            }
            mediaSalario /= trabajadores.size();

            //Guardar los empleados con salario menor a la media en "ftrabajadores_pobres.dat" y subirles el salario un 20%
            for(Trabajador t : trabajadores)
            {
                if(t.getSalario() <= mediaSalario)
                {
                    t.setSalario((t.getSalario()*1.2));
                    oos2.writeObject(t);
                }
            }
            oos2.close();
            //Mostrar el contenido de "ftrabajadores_pobres.dat"
            System.out.println("Se han añadido los trabajadores con un sueldo menor a la media (" + mediaSalario + ") a un fichero llamado " + file_2 + " y se les ha subido el sueldo un 20%");
            System.out.println("Estos son trabajadores modificados");
            try {
                while(true) {
                    trabajador = (Trabajador) ois2.readObject();
                    System.out.println("[Trabajador] " + trabajador);
                }
            }catch(EOFException e)
            {/*Utilizamos esta excepcion como rotura del bucle*/}
                ois2.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Error al operar con los archivos");
        } catch (ClassNotFoundException e) {
            System.out.println("No hay ningún trabajador en la base de datos");
        } catch (InputMismatchException e)
        {
            System.out.println("Tipo de dato erroneo");
        }
    }
}
