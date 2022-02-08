using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //
            Cuenta cuenta = new Cuenta("Damian", 50);

            Console.WriteLine("La cuenta de {0} tiene {1}€", cuenta.Titular, cuenta.Cantidad);
            cuenta.ingresar(250);
            Console.WriteLine("La cuenta de {0} tiene {1}€", cuenta.Titular, cuenta.Cantidad);
            cuenta.retirar(500);
            Console.WriteLine("La cuenta de {0} tiene {1}€", cuenta.Titular, cuenta.Cantidad);
        }
    }
}