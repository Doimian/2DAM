package com.example.ej4_cesta;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecyclerAdapterViewHolder>{


    //Atributos
    ArrayList<Elemento> elementos;

    public RecycleAdapter(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public RecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context contexto = parent.getContext();

        //Creamos el inflater
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View view = inflater.inflate(R.layout.cesta_item, parent, false);

        RecyclerAdapterViewHolder viewHolder = new RecyclerAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterViewHolder holder, int position) {
        holder.bind(position);
    }

    public void addElemento(Elemento elemento)
    {
        elementos.add(elemento);
        notificar();
    }

    private void notificar() {
        notifyDataSetChanged();
    }

    public void eliminarElemento(int item)
    {
        elementos.remove(item);
        notificar();
    }

    @Override
    public int getItemCount() { return elementos.size(); }

    public class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener
    {
        private Elemento textoview;

        public RecyclerAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            //Linko mi variable con el layout
            textoview = itemView.findViewById(R.id.elemento);
            itemView.setOnCreateContextMenuListener(this);
            textoview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(textoview.tachado)
                    {
                        textoview.setText("hola");
                        notificar();
                        //tachar el texto

                    }else
                    {
                        textoview.setText("hola");
                        notificar();

                    }

                    Log.d("a", "llega" + textoview.getText().toString());
                }
            });

        }

        public void bind(int posicion)
        {

            textoview.setText(elementos.get(posicion).getText().toString());

        }


        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Elija una opción");
            contextMenu.add(this.getAdapterPosition(), 111, 0, "Eliminar");
            contextMenu.add(this.getAdapterPosition(), 112, 0, "Modificar");
        }
    }
}
