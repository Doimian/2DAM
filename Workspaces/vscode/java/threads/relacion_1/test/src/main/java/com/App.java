package com;

public class App {
    
    public static void main(String[] args)
    {
        ThreadGroup grupo;
        Hilo hilo, hilo2;
        HiloRun hilo3;

        //Inicio
        grupo = new ThreadGroup("Grupo 1");
        hilo = new Hilo(100);
        hilo2 = new Hilo(200);
        Thread thread = new Thread(grupo, hilo, "Hilo1");
        Thread thread2 = new Thread(grupo, hilo2, "Hilo2");
        thread.start();
        thread2.start();

        hilo3 = new HiloRun(200);
        hilo3.run();
    }
}