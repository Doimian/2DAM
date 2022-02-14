class Trama //Clase principal que define las tramas
{
   //Atributos 
   private int n_puerto;
   private int prioridad;
   private string contenido;
   private TimeOnly momento;


   //Constructores
   public Trama(int n_puerto, int prioridad, string trama)
   {
        N_puerto = n_puerto;
        Prioridad = prioridad;
        Contenido = trama;
        Momento = TimeOnly.FromTimeSpan(TimeSpan.Zero);
   }


   //Propiedades
   public int N_puerto
   {
       get
       {
           return n_puerto;
       }
       set
       {
           n_puerto = value;
       }
   }
   public int Prioridad
   {
       get
       {
           return prioridad;
       }
       set
       {
           prioridad = value;
       }
   }
    public string Contenido
    {
        get
        {
            return contenido;
        }
        set
        {
            contenido = value;
        }
    }
    public TimeOnly Momento
    {
        get
        {
            return momento;
        }
        set
        {
            momento = value;
        }
    }
}