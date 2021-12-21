package com.example.t3r1a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlaza con boton normal
        final Button btnButton = (Button) findViewById(R.id.boton);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Emite un mensaje Toast
                Toast msg = Toast.makeText(getApplicationContext(), "Botón normal pulsado", Toast.LENGTH_SHORT);
                msg.show();
            }
        });

        //Enlaza con el ToggleButton
        final ToggleButton tglButton = (ToggleButton) findViewById(R.id.toggleButton);
        tglButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tiene dos estados
                if(tglButton.isChecked())
                    Toast.makeText(getApplicationContext(), "Activado", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Desactivado", Toast.LENGTH_SHORT).show();

                //Mensaje Log
                Log.i(null, "Has pulsado ToggleButton");
            }
        });

        // Enlaza con el ImageButton
        final ImageButton imgButton = (ImageButton) findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mensaje Toast
                Toast.makeText(getApplicationContext(), "ImageButtonPulsado", Toast.LENGTH_LONG).show();

                // Mensaje Log
                Log.i(null, "Has pulsado ImageButton");
            }
        });

        // Tratamiento de los checkbuttons
        CheckBox checkbox1 = (CheckBox) findViewById(R.id.check1);
        CheckBox checkbox2 = (CheckBox) findViewById(R.id.check2);

        // Gestion del evento CheckBox
        // Define una instancia del listener, y luego se lo asignamos a los checks
        CheckBox.OnCheckedChangeListener checkBoxListener = new CheckBox.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                    Toast.makeText(getApplicationContext(), "Marcado " + buttonView.getText(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Desmarcado " + buttonView.getText(), Toast.LENGTH_SHORT).show();


            }
        };
        //Asignamos el listener a los checkbox
        checkbox1.setOnCheckedChangeListener(checkBoxListener);
        checkbox2.setOnCheckedChangeListener(checkBoxListener);

        //Tratamiento de los RadioButton
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.gruporb);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i)
            {
                //Conocemos la opción marcada consultando i (checkedID)
                final RadioButton radioButton = (RadioButton) findViewById(i);
                Toast.makeText(getApplicationContext(), "Seleccionado " + radioButton.getText(), Toast.LENGTH_SHORT).show();
                Log.i(null, "Boton pulsado: " + radioButton.getText());
            }
        });

        //Tratamiento del botón "Confirmar selección"
        final Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Comprueba el estado de los checkBox
                if(checkbox1.isChecked() && checkbox2.isChecked())
                    Toast.makeText(getApplicationContext(), "Seleccionado " + checkbox1.getText() + " y " + checkbox2.getText(), Toast.LENGTH_SHORT).show();
                else if(checkbox1.isChecked() && !checkbox2.isChecked())
                    Toast.makeText(getApplicationContext(), "Seleccionado " + checkbox1.getText(), Toast.LENGTH_SHORT).show();
                else if(!checkbox1.isChecked() && checkbox2.isChecked())
                    Toast.makeText(getApplicationContext(), "Seleccionado " + checkbox2.getText(), Toast.LENGTH_SHORT).show();
                else if(!checkbox1.isChecked() && !checkbox2.isChecked())
                    Toast.makeText(getApplicationContext(),"No has seleccionado nada" , Toast.LENGTH_SHORT).show();
            }
        });
    }
}