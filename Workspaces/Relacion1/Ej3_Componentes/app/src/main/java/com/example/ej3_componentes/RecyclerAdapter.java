package com.example.ej3_componentes;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterViewHolder> {
    //Atributos
    private Dispositivo[] dispositivos;


    public RecyclerAdapter(Dispositivo[] dis)
    {
        dispositivos = dis;
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
        return dispositivos.length;
    }

    public class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView image;
        private EditText text;
        private CheckBox seleccionado;

        public RecyclerAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            //Linko mi variable con el layout.
            image = itemView.findViewById(R.id.tv_imageView);
            text = itemView.findViewById(R.id.tv_text);
            seleccionado = itemView.findViewById(R.id.tv_checkBox);
        }

        public void bind(int posicion)
        {
            image.setImageResource(dispositivos[posicion].getImagen());
            text.setText(dispositivos[posicion].getTexto());
            seleccionado.setOnCheckedChangeListener((buttonView, isChecked) -> dispositivos[posicion].setSelected());
        }
    }
}
