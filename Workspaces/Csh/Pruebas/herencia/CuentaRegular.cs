using System;

public class CuentaRegular : Cuenta
{
    //Atributos
    private string propietario;

    //Constructores
    public CuentaRegular(float saldo, string propietario) : base(saldo)
    {
        Propietario = propietario;
    }

    //Métodos
    public override void CalcularInteres()
    {
        //Variable
        float interes = 0;

        //Inicio
        if(SaldoCuenta > 100)
        {
            interes = SaldoCuenta * 1/100;
        }
        Console.WriteLine("El interés de su cuenta es de {0}", interes);
    }

    //Propiedades
    public string Propietario{get; set;}
}