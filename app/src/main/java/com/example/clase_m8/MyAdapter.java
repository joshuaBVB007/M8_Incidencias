package com.example.clase_m8;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if(lista!=null){
            String statusText = "";
            int color = 0;
            int textColor = 0;

            if(lista.get(position).getEstado().equals("0")){
                statusText="Pendiente";
                color = Color.CYAN;
                textColor = Color.WHITE;
            }else if(lista.get(position).getEstado().equals("1")){
                statusText="Asignada";
                color = Color.GREEN;
                textColor = Color.WHITE;
            }else if(lista.get(position).getEstado().equals("2")){
                statusText="Hecha";
                color = Color.RED;
                textColor = Color.WHITE;
            }
            holder.estado_Incidencia.setText(statusText);
            holder.estado_Incidencia.setBackgroundColor(color);
            holder.estado_Incidencia.setTextColor(textColor);

        }

        holder.titulo_Incidencia.setText(lista.get(position).getContenido());
        holder.contenido_Incidencia.setText(lista.get(position).getPrioridad());
        holder.fecha_Incidencia.setText(lista.get(position).dimeFecha());
        holder.descripcion_Incidencia.setText(lista.get(position).getDesc());
        holder.id.setText(lista.get(position).getId());
        holder.Detalle.setText(lista.get(position).getDetalle());
        
        final int id=position;
        holder.Detalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity)v.getContext();
                Vista_Enfocada muestra = new Vista_Enfocada();

                Bundle paquete = new Bundle();
                paquete.putInt("ID",lista.get(id).id);
                paquete.putString("TITLE", lista.get(id).getContenido());
                paquete.putString("PRIORITY", lista.get(id).getPrioridad());
                paquete.putString("DESCRIPCION", lista.get(id).getDesc());
                paquete.putString("DATE", lista.get(id).dimeFecha());
                paquete.putString("STATE", lista.get(id).getEstado());

                muestra.setArguments(paquete);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, muestra).addToBackStack(null).commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titulo_Incidencia;
        TextView contenido_Incidencia;
        TextView fecha_Incidencia;
        TextView descripcion_Incidencia;
        TextView estado_Incidencia;
        TextView id;
        TextView Detalle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           titulo_Incidencia =itemView.findViewById(R.id.titulo);
           contenido_Incidencia =itemView.findViewById(R.id.contenido);
           fecha_Incidencia =itemView.findViewById(R.id.fecha);
           descripcion_Incidencia =itemView.findViewById(R.id.descripcion);
           estado_Incidencia=itemView.findViewById(R.id.estado);
           id=itemView.findViewById(R.id.id);
           Detalle=itemView.findViewById(R.id.detalle);
        }
    }

}
