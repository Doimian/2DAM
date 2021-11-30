package com.example.t3r1a2_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Botones numericos
    private final int[] botoneraId = {R.id.btnButton0, R.id.btnButton1,R.id.btnButton3, R.id.btnButton4, R.id.btnButton5, R.id.btnButton6, R.id.btnButton7, R.id.btnButton8, R.id.btnButton9};
    private Button botoneraDigitos[];

    // Botones de operaciones
    private final int operacionesID[] = {R.id.btnButtonSuma, R.id.btnButtonResta, R.id.btnButtonMulti, R.id.btnButtonDiv};
    private Button botoneraOp[];

    // Botones de control
    private Button btnDelete;
    private Button btnIgual;

    // Display
    private EditText lcdDisplay;

    // Otros
    private int operando1;
    private int operando2;
    private char operacion;
    private int resultado;
    private String cadena;
    private boolean newOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toma la referencia al display
        lcdDisplay = (EditText) findViewById(R.id.lcdDisplay);

        // Toma las referencias a los botones numericos
        botoneraDigitos = new Button[10];
        for(int i = 0;i < 10; i++)
        {
            botoneraDigitos[i] = (Button) findViewById(botoneraId[i]);
        }

        // Asigna los gestores de eventos de cda boton
        for(int i = 0;i < 10; i++)
        {
            botoneraDigitos[i].setOnClickListener(this);
        }

        // Toma las referencias de los botones de operaciones
        botoneraOp = new Button[4];
        for(int i = 0;i < 4; i++)
        {
           botoneraOp[i] = (Button) findViewById(operacionesID[i]);
           botoneraOp[i].setOnClickListener(this);
        }

        // Botones de control
        btnDelete = (Button) findViewById(R.id.btnButtonClear);
        btnIgual = (Button) findViewById(R.id.btnButtonEqual);

        // Eventos para los botones de control
        btnDelete.setOnClickListener(this);
        btnIgual.setOnClickListener(this);

        // Coloca la calculadora en el estado inicial
        initState();
    }

    @Override
    public void onClick(View view)
    {

        // ¿Quien me llama?
        Button pushButton = (Button) view;
        switch (view.getId())
        {
            // Digitos
            case R.id.btnButton0    :
            case R.id.btnButton1    :
            case R.id.btnButton3    :
            case R.id.btnButton4    :
            case R.id.btnButton5    :
            case R.id.btnButton6    :
            case R.id.btnButton7    :
            case R.id.btnButton8    :
            case R.id.btnButton9    :
                                        if(newOperation)
                                            initState();
                                        operando1 = operando1 * 10 + Integer.parseInt(pushButton.getText().toString());
                                        if(operando1 != 0)
                                        {
                                            cadena += pushButton.getText();
                                            lcdDisplay.setText(cadena);
                                        }
                                        newOperation = false;
                                        break;

            case R.id.btnButtonSuma :
            case R.id.btnButtonResta:
            case R.id.btnButtonMulti:
            case R.id.btnButtonDiv  :   operacion = pushButton.getText().toString().charAt(0);
                                        cadena += operacion;
                                        operando2 = operando1;
                                        operando1 = 0;
                                        lcdDisplay.setText(cadena);
                                        newOperation = false;
                                        break;

            case R.id.btnButtonEqual:   // Realiza el calculo
                                        switch(operacion)
                                        {
                                            case '+':   resultado = operando1 + operando2; break;
                                            case '-':   resultado = operando2 - operando1; break;
                                            case 'x':   resultado = operando1 * operando2; break;
                                            case '/':   if(operando1 != 0)
                                                            resultado = operando2 / operando1;
                                                        else
                                                            cadena = "Error";
                                                        break;
                                        }

                                        // Muestra resultado en LCD
                                        if(cadena.equals("Error"))
                                            lcdDisplay.setText("Error, NaN");
                                        else
                                            lcdDisplay.setText(cadena + " = " + resultado);

                                        newOperation = true;
                                        break;

            case R.id.btnButtonClear: initState(); break;
        }
    }

    private void initState(){
        operacion = ' ';
        operando1 = 0;
        operando2 = 0;
        cadena = "";
        resultado = 0;
        lcdDisplay.setText(cadena);
        newOperation = true;
    }
}