package com.example.fechapersonalizada;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FechaPersonalizada extends androidx.appcompat.widget.AppCompatEditText {
    //Atributo de la clase
    private Paint pnegro;

    public FechaPersonalizada(@NonNull Context context) {
        super(context);
        setpincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
        //Solo dejamos que el campo admita 10 caracteres
        InputFilter[] filters = new InputFilter[1];
        //Solo dejamos que el campo admita 10 caracteres
        filters[0] = new InputFilter.LengthFilter(10);
        this.setFilters(filters);;
        filters[0] = new InputFilter.LengthFilter(10);
        this.setFilters(filters);
    }

    public FechaPersonalizada(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setpincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
        //Solo dejamos que el campo admita 10 caracteres
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(10);
        this.setFilters(filters);
    }

    public FechaPersonalizada(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setpincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
        //Solo dejamos que el campo admita 10 caracteres
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(10);
        this.setFilters(filters);
    }

    @Override
    public void onDraw (Canvas canvas)
    {
        //Invocamos al método de la superclase
        super.onDraw(canvas);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), pnegro);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        Editable texto;
        if (keyCode != KeyEvent.KEYCODE_DEL) {
            if (this.getText().length() == 2) {
                this.setText(this.getText() + "/");
                this.setSelection(this.getText().length());
            } else if (this.getText().length() == 5) {
                this.setText(this.getText() + "/");
                this.setSelection(this.getText().length());
            }
        }
        else
        {
            if(this.getText().length() == 2)
            {
                texto = this.getText();
                texto.delete(1, texto.length());
                this.setSelection(this.getText().length());
            }
            else if (this.getText().length() == 5)
            {
                texto = this.getText();
                texto.delete(4, texto.length());
                this.setSelection(this.getText().length());
            }
        }
        return true;
    }

    //Inicializo el pincel
    private void setpincel()
    {
        pnegro = new Paint();
        pnegro.setColor(Color.BLACK);
        pnegro.setStrokeWidth(5);
        pnegro.setStyle(Paint.Style.STROKE);
    }
}
