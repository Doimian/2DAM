using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Declaración de variables
            int numero = 20;
            int numero2 = 30;
            
            Console.Write("Mis numeros son {0} y {1}\n", numero, numero2);

            Console.WriteLine("Escribo otra vez el número {0}", numero2);

            Console.WriteLine("Hello World!");
        }
    }
}