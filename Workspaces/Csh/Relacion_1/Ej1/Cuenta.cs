using System;
public class Cuenta
{
    //Atributos
    private string titular;
    private double cantidad;


    //Constructores
    public Cuenta(String titular)
    {
        Titular = titular;
        cantidad = 0;
    }
    public Cuenta(String titular, double cantidad)
    {
        Titular = titular;
        Cantidad = cantidad;
    }

    //Metodos
    public void ingresar(double cantidad)
    {
        if(cantidad>0)
        {
            Cantidad += cantidad;
        }
    }
    
    public void retirar(double cantidad)
    {
        if(cantidad >= Cantidad)
        {
            Cantidad = 0;
        }
        else
        {
            Cantidad -= cantidad;
        }
    }

    //Propiedades
    public string Titular
    {
        get 
        {
            return titular;
        }
        set
        {
            titular = value;
        }
    }
    public double Cantidad
    {
        get
        {
            return cantidad;
        }
        set
        {
            cantidad = value;
        }

    }

}