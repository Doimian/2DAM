package com.example.recyclerviewejemplo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String[] datos = {""};
    private RecyclerView lista;
    private static final int NUM_ELEMENTOS = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.rv_lista);

        //Declaramos un linearlayout que nos indica la disposición de los datos en el recycler
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        lista.setLayoutManager(linearLayout);
        lista.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //Creamos el adaptador
        RecyclerAdapter adaptador = new RecyclerAdapter(NUM_ELEMENTOS);
        lista.setAdapter(adaptador);
    }
}