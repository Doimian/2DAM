public class App 
{
    public static void main(String[] args) throws Exception 
    {
        //Atributos
        Hilo hilodec;
        HiloInc hiloinc;
        Contador contador = new Contador(100);

        //Inicializamos los hilos
        hilodec = new Hilo(contador);
        hiloinc = new HiloInc(contador);

        //Ejecutamos los hilos
        hiloinc.start();
        hilodec.start();

        //Espero que terminen los hilos
        hiloinc.join();
        hilodec.join();

        System.out.println("El valor de la variable es " + contador.getNum());
    }
}
