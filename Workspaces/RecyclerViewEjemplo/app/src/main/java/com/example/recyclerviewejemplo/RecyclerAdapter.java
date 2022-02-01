package com.example.recyclerviewejemplo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterViewHolder> {
    //Atributos
    private int num_elementos;

    public RecyclerAdapter(int num_elementos)
    {
        num_elementos = num_elementos;
    }

    @NonNull
    @Override
    public RecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Crear un inflater que se usa para inflar el diseño: recupera el layout que hemos creado nueva
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
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

            //Linkar textoview con el layout
            textoview = itemView.findViewById(R.id.tv_item);
        }

        public void bind(int posicion)
        {
            textoview.setText("Opcion " + posicion);
        }
    }
}
