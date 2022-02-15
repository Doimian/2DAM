public class App {
    public static void main(String[] args) throws Exception {
        HiloProd hiloprod;
        HiloCons hilocons;
        Cola cola = new Cola();

        hilocons = new HiloCons(cola);
        hiloprod = new HiloProd(cola);
        hilocons.start();
        hiloprod.start();

        //Me quedo esperando a que terminen
        hilocons.join();
        hiloprod.join();

    }
}
