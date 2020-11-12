package com.example.clase_m8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.clase_m8.Recursos.Incidencia;

public class anadir_Incidencia extends AppCompatActivity {
    EditText contenido_incidencia;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir__incidencia);

        contenido_incidencia=findViewById(R.id.contenido_incidencia);
        String nivel [] ={"Alta","Media","Baja"};

        spinner=findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nivel);
        spinner.setAdapter(adapter);
    }

    public void crear_Incidencia(View V){
        String contenido=contenido_incidencia.getText().toString();
        String nivel=spinner.getSelectedItem().toString();
        //Incidencia objeto=new Incidencia(contenido,nivel);
        Toast.makeText(this,"ingresado",Toast.LENGTH_SHORT).show();
    }

}