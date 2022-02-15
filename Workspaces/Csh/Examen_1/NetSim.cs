using System;

namespace MyApp 
{
    internal class NetSim
    {
        static void Main(string[] args)
        {
            //Se definen el número de tramas que se crearán
            const int NUM_TRAMAS= 55;

            //Creamos la semilla random
            Random rnd = new Random();

            //Creamos la tarjeta ethernet
            EthernetCard tarjeta = new EthernetCard();

            //Creamos las tramas
            for(int i = 0; i < NUM_TRAMAS; i++)
            {
                char[] contenido = new char[10];
                for(int j = 0; j < 10; j++)
                {
                    contenido[j] = (char) rnd.Next(33, 126);
                }

                if(rnd.Next(1,3) == 1)
                {
                    tarjeta.addTrama(new UDP((int)rnd.Next(1,4),(int)rnd.Next(1,11), new string(contenido)));
                }else
                {
                    tarjeta.addTrama(new TCP((int)rnd.Next(1,4),(int)rnd.Next(1,11), new string(contenido)));
                }
            }

            //Mostramos las tramas que se han creado
            tarjeta.mostrarTramas();
        }
    }
}
