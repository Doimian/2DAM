using System;

public class Program
{
    static void Main(String[] args)
    {
        CuentaOro cuentaoro = new CuentaOro(3000);
        cuentaoro.AbonarCuenta(1000);
        cuentaoro.CalcularInteres();

        CuentaRegular cuentaRegular = new CuentaRegular(1000, "Ramón Corrales");
        cuentaRegular.RetirarCuenta(300);
        cuentaRegular.CalcularInteres();

    }
}