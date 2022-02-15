public class HiloCons extends Thread{
    //Atributo
    private Cola cola;

    public HiloCons(Cola cola)
    {
        this.cola = cola;
    }

    @Override
    public void run()
    {
        int resultado;
        for(int i = 0; i < 10; i++)
        {
            resultado = cola.consumir();
        }
    }
    
}
