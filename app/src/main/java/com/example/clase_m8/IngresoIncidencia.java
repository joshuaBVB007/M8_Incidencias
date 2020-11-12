package com.example.clase_m8;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clase_m8.Recursos.Incidencia;
import com.example.clase_m8.db.IncidenciaBDHelper;


public class IngresoIncidencia extends Fragment {
    View V;
    EditText info_incidencia;
    Button Boton_incidencia;
    Spinner spinner;
    public IngresoIncidencia() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        V=inflater.inflate(R.layout.fragment_ingreso_incidencia, container, false);

        info_incidencia=(EditText)V.findViewById(R.id.ed_ingreso);
        Boton_incidencia=(Button)V.findViewById(R.id.b_ingreso);

        String nivel [] ={"Alta","Media","Baja"};

        spinner=(Spinner)V.findViewById(R.id.spinner_1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,nivel);
        spinner.setAdapter(adapter);

        Boton_incidencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String get_info_incidencia=info_incidencia.getText().toString();
                String get_spinner=spinner.getSelectedItem().toString();
                //creamos la incidencia
                Incidencia miincidencia=new Incidencia(get_info_incidencia,get_spinner);
                Toast.makeText(getContext(),"ingresado",Toast.LENGTH_SHORT).show();

                IncidenciaBDHelper dbhelper=((MainActivity)getActivity()).dbhelper;
                SQLiteDatabase db=((MainActivity)getActivity()).db;

                dbhelper.insertIncidencia(db,miincidencia);

            }
        });



        return V;
    }
}