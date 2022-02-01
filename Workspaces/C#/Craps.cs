using System;

public class Craps
{
    //Declaramos una variable para números aleatorios
    private Random aleatorio = new Random();

    //Declaramos los enum, Tres estados en la partida: GANA PIERDE CONTINUA
    private enum Estado {GANA, PIERDE, CONTINUA};
    private enum Puntos {DOS = 2, TRES = 3, SIETE = 7, ONCE = 11, DOCE = 12};

    public void Jugar()
    {
        Estado estado = Estado.CONTINUA;
        int puntos, dados;

        //Inicio
        puntos = TirarDados();
        Console.WriteLine("El jugador saca {0} puntos", puntos);
        switch((Puntos) puntos)
        {
            case Puntos.SIETE:
            case Puntos.ONCE:
                                estado = Estado.GANA;
                                Console.WriteLine("Gana el jugador");
                                break;
            case Puntos.DOS:
            case Puntos.TRES:
            case Puntos.DOCE:
                                estado = Estado.PIERDE;
                                Console.WriteLine("Gana la banca");
                                break;
            default:
                                estado = Estado.CONTINUA;
                                Console.WriteLine("Continua el juego");
                                break;
        }
        while(estado == Estado.CONTINUA)
        {
            dados = TirarDados();
            Console.WriteLine("El jugador saca {0} puntos", dados);
            if(dados == puntos)
            {
                Console.WriteLine("Gana el jugador");
                estado = Estado.GANA;
            }
            else if(dados == 7)
            {
                Console.WriteLine("Gana la banca");
                estado = Estado.PIERDE;
            }
        }
    }

    private int TirarDados()
    {
        //Variables locales
        int dado1, dado2;

        dado1 = aleatorio.Next(1,6);
        dado2 = aleatorio.Next(1,6);

        return dado1 + dado2;
    }
}