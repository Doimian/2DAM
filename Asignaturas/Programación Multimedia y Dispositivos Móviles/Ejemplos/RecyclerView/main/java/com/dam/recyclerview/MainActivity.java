package com.dam.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // Usamos esta matriz dinámica (ArrayList) para guardar los datos de las 32 opciones del listado
    private ArrayList<Opcion> datos;

    // Lista del tipo RecyclerView
    private RecyclerView recView;

    // Botones con las nuevas opciones
    private Button btnInsertar;
    private Button btnBorrar;
    private Button btnMover;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscamos en el layout la lista RecyclerView
        recView = (RecyclerView) findViewById(R.id.RecView);

        // Indicamos que el tamaño del RecyclerView no cambia
        recView.setHasFixedSize(true);

        // Crea el ArrayList con elementos Opcion
        datos = new ArrayList<Opcion>();

        // Definimos 32 Opciones del listado en la matriz
        for(int i=1; i<=32; i++)
            if (i%2 ==0)
                datos.add(new Opcion("Opción " + i, "Ésta es la opción número " + i, R.drawable.star1));
            else
                datos.add(new Opcion("Opción " + i, "Ésta es la opción número " + i, R.drawable.star2));

        // Creamos el Adaptador que se usa para mostrar las opciones del listado
        final AdaptadorOpciones adaptador = new AdaptadorOpciones(datos);

        // Definimos el evento onClick del adaptador
        adaptador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Usamos el resultado de "getChildAdapterPosition()" para saber
                // la posición de la opción sobre la que el usuario ha hecho clic.
                Toast.makeText(getBaseContext(), "Has hecho clic en '" + datos.get(recView.getChildAdapterPosition(v)).getTitulo()
                        + "'", Toast.LENGTH_SHORT).show();
            }
        });

        // Asignamos el adaptador al RecyclerView para que sepa cómo dibujar el listado de opciones
        recView.setAdapter(adaptador);

        // Muy importante indicar el tipo de Layout. ¡Obligatorio!!!
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        // Animador de la lista
        recView.setItemAnimator(new DefaultItemAnimator());

        // Ahora definimos los eventos onClick de los botones
        btnInsertar = (Button)findViewById(R.id.BtnInsertar);

        // El botón insertar añade una nueva opción
        btnInsertar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Añadimos una nueva opción en datos en la posición 1 (el listado comienza en el 0)
                datos.add(1, new Opcion("Nueva opción", "Subtítulo nueva opción", R.drawable.star1));

                // Indicamos al adaptador que hemos añadido un nuevo elemento en la posición 1
                // para que redibuje el RecyclerView.
                adaptador.notifyItemInserted(1);
            }
        });

        btnBorrar = (Button)findViewById(R.id.BtnBorrar);
        // El botón borrar quitar el elemento 1 añadido anteriormente
        btnBorrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Si hay suficientes elementos en la lista...
                if (datos.size()<2) return;

                // Quitamos el elemento 1
                datos.remove(1);

                // Indicamos al adaptador que hemos quitado el elemento en la posición 1
                // para que redibuje el RecyclerView.
                adaptador.notifyItemRemoved(1);
            }
        });

        btnMover = (Button)findViewById(R.id.BtnMover);
        // El botón mover cambia de posición los elementos 1 y 2
        btnMover.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Obtenemos los datos de la posición 1
                Opcion aux = datos.get(1);

                // En la posición 1 escribimos los datos de la posición 2
                datos.set(1, datos.get(2));

                // En la posición 2 escribimos los datos de la 1
                datos.set(2, aux);

                // Indicamos al adaptador que hemos movido los elementos 1 y 2
                // para que redibuje el RecyclerView.
                adaptador.notifyItemMoved(1, 2);
            }
        });

    } // end onCreate
}