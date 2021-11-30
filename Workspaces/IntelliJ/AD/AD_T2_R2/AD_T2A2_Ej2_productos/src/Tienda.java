import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tienda {
    private static final int PRODUCT_SIZE = 12;
    private static int prod_cod = 0;
    private static int prod_cod2 = 0;
    private static double prod_precio = 0;
    private static int pointer;
    private static Scanner sc = new Scanner(System.in);
    private static RandomAccessFile raf;

    public static void main(String[] args) {
        try
        {
            raf = new RandomAccessFile("fproducto.dat", "rw");


            //Pedimos productos por teclado
            for(;;)
            {
                //Pedir productos
                System.out.println("Introduzca el precio de un nuevo producto! (0.00 para terminar)");
                prod_precio = sc.nextDouble();
                String flush = sc.nextLine();
                if (prod_precio == 0.00) {
                    break;
                } else
                {
                    //Asignamos indice al producto
                    prod_cod += PRODUCT_SIZE;

                    //Guardamos el producto en el fichero
                    raf.seek(prod_cod);
                    raf.writeInt(prod_cod);
                    raf.writeDouble(prod_precio);

                    //Notificamos de la operación
                    System.out.println("Se ha almacenado un nuevo producto con indice " + prod_cod + " y precio " + prod_precio + "€");

                }
            }

            //Mostramos datos
            raf.seek(0);
            System.out.println("En la base de datos hay " + raf.length()/12 + " productos almacenados: ");
            int i = 1;
            while(raf.getFilePointer() != raf.length())
            {
                System.out.println("[Producto " + i + "]: ID : " + raf.readInt() + ";   Precio : " + raf.readDouble() +"€");
                i++;
            }

            //Aumentar precios
            for(;;)
            {
                System.out.println("Escribe el ID de un producto para aumentar su precio en un 10% (-1 para salir)");
                prod_cod = sc.nextInt();
                String flush = sc.nextLine();
                if(!(prod_cod == -1))
                {
                    raf.seek(prod_cod + 4);
                    prod_precio = raf.readDouble() * 1.1;
                    raf.seek(prod_cod + 4);
                    raf.writeDouble(prod_precio);
                    System.out.println("Precio aumentado con éxito");
                }else
                    break;
            }
            //Mostramos datos
            raf.seek(0);
            System.out.println("Tras modificar los precios, la base de datos queda así: ");
            i = 1;
            while(raf.getFilePointer() != raf.length())
            {
                System.out.println("[Producto " + i + "]: ID : " + raf.readInt() + ";   Precio : " + raf.readDouble() +"€");
                i++;
            }
                sc.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("No existe el fichero 'fproducto.dat' " + e.getMessage());
        }catch (InputMismatchException e)
        {
            System.out.println("Error al introducir los datos\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al operar con el fichero\n" + e.getMessage());
        }
    }
}



