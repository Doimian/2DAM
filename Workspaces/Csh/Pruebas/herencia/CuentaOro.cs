using System;

public class CuentaOro : Cuenta
{
    public CuentaOro(float saldo) : base(saldo)
    {
    }

    public override void CalcularInteres()
    {
        Console.WriteLine("El interés de su cuenta es de {0}", SaldoCuenta * 10 / 100);
    }
}