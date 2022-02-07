public class App {
    public static void main(String[] args) throws Exception {
        HiloSus hilo;

        //Inicio
        hilo = new HiloSus(100000);
        hilo.start(); 
        Thread.sleep(1000);
        hilo.suspender();
        Thread.sleep(2000);
        hilo.reanudar();
    }
}
