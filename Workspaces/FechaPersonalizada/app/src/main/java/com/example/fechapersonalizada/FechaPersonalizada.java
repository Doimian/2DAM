package com.example.fechapersonalizada;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FechaPersonalizada extends androidx.appcompat.widget.AppCompatEditText {

    //Atributos de la clase
    private Paint pnegro;

    public FechaPersonalizada(@NonNull Context context) {
        super(context);
        setpincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    public FechaPersonalizada(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setpincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    public FechaPersonalizada(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setpincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        //Invocamos el método de la superclase
        super.onDraw(canvas);
        canvas.drawRect(0,0, this.getWidth(), this.getHeight(), pnegro);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        Editable texto;
        if(keyCode != KeyEvent.KEYCODE_DEL) {

            if (this.getText().length() == 2) {
                this.setText(this.getText() + "/");
                this.setSelection(this.getText().length());
            } else if (this.getText().length() == 5) {
                this.setText(this.getText() + "/");
                this.setSelection(this.getText().length());
            } else if (this.getText().length() > 10) {
                texto = this.getText();
                texto.delete(10, texto.length());
                this.setText(texto);
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
            else if(this.getText().length() == 5)
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
        pnegro.setColor(Color.RED);
        pnegro.setStrokeWidth(5);
        pnegro.setStyle(Paint.Style.STROKE);
    }
}
