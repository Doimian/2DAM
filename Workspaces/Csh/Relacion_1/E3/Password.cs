using System;

public class Password
{
    //Atributos
    private int longitud;
    private string contraseña = "";

    //Constructores

    public Password()
    {
        Longitud = 8;
        GenerarPassword();
    }
    public Password(int longitud)
    {
       Longitud = longitud; 
       GenerarPassword();
    }

    //Métodos
    private void GenerarPassword()
    {
        Random seed = new Random();
        char letra;
        string temp = "";
        for(int i = 0; i < longitud; i++ )
        {
            letra = Convert.ToChar(seed.Next(33, 126));
            temp += Convert.ToString(letra);
        } 
        contraseña = temp;
    }

    public bool esFuerte()
    {
        if(Contraseña.Count(char.IsNumber) > 4 && Contraseña.Count(char.IsUpper) > 2 && Contraseña.Count(char.IsLower) > 1)
            return true;
        else
            return false;
    }

    //Propiedades
    public int Longitud 
    {
        get
        {
            return longitud;
        }
        set
        {
            longitud = value;
        }
    }
    public string Contraseña 
    {
        get
        {
            return contraseña;
        }
    }
}