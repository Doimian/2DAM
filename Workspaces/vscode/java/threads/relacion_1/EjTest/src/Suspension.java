public class Suspension 
{
    //Atributos
    private boolean suspension;

    //Métodos
    public synchronized void set(boolean suspension)
    {
        this.suspension = suspension;
        notifyAll();
    }

    public synchronized void waitForResume() throws InterruptedException
    {
        while(this.suspension)
        {
            wait();
        }

    }
}
