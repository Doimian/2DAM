using System;

public abstract class Electrodomestico
{
    //Atributos
    private float preciobase;
    public enum Letras {A = 'A',B = 'B',C = 'C',D = 'D',E = 'E',F = 'F'};
    public enum Colores {blanco,negro,rojo,azul,gris};
    private Colores color;
    private Letras consumoEnergetico;
    private float peso;

    //Constantes
    public const Colores COLOR_DEF = Colores.blanco;
    public const Letras CONSUMO_DEF = Letras.F;
    public const float PRECIO_DEF = 100;
    public const float PESO_DEF = 5;

    //Constructores
    public Electrodomestico()
    {
        Preciobase = PRECIO_DEF;
        Color = COLOR_DEF;
        ConsumoEnergetico = CONSUMO_DEF;
        Peso = PESO_DEF;
    }
    public Electrodomestico(float precio, float peso)
    {
        Preciobase = precio;
        Color = COLOR_DEF;
        ConsumoEnergetico = CONSUMO_DEF;
        Peso = peso;
    }
    public Electrodomestico(float precio, Colores color, float peso, Letras consumo)
    {
        Preciobase = precio;
        Color = color;
        ConsumoEnergetico = consumo;
        Peso = peso;
    }

    //Métodos
    public void comprobarConsumoEnergetico(char letra)
    {
        switch(consumoEnergetico)
        {
            case Letras.A:
            case Letras.B:
            case Letras.C:
            case Letras.D:
            case Letras.E:
            case Letras.F: if(letra == (char)consumoEnergetico) {}; break;
            default: ConsumoEnergetico = CONSUMO_DEF; return;
        }
    }

    public void comprobarColor(string color)
    {
        switch(Color)
        {
            case Colores.blanco:
            case Colores.azul: 
            case Colores.gris: 
            case Colores.negro:
            case Colores.rojo: if(color.ToLower().Equals(Color.ToString())) {}; break;
            default: Color = COLOR_DEF; return;
        }
    }
    public virtual void precioFinal()
    {
        switch(ConsumoEnergetico)
        {
            case Letras.A : Preciobase += 100; break;
            case Letras.B : Preciobase +=  80; break;
            case Letras.C : Preciobase +=  60; break;
            case Letras.D : Preciobase +=  50; break;
            case Letras.E : Preciobase +=  30; break;
            case Letras.F : Preciobase +=  10; break;
        }
        if(Peso >= 0 && Peso < 20)
            Preciobase += 10;
        else if(Peso >= 20 && Peso < 50)
            Preciobase += 50;
        else if(Peso >= 50 && Peso < 80)
            Preciobase += 80;
        else if(Peso >= 80)
            Preciobase += 100;
    }

    //Propiedades
    public float Preciobase
    {
        get
        {
            return preciobase;
        }
        set
        {
            preciobase = value;
        }
    }

    public Colores Color
    {
        get
        {
            return color;
        }
        set
        {
            color = value;
        }
    }
    public Letras ConsumoEnergetico
    {
        get
        {
            return consumoEnergetico;
        }
        set
        {
            consumoEnergetico = value;
        }
    }
    public float Peso
    {
        get
        {
            return peso;
        }
        set
        {
            peso = value;
        }
    }

}