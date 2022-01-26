using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Variables
            Cuenta cuenta;
            decimal saldoinicial, ingreso;

            Console.WriteLine("Introduzca el saldo inicial de su cuenta");
            saldoinicial = Convert.ToDecimal(Console.ReadLine());
            cuenta = new Cuenta(saldoinicial);
            Console.WriteLine("Su cuenta se ha creado con el saldo {0:C}",cuenta.Saldo);
            Console.WriteLine("Introduce la cantidad que desea ingresar");
            ingreso = Convert.ToDecimal(Console.ReadLine());
            cuenta.Ingreso(ingreso);
        }
    }
}