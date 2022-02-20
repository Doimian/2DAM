package com.example.ej4_cesta;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class Elemento extends androidx.appcompat.widget.AppCompatTextView
{
    //Atributos
    Boolean tachado;

    public Elemento(@NonNull Context context)
    {
        super(context);
        tachado = false;
    }
    public Elemento(@NonNull Context context, String contenido)
    {
        super(context);
        super.setText(contenido);
        tachado = false;
    }

    public Elemento(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.tachado = false;
    }

    public Elemento(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.tachado = false;
    }

    public void tacharElemento()
    {
        tachado = true;
    }

    public void destacharElemento()
    {
        tachado = false;
    }

    public boolean isTachado()
    {
        return tachado;
    }

}
