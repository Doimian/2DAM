package com;

public class Hilo extends Thread{
    //Atributo
    private int veces;

    //Constructor
    public Hilo(int numero)
    {
        this.veces = numero;
    }

    //Métodos
    @Override
    public void run()
    {
        for (int i = 0; i<veces; i++)
        {
            System.out.println(this.toString());
        }
    }
}
