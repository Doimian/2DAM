public class Contador {
    private int numero;

    public Contador(int numero)
    {
        this.numero = numero;
    }

    public void incrementar(int num)
    {
        this.numero += num;
    }

    public void decrementar(int num)
    {
        this.numero -= num;
    }

    public int getNum()
    {
        return numero;
    }

    
}
