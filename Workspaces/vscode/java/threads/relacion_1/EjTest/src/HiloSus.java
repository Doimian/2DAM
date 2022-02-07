public class HiloSus extends Thread{
    //Atributo
    private int numero;
    private Suspension suspension;

    //Metodos
    public HiloSus(int numero)
    {
        this.numero = numero;
        this.suspension = new Suspension();
    }

    public void suspender()
    {
        suspension.set(true);
        System.out.println("El Hilo se ha suspendido");
    }

    public void reanudar()
    {
        suspension.set(false);
        System.out.println("El Hilo se ha reanudado");
    }

    @Override
    public void run()
    {
        for(int i = 0; i<numero ; i++)
        {
            try {
                suspension.waitForResume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " ");
            if(i%10 == 0)
            {
            System.out.println(" ");
            }
        }
    }
    
}
