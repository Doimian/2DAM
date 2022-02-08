using System;

namespace MyApp 
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Pedimos datos
            Console.WriteLine("Cuantas contraseñas quieres almacenar?");
            int num = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("Cual es la longitud de las contraseñas?");
            int lon = Convert.ToInt16(Console.ReadLine());

            Password[] contraseñas = new Password[num];
            bool[] fuertes = new bool[num];

            //Generamos las contraseñas
            for(int i = 0; i < num; i++)
            {
                contraseñas[i] = new Password(lon);
                fuertes[i] = contraseñas[i].esFuerte();
            }

            //Mostramos los resultados
            for(int i = 0; i < num; i++)
            {
                Console.WriteLine(contraseñas[i].Contraseña + "\t" + fuertes[i]);
            }
        }
    }
}