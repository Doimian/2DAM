package com.example.ej1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CuentaBancaria extends androidx.appcompat.widget.AppCompatEditText {

    //Atributos de la clase
    private Paint pincel;

    public CuentaBancaria(@NonNull Context context) {
        super(context);
        setPincel();
    }

    public CuentaBancaria(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setPincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    public CuentaBancaria(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setPincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        //Invocamos el método de la superclase
        super.onDraw(canvas);
        canvas.drawRect(0,0, this.getWidth(), this.getHeight(), pincel);
        this.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(19)});
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        Editable texto = this.getText();
        if(keyCode != KeyEvent.KEYCODE_DEL) {
            if (this.getText().length() == 4) {
                this.setText(this.getText() + "-");
                this.setSelection(this.getText().length());
            } else if (this.getText().length() == 9) {
                this.setText(this.getText() + "-");
                this.setSelection(this.getText().length());
            }  else if (this.getText().length() == 14) {
                this.setText(this.getText() + "-");
                this.setSelection(this.getText().length());
            } /*else if (this.getText().length() >= 19) {
                texto = this.getText();
                texto.delete(19, texto.length());
                this.setText(texto);
                this.setSelection(this.getText().length());
            }*/
        }
        else
        {
            if(this.getText().length() == 5)
            {
                texto = this.getText();
                texto.delete(4, texto.length());
                this.setSelection(this.getText().length());
            } else if(this.getText().length() == 10) {
                texto = this.getText();
                texto.delete(9, texto.length());
                this.setSelection(this.getText().length());
            } else if(this.getText().length() == 15) {
                texto = this.getText();
                texto.delete(14, texto.length());
                this.setSelection(this.getText().length());
            }
        }
        return true;
    }

    public void setPincel()
    {
        pincel = new Paint();
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(5);
        pincel.setStyle(Paint.Style.STROKE);
    }

}
