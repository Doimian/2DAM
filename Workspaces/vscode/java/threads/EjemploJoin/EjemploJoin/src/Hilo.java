public class Hilo extends Thread{
    //Atributo de la clase
    private Contador contador;

    public Hilo(Contador contador)
    {
        this.contador = contador;
    }

    public void run()
    {
        //Inicio
        synchronized(contador)
        {
            for(int i = 0; i<10000; i++)
            {
                contador.decrementar(1);
            }
        }
    }
}
