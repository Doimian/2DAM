using System;

namespace MyApp
{

        public enum Generos {H,M};
    internal class Persona
    {
        //Atributos
        private string nombre;
        private int edad;
        private string dni;
        private Generos sexo;
        private double peso;
        private double altura;

        //Constante por defecto
        public const Generos SEXO = Generos.M;

        //Constructores
        public Persona()
        {
            generaDNI();
            Nombre = "";
            Edad = 0;
            sexo = SEXO;
            Peso = 0;
            Altura = 0;
        }

        public Persona(string nombre, int edad, Generos sexo)
        {
            generaDNI();
            Nombre = nombre;
            Edad = edad;
            Sexo = sexo;
            Peso = 0;
            Altura = 0;
        }

        public Persona(string nombre, int edad, Generos sexo, double peso, double altura)
        {
            generaDNI();
            Nombre = nombre;
            Edad = edad;
            Sexo = sexo;
            Peso = peso;
            Altura = altura;
        }

        //Métodos
        public int calcularIMC()
        {
            double formula = Peso / (Altura*Altura);
            if(formula < 20)
                return -1;
            else if(formula <=25)
                return 0;
            else
                return 1;
        }

        public bool esMayorDeEdad()
        {
            if(Edad >= 18)
                return true;
            return false;
        }

        public void comprobarSexo(char sexo)
        {
            //No entiendo lo que pide            
        }
        public override string ToString() 
        { 
            string str = "";
            //if(Sexo.CompareTo(Generos.H) == 1)
            //    str = "DNI:" + Dni + ", Nombre: " + Nombre + ", Edad: " + Edad + "Sexo: Hombre" + ", Peso: " + Peso + ", Altura: " + Altura;
            //else
                str = "DNI:" + Dni + ", Nombre: " + Nombre + ", Edad: " + Edad + "Sexo: Mujer" + ", Peso: " + Peso + ", Altura: " + Altura;
            return str;
        }
        public override bool Equals(object obj)
        {
            
            if (obj == null || GetType() != obj.GetType())
            {
                return false;
            }
            
            return (GetHashCode == obj.GetHashCode);
        }
        
        // override object.GetHashCode
        public override int GetHashCode()
        {
            return Dni.GetHashCode() ^ Nombre.GetHashCode();
        }

        private void generaDNI()
        {
            Random seed = new Random();
            dni = seed.Next(10000000,99999999).ToString();
            switch(Int32.Parse(dni)  % 23)
            {
                case 0: dni += " T"; break;
                case 1: dni += " R"; break;
                case 2: dni += " W"; break;
                case 3: dni += " A"; break;
                case 4: dni += " G"; break;
                case 5: dni += " M"; break;
                case 6: dni += " Y"; break;
                case 7: dni += " F"; break;
                case 8: dni += " P"; break;
                case 9: dni += " D"; break;
                case 10: dni += " X"; break;
                case 11: dni += " B"; break;
                case 12: dni += " N"; break;
                case 13: dni += " J"; break;
                case 14: dni += " Z"; break;
                case 15: dni += " S"; break;
                case 16: dni += " Q"; break;
                case 17: dni += " V"; break;
                case 18: dni += " H"; break;
                case 19: dni += " L"; break;
                case 20: dni += " C"; break;
                case 21: dni += " K"; break;
                case 22: dni += " E"; break;
            }
        }

        //Propiedades
        public string Nombre
        {
            get
            {
                return nombre;
            }
            set
            {
                nombre = value;
            }
        }

        public int Edad
        {
            get
            {
                return edad;
            }
            set
            {
                edad = value;
            }
        } 
        
        public Generos Sexo
        {
            get
            {
                return Sexo;
            }
            set
            {
                sexo = value;
            }
        }

        public string Dni
        {
            get
            {
                return dni;
            }
        }

        public double Altura
        {
            get
            {
                return altura;
            }
            set
            {
                altura = value;
            }
        }

        public double Peso
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

    public class Sexo
    {
        private enum sexo {H,M}

    }
}