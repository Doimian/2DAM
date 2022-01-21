package com.example.ejemplospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView text_contador;
    private int contador;
    private Spinner spinner;
    private String text_seleccionado;
    final String[] datos = new String[]{
            "Suma",
            "Resta"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_contador = (TextView) findViewById(R.id.contador);
        spinner = (Spinner) findViewById(R.id.spinner);
        contador = 0;
        text_contador.setText("" + contador);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datos);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                text_seleccionado = datos[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void operador(View view)
    {
       if(text_seleccionado.equals("Suma"))
       {
           contador++;
           text_contador.setText("" + contador);

       }else if(text_seleccionado.equals("Resta"))
       {
           contador--;
           text_contador.setText("" + contador);
       }
    }
}