using System;

namespace MyApp
{
    internal class Cuenta
    {
        //Atributo de la clase
        private decimal saldo;

        //Constructor
        public Cuenta(decimal cantidad)
        {
            //Se utiliza la propiedad siempre
            Saldo = cantidad;
        }

        //Propiedad
        public decimal Saldo
        {
            get
            {
                return saldo;
            }
            set
            {
                if(value > 0)
                {
                    saldo = value;
                }
            }
        }

        //Método
        public void Ingreso(decimal cantidad)
        {
            //Se suma la cantidad al saldo de la cuenta 
            Saldo += cantidad;
        }
    }
}