package com.example.ej2_completadni;

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

public class CompletaDni extends androidx.appcompat.widget.AppCompatEditText {

    //Atributos de la clase
    private Paint pnegro;

    public CompletaDni(@NonNull Context context) {
        super(context);
        setpincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    public CompletaDni(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setpincel();
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
    }

    public CompletaDni(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        this.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(10)});
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        Editable texto;
        if(keyCode != KeyEvent.KEYCODE_DEL) {

            if (this.getText().length() == 8) {
                this.setText(this.getText() + " ");
                addLetra();
                this.setSelection(this.getText().length());
            }
        }
        else
        {
            if(this.getText().length() == 9)
            {
                texto = this.getText();
                texto.delete(7, texto.length());
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
    public void addLetra()
    {
         String[] letras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
         int resto = (Integer.parseInt(this.getText().toString().trim()) % 23);
         switch(resto)
         {
             case 0: this.setText(this.getText() + letras[0]); break;
             case 1: this.setText(this.getText() + letras[1]); break;
             case 2: this.setText(this.getText() + letras[2]); break;
             case 3: this.setText(this.getText() + letras[3]); break;
             case 4: this.setText(this.getText() + letras[4]); break;
             case 5: this.setText(this.getText() + letras[5]); break;
             case 6: this.setText(this.getText() + letras[6]); break;
             case 7: this.setText(this.getText() + letras[7]); break;
             case 8: this.setText(this.getText() + letras[8]); break;
             case 9: this.setText(this.getText() + letras[9]); break;
             case 10: this.setText(this.getText() + letras[10]); break;
             case 11: this.setText(this.getText() + letras[11]); break;
             case 12: this.setText(this.getText() + letras[12]); break;
             case 13: this.setText(this.getText() + letras[13]); break;
             case 14: this.setText(this.getText() + letras[14]); break;
             case 15: this.setText(this.getText() + letras[15]); break;
             case 16: this.setText(this.getText() + letras[16]); break;
             case 17: this.setText(this.getText() + letras[17]); break;
             case 18: this.setText(this.getText() + letras[18]); break;
             case 19: this.setText(this.getText() + letras[19]); break;
             case 20: this.setText(this.getText() + letras[20]); break;
             case 21: this.setText(this.getText() + letras[21]); break;
             case 22: this.setText(this.getText() + letras[22]); break;
         }
    }
}
