package com.example.recyclerviewejemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterViewHolder> {
    //Atributo
    private int num_elementos;

    public RecyclerAdapter(int numero)
    {
        num_elementos = numero;
    }

    @NonNull
    @Override
    public RecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context contexto = parent.getContext();
        //Crear un inflater que se usa pra inflar el diseño: recupera el layout que hemos creado nuevo en el xml
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View view = inflater.inflate(R.layout.fila_recycler, parent, false);

        RecyclerAdapterViewHolder viewholder = new RecyclerAdapterViewHolder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterViewHolder holder, int position) {
        holder.bind(position);
    }

    //Devuelve el número de items de mi recyclerview
    @Override
    public int getItemCount() {
        return num_elementos;
    }

    public class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textoview;

        public RecyclerAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            //Linko mi variable con el layout.
            textoview = itemView.findViewById(R.id.tv_item);
        }

        public void bind(int posicion)
        {
            textoview.setText("Opcion "+posicion);
        }
    }
}
