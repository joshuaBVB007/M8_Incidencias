package com.example.clase_m8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase_m8.Recursos.Incidencia;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context c;
    ArrayList<Incidencia> lista;
    public MyAdapter(Context context, ArrayList<Incidencia> lista_Incidencias) {
        this.lista=lista_Incidencias;
        c=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(c);
        View V=inflater.inflate(R.layout.mi_fila,parent,false);
        return new MyViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t1.setText(lista.get(position).contenido);
        holder.t2.setText(lista.get(position).nivel_peligro);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t1;
        TextView t2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           t1=itemView.findViewById(R.id.tv1);
           t2=itemView.findViewById(R.id.tv2);
        }
    }



}
