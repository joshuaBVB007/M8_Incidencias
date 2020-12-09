package com.example.clase_m8;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clase_m8.db.IncidenciaBDHelper;

public class Vista_Enfocada extends Fragment {
    IncidenciaBDHelper dbhelper;
    SQLiteDatabase db;
    String titulo,prioridad,descripcion,fecha,estado;
    int id_usuario;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbhelper = new IncidenciaBDHelper(getContext());
        db = dbhelper.getWritableDatabase();
        // Inflate the layout for this fragment
        View V=inflater.inflate(R.layout.fragment_vista__enfocada, container, false);

        dbhelper=((Menu_principal)getActivity()).dbhelper;
        db=((Menu_principal)getActivity()).db;

        id_usuario=getArguments().getInt("ID");
        titulo=getArguments().getString("TITLE");
        prioridad=getArguments().getString("PRIORITY");
        descripcion=getArguments().getString("DESCRIPCION");
        fecha=getArguments().getString("DATE");
        estado=getArguments().getString("STATE");

        TextView titulo_1=V.findViewById(R.id.tx_titulo);
        TextView prioridad_1=V.findViewById(R.id.tx_prioridad);
        TextView descripcion_1=V.findViewById(R.id.tx_descripcion);
        TextView fecha_1=V.findViewById(R.id.tx_fecha);
        final Button estado_1=V.findViewById(R.id.im_estado);
        final Button del_Incidencia=V.findViewById(R.id.del);

        titulo_1.setText(titulo);
        prioridad_1.setText(prioridad);
        descripcion_1.setText(descripcion);
        fecha_1.setText(fecha);
        estado_1.setText("Pendiente");

            estado_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String cambio=validarEstado(estado);
                    if(cambio.equals("1")){
                        estado_1.setText("Asignada");
                        estado_1.setBackgroundColor(Color.GREEN);
                        estado="1";
                        Toast.makeText(getContext(),"el estado es:"+estado+" id"+id_usuario,Toast.LENGTH_SHORT).show();
                        dbhelper.modificaStatus(db,dbhelper,id_usuario,estado);
                    }else if(cambio.equals("2")){
                        estado_1.setText("Realizada");
                        estado_1.setBackgroundColor(Color.RED);
                        estado="2";
                        Toast.makeText(getContext(),"el estado es:"+estado+" id "+id_usuario,Toast.LENGTH_SHORT).show();
                        dbhelper.modificaStatus(db,dbhelper,id_usuario,estado);
                    }else if(!cambio.equals("2") || !cambio.equals("1") ){
                        estado_1.setText("Pendiente");
                        estado_1.setBackgroundColor(Color.CYAN);
                        estado="0";
                        Toast.makeText(getContext(),"el estado es:"+estado+" id"+id_usuario,Toast.LENGTH_SHORT).show();
                        dbhelper.modificaStatus(db,dbhelper,id_usuario,estado);
                    }
                }
            });

        del_Incidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrardialogo();
            }
        });



        return V;
    }

    public String validarEstado(String estado){
        int numero_estado=Integer.parseInt(estado);
        String cambio;
        if(numero_estado==0){
            numero_estado++;
            cambio=String.valueOf(numero_estado);
            return cambio;
        }else if(numero_estado==1){
            numero_estado++;
            cambio=String.valueOf(numero_estado);
            return cambio;
        }else{
            numero_estado++;
            cambio=String.valueOf(numero_estado);
            return cambio;
        }
    }

    public void mostrardialogo(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("Warning!");
        builder.setMessage("Erase event?")
                .setPositiveButton("si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        IncidenciaBDHelper.Eliminar_Incidencia_ID(db,id_usuario);
                        Toast.makeText(getContext(),"Event successfully erased",Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }


}