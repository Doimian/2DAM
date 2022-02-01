package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    //Declaración de variables
    private GridView grid;
    final String[] datos = new String[]{"Alumno1", "Alumno2", "Alumno3", "Alumno4" , "Alumno5" , "Alumno6" , "Alumno7" , "Alumno8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridView) findViewById(R.id.grid_view);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        grid.setAdapter(adaptador);

    }
}