using System;

public class Lavadora : Electrodomestico
{
    //Atributos
    private float carga;

    //Constantes
    public const float CARGA_DEF = 5;

    //Constructores
    public Lavadora()
    {
        Carga = CARGA_DEF;
    }
    public Lavadora(float precio, float peso) : base(precio, peso)
    {
        Carga = CARGA_DEF;
    }
    public Lavadora(float carga, float precio, Colores color, float peso, Letras consumo) : base(precio, color, peso, consumo)
    {
        Carga = carga;
    }

    //Métodos
    public override void precioFinal()
    {
        base.precioFinal();
        if(Carga > 30)
        {
            base.Preciobase += Preciobase * (float)0.3;
        }
    }

    //Propiedades
    public float Carga
    {
        get
        {
            return carga;
        }
        set
        {
            carga = value;
        }
    }
}