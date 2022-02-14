package com.example.ej3_componentes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RecyclerView lista;
    private static final int NUM_ELEMENTOS = 8;
    //Array de Dispositivos
    Dispositivo dispositivo1 = new Dispositivo("Bombilla", R.drawable.bombilla);
    Dispositivo dispositivo2 = new Dispositivo("Computadora", R.drawable.computadora);
    Dispositivo dispositivo3 = new Dispositivo("Consola", R.drawable.consola);
    Dispositivo dispositivo4 = new Dispositivo("Móvil", R.drawable.movil);
    Dispositivo dispositivo5 = new Dispositivo("Smartwatch", R.drawable.smartwatch);
    Dispositivo dispositivo6 = new Dispositivo("Sobremesa", R.drawable.sobremesa);
    Dispositivo dispositivo7 = new Dispositivo("Tableta", R.drawable.tableta);
    Dispositivo dispositivo8 = new Dispositivo("Tostadora", R.drawable.tostadora);
    Dispositivo[] dispositivos = {dispositivo1, dispositivo2, dispositivo3, dispositivo4, dispositivo5, dispositivo6, dispositivo7, dispositivo8};

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
        RecyclerAdapter adaptador = new RecyclerAdapter(dispositivos);
        lista.setAdapter(adaptador);

        //Sacamos el boton
        Button botonAceptar = findViewById(R.id.button);

        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Sacamos los elementos marcados
                String seleccionados = "";
                for (Dispositivo dispositivo : dispositivos) {
                   if(dispositivo.getMarcado())
                       seleccionados += " " + dispositivo.getTexto();
                }

                //Hacemos el Toast
                if(seleccionados.equals(""))
                    Toast.makeText(getApplicationContext(), "No has seleccionado ninguna opción", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Has seleccionado: " + seleccionados, Toast.LENGTH_SHORT).show();
            }
        });

    }
}