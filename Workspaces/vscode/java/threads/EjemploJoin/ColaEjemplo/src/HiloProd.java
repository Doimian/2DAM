public class HiloProd extends Thread{
    //Atributo
    private Cola cola;

    public HiloProd(Cola cola)
    {
        this.cola = cola;
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 10; i++)
        {
            cola.producir(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
