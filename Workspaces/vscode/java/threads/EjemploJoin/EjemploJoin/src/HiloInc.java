public class HiloInc extends Thread{
    //Atributo
    private Contador contador;

    public HiloInc(Contador cont)
    {
        this.contador = cont;
    }

    public void run()
    {
        synchronized(contador)
        {
            for(int i = 0; i < 10000; i++)
            {
                contador.incrementar(1);
            }
        }
    }
}
