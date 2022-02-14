package com.example.ej4_cesta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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
        //Declaramos un
        //Creamos el adaptador
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case 111:
                //adaptador.eliminar();
                return true;
            case 112:
                return true;
        }
        return true;
    }

    public void onClickAlert(View view)
    {
        //Variables
        View vista;
        Button boton;
        EditText et_nombre;
        AlertDialog alert;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        vista = inflater.inflate(R.layout.alertdialog_layout, null);
        builder.setView(vista);

        //Linkamos
        boton = vista.findViewById(R.id.button2);
        et_nombre = vista.findViewById(R.id.et_nombre);
        alert = builder.create();
        alert.show();
    }
}