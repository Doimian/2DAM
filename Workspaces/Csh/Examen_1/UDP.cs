class UDP : Trama
{
    const int MTU = 500;

    public UDP(int n_puerto, int prioridad, string trama) : base(n_puerto, prioridad, trama)
    {

    }

    public override string ToString()
    {
        Console.WriteLine("(UDP) Puerto: "+N_puerto+", Prioridad: "+Prioridad+", Contenido: {0}",Contenido);
        return "";
    }
}