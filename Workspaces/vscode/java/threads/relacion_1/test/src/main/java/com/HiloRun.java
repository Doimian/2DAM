package com;

public class HiloRun implements Runnable{
    //Atributo
    int numero;

    public HiloRun(int numero)
    {
        this.numero = numero;
    }

    @Override
    public void run() 
    {
        for(int i=0; i < numero; i++)
        {
            System.out.println("Hilo que implementa Runnable");
        }
    }
}
