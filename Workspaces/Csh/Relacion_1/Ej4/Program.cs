using System;

public class Program
{
    static void Main(String[] args)
    {
        //Variables
        Electrodomestico[] electrodomésticos = new Electrodomestico[10];
        electrodomésticos[0] = new Television(40, false, 350, Electrodomestico.Colores.negro, 50, Electrodomestico.Letras.D);
        electrodomésticos[1] = new Television(53, true, 600, Electrodomestico.Colores.negro, 33, Electrodomestico.Letras.D);
        electrodomésticos[2] = new Television(30, false, 460, Electrodomestico.Colores.rojo, 46, Electrodomestico.Letras.D);
        electrodomésticos[3] = new Television(36, true, 525, Electrodomestico.Colores.azul, 50, Electrodomestico.Letras.D);
        electrodomésticos[4] = new Television(42, true, 460, Electrodomestico.Colores.gris, 60, Electrodomestico.Letras.D);
        electrodomésticos[5] = new Lavadora(40, 350, Electrodomestico.Colores.blanco, 400, Electrodomestico.Letras.D);
        electrodomésticos[6] = new Lavadora(30, 400, Electrodomestico.Colores.gris, 380, Electrodomestico.Letras.A);
        electrodomésticos[7] = new Lavadora(60, 250, Electrodomestico.Colores.negro, 550, Electrodomestico.Letras.B);
        electrodomésticos[8] = new Lavadora(20, 425, Electrodomestico.Colores.azul, 250, Electrodomestico.Letras.F);
        electrodomésticos[9] = new Lavadora(50, 500, Electrodomestico.Colores.rojo, 330, Electrodomestico.Letras.C);
        float precioTelevisiones = 0;
        float precioLavadoras = 0;

        foreach(Electrodomestico ele in electrodomésticos)
        {
            ele.precioFinal();
            if(ele.GetType() == typeof(Television))
                precioTelevisiones += ele.Preciobase;
            else if (ele.GetType() == typeof(Lavadora))
                precioLavadoras += ele.Preciobase;
        }
        Console.WriteLine("Precio Lavadoras: {0}", precioLavadoras);
        Console.WriteLine("Precio Televisores: {0}", precioTelevisiones);
        Console.WriteLine("Precio Electrodomésticos: {0}", precioLavadoras + precioTelevisiones);

    }
}