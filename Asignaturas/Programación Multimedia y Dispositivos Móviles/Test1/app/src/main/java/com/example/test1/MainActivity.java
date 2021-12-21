package com.example.test1;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity
{
    private TextView texto1;
    private TextView lblTexto1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlaza una vista con el code
        lblTexto1 = (TextView) findViewById(R.id.texto1);
        String texto = lblTexto1.getText().toString();
        texto += " uno";
        lblTexto1.setText(texto);

        // Evento de boton
      /*  final Button btnBoton = (Button) findViewById(R.id.button);
        btnBoton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                lblTexto1.setText("Pulsado");
            }
        });*/
    }
    public void onClick(View v)
    {
        v.getId();

    }

    /*
    *
    * case R.id.btnButton8 :    cadena += "8";
    *                           operando1 = operando1 * 10 + 8;
    *                           lcdDisplay.setText(String.valueOf(cadena));
    *
    *
    *
    * case R.id.btnSuma :   cadena += "";
    *
    *     private void initState()
    *    {
    *        operacion = ' ';
    *        operando0 = 0;
    *        operando1 = 0;
    *        cadena="";
    *       lcdDisplay.setCa
    *   }
    *
    *
    * */




}