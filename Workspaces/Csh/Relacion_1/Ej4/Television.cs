using System;

public class Television : Electrodomestico
{
    //Atributos
    private int pulgadas;
    private bool sintonizadorTDT;

    //Constantes
    public const int PULGADAS_DEF = 20;
    public const bool TDT_DEF = false;


    //Constructores
    public Television()
    {
        Pulgadas = PULGADAS_DEF;
        SintonizadorTDT = TDT_DEF;
    }
    public Television(float precio, float peso) : base(precio, peso)
    {
        Pulgadas = PULGADAS_DEF;
        SintonizadorTDT = TDT_DEF;
    }
    public Television(int pulgadas, bool tdt,float precio, Colores color, float peso, Letras consumo) : base(precio, color, peso, consumo)
    {
        Pulgadas = pulgadas;
        SintonizadorTDT = tdt;
    }

    //Métodos
    public override void precioFinal()
    {
        base.precioFinal();
        if(Pulgadas > 40)
        {
            Preciobase += Preciobase * (float)0.3;
        }
        if(SintonizadorTDT)
        {
            Preciobase += 50;
        }
    }

    //Propiedades
    public int Pulgadas
    {
        get
        {
            return pulgadas;
        }
        set
        {
            pulgadas = value;
        }
    }
    public bool SintonizadorTDT
    {
        get
        {
            return sintonizadorTDT;
        }
        set
        {
            sintonizadorTDT = value;
        }
    }

}