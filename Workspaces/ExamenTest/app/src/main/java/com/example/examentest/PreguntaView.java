package com.example.examentest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PreguntaView extends LinearLayout {
    private TextView tv_pregunta;
    private Button b_resp1;
    private Button b_resp2;

    public PreguntaView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.pregunta_layout, this, true);
        tv_pregunta = findViewById(R.id.tv_pregunta);
        b_resp1 = findViewById(R.id.boton1);
        b_resp2 = findViewById(R.id.boton2);
    }

    public void crear_preg_resp(Pregunta pregunta)
    {
        tv_pregunta.setText(pregunta.getPregunta());
        b_resp1.setText(pregunta.getRespuesta1());
        b_resp2.setText(pregunta.getRespuesta2());
        b_resp1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuesta_correcta() == 1)
                {
                    Log.d("Ejecucion", "Respuesta correcta");
                }else{
                    Log.d("Ejecucion", "Respuesta incorrecta");
                }
                desactivarBotones();
            }
        });
        b_resp2.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(pregunta.getRespuesta_correcta() == 2)
            {
                Log.d("Ejecucion", "Respuesta correcta");
            }else{
                Log.d("Ejecucion", "Respuesta incorrecta");
            }
            desactivarBotones();
        }
    });
    }

    public void desactivarBotones()
    {
        b_resp1.setClickable(false);
        b_resp2.setClickable(false);
    }
}
