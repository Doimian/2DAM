class TCP : Trama
{
    //Constante
    const int MTU = 1500;

    //Constructor
    public TCP(int n_puerto, int prioridad, string trama) : base(n_puerto, prioridad, trama)
    {

    }

    public override string ToString()
    {
        return "(TCP) Puerto: "+N_puerto+", Prioridad: "+Prioridad+", Contenido: "+Contenido;
    }
}