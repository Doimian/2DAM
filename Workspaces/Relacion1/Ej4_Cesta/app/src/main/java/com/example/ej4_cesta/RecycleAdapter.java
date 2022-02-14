package com.example.ej4_cesta;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecyclerAdapterViewHolder>{
    //Atributos
    List<TextView> elementos;

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

    public void addElemento(TextView elemento)
    {
        elementos.add(elemento);
    }

    @Override
    public int getItemCount() { return elementos.size(); }

    public class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener
    {
        private TextView textoview;

        public RecyclerAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            //Linko mi variable con el layout
            textoview = itemView.findViewById(R.id.tv_item);
            itemView.setOnCreateContextMenuListener(this);
        }

        public void bind(int posicion)
        {
            textoview.setText(elementos.get(posicion).getText());
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Elija una opción");
            contextMenu.add(this.getAdapterPosition(), 111, 0, "Eliminar");
            contextMenu.add(this.getAdapterPosition(), 112, 0, "Modificar");
        }
    }
}
