using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class NetSim
    {
        static void Main(string[] args)
        {
            const int NUM_TRAMAS_TCP = 130;
            const int NUM_TRAMAS_UDP= 150;
            Random rnd = new Random();
            Random rnd2 = new Random();

            //Creamos la tarjeta etherner
            EthernetCard tarjeta = new EthernetCard();

            //Creamos un puñao de tramas
            for(int i = 0; i < NUM_TRAMAS_UDP; i++)
            {
                char[] contenido = new char[10];
                for(int j = 0; j < 10; j++)
                {
                    contenido[j] = (char) rnd.Next(33, 126);
                }
                tarjeta.addTrama(new UDP((int)rnd.Next(1,4),(int)rnd.Next(1,11), new string(contenido)));
            }

            for(int i = 0; i < NUM_TRAMAS_TCP; i++)
            {
                char[] contenido = new char[10];
                for(int j = 0; j < 10; j++)
                {
                    contenido[j] = (char) rnd2.Next(33, 126);
                }
                tarjeta.addTrama(new TCP((int)rnd2.Next(1,4),(int)rnd2.Next(1,11), new string(contenido)));
            }
            
            tarjeta.mostrarTramas();
        }
    }
}
