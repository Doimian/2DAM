package com.example.ej3_componentes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView lista;
    private static final int NUM_ELEMENTOS = 88;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.rv_lista);

        //Declaramos un linearlayout que nos indica la disposición de los datos en el recycler.
        LinearLayoutManager linearlayout = new LinearLayoutManager(this);
        lista.setLayoutManager(linearlayout);
        lista.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //Creamos el adaptador
        RecyclerAdapter adaptador = new RecyclerAdapter(NUM_ELEMENTOS);
        lista.setAdapter(adaptador);
    }
}