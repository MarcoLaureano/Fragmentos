package com.example.fragmentado1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderDatos>
             implements View.OnClickListener{

    ArrayList<Entidades> listDatos;
    private View.OnClickListener listener;

    public Adaptador(ArrayList<Entidades> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        view.setOnClickListener(this);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.entidad.setText(listDatos.get(position).getNom());
        holder.tituloMensaje.setText(listDatos.get(position).getInfo());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        TextView entidad;
        TextView tituloMensaje;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            entidad=itemView.findViewById(R.id.entidadData);
            tituloMensaje=itemView.findViewById(R.id.tituloData);
        }

        public void asignarDatos(String s) {
            entidad.setText(s);
            tituloMensaje.setText(s);
        }


    }
}
