package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaración de variables
    ListView list;
    Button boton;
    EditText texto;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listview);
        boton = findViewById(R.id.boton);
        texto = findViewById(R.id.edittext);
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), datos.get(i), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void boton (View view)
    {
        //Declaración de variables
        String nombre;
    }
}