using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Craps juego = new Craps();
            juego.Jugar();

        }
    }
}