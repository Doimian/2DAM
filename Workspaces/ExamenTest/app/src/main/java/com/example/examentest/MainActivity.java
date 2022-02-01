package com.example.examentest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Pregunta> preguntas = new ArrayList();
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout1);

        //Crear preguntas
        preguntas.add(new Pregunta("¿Cuál es el lenguaje más utilizado?", "PHP", "C", 2));
        preguntas.add(new Pregunta("¿Permite Android crear vistas personalizadas?", "Verdadero", "Falso", 1));
        for(int i = 0; i < preguntas.size() ; i++)
        {
            PreguntaView view = new PreguntaView(this);
            view.crear_preg_resp(preguntas.get(i));

            //Añadir la vista al layout
            layout.addView(view);
        }
    }
}