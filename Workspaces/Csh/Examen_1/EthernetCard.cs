class EthernetCard
{
    //Atributos
    private List<Trama> staticBuffer;
    private List<Trama> dynamicBuffer1;
    private List<Trama> dynamicBuffer2;
    private List<Trama> dynamicBuffer3;

    //Constructor
    public EthernetCard()
    {
        StaticBuffer = new List<Trama>();
        DynamicBuffer1 = new List<Trama>();
        DynamicBuffer2 = new List<Trama>();
        DynamicBuffer3 = new List<Trama>();
    }

    //Métodos
    //Añade las tramas que le llegan a la tarjeta Ethernet al Buffer estático
    public void addTrama(Trama trama)
    {
        //Si el buffer tiene menos de 4 elementos le añadimos la trama
        if(StaticBuffer.Count < 4 )
            StaticBuffer.Add(trama);
        //Si el buffer estático está lleno:
        else
        {
            //Se hace un hueco
            almacenarTrama();
            //Se añade la trama
            StaticBuffer.Add(trama);
        }
    }
    public void almacenarTrama()
    {
        //Se saca la priodidad más grande
        int maxPrio = StaticBuffer.Max(t => t.Prioridad);

        //Se mueve la trama con esa prioridad con el metodo moverTrama
        foreach(Trama tr in StaticBuffer)
        {
            if(tr.Prioridad == maxPrio)
            {
                moverTrama(tr);
                break;
            }
        }
    }

    public void moverTrama(Trama trama)
    {
        //Comprobamos el puerto que tiene la trama que se va a mover
        switch(trama.N_puerto)
        {
            case 1:
                    DynamicBuffer1.Add(trama);
                    StaticBuffer.Remove(trama);
                    break;

            case 2: 
                    DynamicBuffer2.Add(trama); 
                    StaticBuffer.Remove(trama);
                    break;

            case 3: 
                    DynamicBuffer3.Add(trama); 
                    StaticBuffer.Remove(trama);
                    break;

            default: Console.WriteLine("Error"); break;
        }
    }

    //Método para mostrar las tramas que tienen los Buffers almacenadas
    public void mostrarTramas()
    {
        //Mostramos el buffer estático
        Console.WriteLine("Static Buffer:");
        Console.WriteLine("--------------------");
        foreach(Trama tr1 in StaticBuffer)
        {
            Console.WriteLine(tr1);
        }
        Console.WriteLine("--------------------");


        //Mostramos los buffers dinámicos
        Console.WriteLine("Dynamic Buffer 1:");
        Console.WriteLine("--------------------");
        foreach(Trama tr2 in DynamicBuffer1)
        {
            Console.WriteLine(tr2);
        }
        Console.WriteLine("--------------------");

        Console.WriteLine("Dynamic Buffer 2:");
        Console.WriteLine("--------------------");
        foreach(Trama tr3 in DynamicBuffer2)
        {
            Console.WriteLine(tr3);
        }
        Console.WriteLine("--------------------");

        Console.WriteLine("Dynamic Buffer 3:");
        Console.WriteLine("--------------------");
        foreach(Trama tr4 in DynamicBuffer3)
        {
            Console.WriteLine(tr4);
        }
        Console.WriteLine("--------------------");
    }

    //Propiedades
    public List<Trama> StaticBuffer
    {
        get
        {
            return staticBuffer;
        }
        set
        {
            staticBuffer = value;
        }
    } 
    public List<Trama> DynamicBuffer1
    {
        get
        {
            return dynamicBuffer1;
        }
        set
        {
            dynamicBuffer1 = value;
        }
    }
    public List<Trama> DynamicBuffer2
    {
        get
        {
            return dynamicBuffer2;
        }
        set
        {
            dynamicBuffer2 = value;
        }
    }
    public List<Trama> DynamicBuffer3
    {
        get
        {
            return dynamicBuffer3;
        }
        set
        {
            dynamicBuffer3 = value;
        }
    }
}