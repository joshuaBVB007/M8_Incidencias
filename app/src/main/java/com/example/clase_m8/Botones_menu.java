package com.example.clase_m8;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Botones_menu extends Fragment {

    //Variables de clase
    View V;
    Button B1;
    Button B2;
    Button B3;

    public Botones_menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        V=inflater.inflate(R.layout.fragment_botones_menu, container, false);

        B1=(Button)V.findViewById(R.id.b1);
        B2=(Button)V.findViewById(R.id.b2);
        B3=(Button)V.findViewById(R.id.b3);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vista= new IngresoIncidencia();
                FragmentManager mimanejador=getFragmentManager();
                FragmentTransaction mitransaccion=mimanejador.beginTransaction();
                mitransaccion.replace(R.id.contenedor,vista);
                mitransaccion.commit();
            }
        });

        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vista= new ListarIncidencias();
                FragmentManager mimanejador=getFragmentManager();
                FragmentTransaction mitransaccion=mimanejador.beginTransaction();
                mitransaccion.replace(R.id.contenedor,vista);
                mitransaccion.commit();
            }
        });

        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment vista= new Eliminar_Incidencias();
                FragmentManager mimanejador=getFragmentManager();
                FragmentTransaction mitransaccion=mimanejador.beginTransaction();
                mitransaccion.replace(R.id.contenedor,vista);
                mitransaccion.commit();
            }
        });



        return V;
    }
}