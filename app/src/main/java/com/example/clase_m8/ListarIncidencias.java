package com.example.clase_m8;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clase_m8.Recursos.Incidencia;
import com.example.clase_m8.db.IncidenciaBDHelper;

public class ListarIncidencias extends Fragment {
    Spinner spinner;
    Button buscar;
    public ListarIncidencias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        View V=inflater.inflate(R.layout.fragment_listar_incidencias, container, false);

        buscar=(Button)V.findViewById(R.id.buscar);

        String nivel [] ={"Todas","Hechas","Asignadas","Pendientes"};
        spinner=(Spinner)V.findViewById(R.id.spinner_2);
        ArrayAdapter<String> adapte=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,nivel);
        spinner.setAdapter(adapte);

        IncidenciaBDHelper dbhelper=new IncidenciaBDHelper(getContext());
        SQLiteDatabase db=dbhelper.getWritableDatabase();

        final RecyclerView recyclerView=(RecyclerView)V.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(V.getContext()));


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IncidenciaBDHelper dbhelper=new IncidenciaBDHelper(getContext());
                SQLiteDatabase db=dbhelper.getReadableDatabase();



                String get_spinner=spinner.getSelectedItem().toString();

                if(get_spinner.equals("Todas")){
                    MyAdapter adapter=new MyAdapter(getContext(),IncidenciaBDHelper.getAllIncidencies(db,get_spinner));
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    Toast.makeText(getContext(), "Todas", Toast.LENGTH_SHORT).show();
                }else if(get_spinner.equals("Hechas")){
                    String filter="Alta";
                    MyAdapter adapter=new MyAdapter(getContext(),IncidenciaBDHelper.getAllIncidencies(db,filter));
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }else if(get_spinner.equals("Asignadas")){
                    String filter="Media";
                    MyAdapter adapter=new MyAdapter(getContext(),IncidenciaBDHelper.getAllIncidencies(db,filter));
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }else if(get_spinner.equals("Pendientes")){
                    String filter="Baja";
                    MyAdapter adapter=new MyAdapter(getContext(),IncidenciaBDHelper.getAllIncidencies(db,filter));
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }




            }
        });


        return V;
    }
}