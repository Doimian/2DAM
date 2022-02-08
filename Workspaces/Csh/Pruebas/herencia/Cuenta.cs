using System;

public abstract class Cuenta
{
    //Atributos
    private float saldoCuenta;

    //Constructor
    public Cuenta(float saldo)
    {
        SaldoCuenta = saldo;
    }

    //Métodos
    public void AbonarCuenta(float abono)
    {
        SaldoCuenta += abono;
    }

    public void RetirarCuenta(float retirar)
    {
        SaldoCuenta -= retirar;
    }

    public abstract void CalcularInteres();

    //Propiedades
    public float SaldoCuenta {get; set; }

}