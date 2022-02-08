using System;

namespace MyApp // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        static void Main(string[] args)
        {

            //Inicio
            //Pedimos valores por teclado
            Console.WriteLine("Introduce el Nombre de la persona:");
            String nombre = Console.ReadLine().Trim();
            Console.WriteLine("Introduce la Edad de la persona:");
            int edad = Int32.Parse(Console.ReadLine().Trim());
            Console.WriteLine("Introduce el Peso de la persona:");
            double peso = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Introduce la Altura de la persona:");
            double altura = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Introduce el Sexo de la persona (H/Hombre - M/Mujer):");
            string genero = Console.ReadLine().ToLower().Trim();
            Generos sexo;
            if(genero.Equals("h") || genero.Equals("hombre"))
                sexo = Generos.H;
            else if(genero.Equals("m") || genero.Equals("mujer"))
                sexo = Generos.M;
            else
            {
                Console.WriteLine("Valor Erróneo en el Sexo");
                return;
            }

            //Creamos objetos Persona
            Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
            Persona persona2 = new Persona(nombre, edad, sexo);
            Persona persona3 = new Persona();
            List<Persona> personas = new List<Persona>();
            personas.Add(persona1);
            personas.Add(persona2);
            personas.Add(persona3);
            persona3.Nombre = nombre;
            persona3.Edad = edad;
            persona3.Sexo = sexo;
            persona3.Peso = peso;
            persona3.Altura = altura;


            //Comprobamos el peso de las personas
            foreach (Persona persona in personas)
            {
                int imc = persona.calcularIMC();
                switch(imc)
                {
                    case -1: Console.WriteLine("Error al realizar la calculación"); break;
                    case 0: Console.WriteLine( persona.Nombre +" está por debajo de su peso ideal"); break;
                    case 1: Console.WriteLine( persona.Nombre +" está por encima de su peso ideal"); break;
                }
            }

            //Vemos si las personas son mayores o menores de edad
            foreach(Persona persona in personas)
            {
                bool mayor = persona.esMayorDeEdad();
                if(mayor)
                {
                    Console.WriteLine(persona.Nombre + " es mayor de edad");
                    Console.WriteLine(persona);
                }    
                else
                    Console.WriteLine(persona.Nombre + " es menor de edad");

            }

            //Mostramos la información de cada persona
            foreach(Persona persona in personas)
            {
                Console.WriteLine(persona);
            }
        }
    }
}