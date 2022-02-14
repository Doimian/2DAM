package com.example.ej3_componentes;

import android.widget.EditText;
import android.widget.ImageView;

public class Dispositivo {

    //Atributos
    private boolean marcado;
    private String texto;
    private int imagen;


    //Constructor
    public Dispositivo(String texto, int imagen)
    {
        this.texto = texto;
        this.imagen = imagen;
        this.marcado = false;
    }

    //getters
    public boolean getMarcado()
    {
        return marcado;
    }
    public String getTexto() {
        return texto;
    }
    public int getImagen()
    {
        return imagen;
    }
    public void setSelected()
    {
        this.marcado = true;
    }
}
