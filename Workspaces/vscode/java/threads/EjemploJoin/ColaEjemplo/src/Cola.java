public class Cola {
    //Atributos
    boolean disponible;
    int numero;

    public Cola()
    {
        disponible = false;
    }

    public synchronized void producir(int numero)
    {

        while(disponible)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        disponible = true;
        this.numero = numero;
        System.out.println("Se ha producido el elemento " +  this.numero);
        notify();
    }

    public synchronized int consumir()
    {
        while(!disponible)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        disponible = false;
        System.out.println("Se ha consumido el elemento " +  this.numero);
        notify();
        return this.numero;
   }
}
