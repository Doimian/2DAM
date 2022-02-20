package com.example.ej4_cesta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Button boton;
    private RecyclerView lista;
    RecycleAdapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = findViewById(R.id.button);
        lista = findViewById(R.id.rv_lista);
        //Declaramos un array de elementos
        ArrayList<Elemento> elementos = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        lista.setLayoutManager(manager);
        //Creamos el adaptador
        adaptador = new RecycleAdapter(elementos);
        lista.setAdapter(adaptador);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case 111:
                adaptador.eliminarElemento(item.getGroupId());
                return true;
            case 112:
                alertaMod(item.getGroupId());
                return true;
        }
        return true;
    }


    public void alertaMod(int itemPos)
    {
        //Atributos
        Button botonHecho;
        Button botonCancelar;
        EditText et_mod;

        //Creamos la alerta
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View vista = inflater.inflate(R.layout.alertdialog_mod_layout, null);
        builder.setView(vista);
        AlertDialog alerta = builder.create();

        //Linkamos
        botonHecho = vista.findViewById(R.id.ad_mod_btn_add);
        botonCancelar = vista.findViewById(R.id.ad_mod_btn_cancel);
        et_mod = vista.findViewById(R.id.ad_mod_tf);

        //Preparamos
        et_mod.setText(adaptador.elementos.get(itemPos).getText().toString());

        //Mostramos
        alerta.show();
        et_mod.requestFocus();

        //Listeners
        botonHecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adaptador.elementos.get(itemPos).setText(et_mod.getText().toString());
                adaptador.notifyDataSetChanged();
                if(alerta.isShowing()) {
                    alerta.cancel();
                }
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alerta.isShowing()) {
                    alerta.cancel();
                }
            }
        });
    }

    public void onClickAlert(View view)
    {
        //Variables
        View vista;
        Button botonAdd;
        Button botonCancel;
        EditText et_nombre;
        AlertDialog alert;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        vista = inflater.inflate(R.layout.alertdialog_layout, null);
        builder.setView(vista);
        alert = builder.create();

        //Linkamos
        botonAdd = vista.findViewById(R.id.ad_btn_add);
        botonCancel = vista.findViewById(R.id.ad_btn_cancel);
        et_nombre = vista.findViewById(R.id.ad_tf);

        botonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adaptador.addElemento(new Elemento(alert.getContext(), et_nombre.getText().toString()));
                if(alert.isShowing()) {
                    alert.cancel();
                }
            }
        });

        botonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( alert.isShowing()) {
                    alert.cancel();
                }
            }
        });
        alert.show();
        et_nombre.requestFocus();
    }
}