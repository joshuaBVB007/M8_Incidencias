package com.example.clase_m8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clase_m8.db.IncidenciaBDHelper;

public class MainActivity extends AppCompatActivity {
    //si queremos guardalo en un arraylist debemos hacerlo aqui
    public IncidenciaBDHelper dbhelper;
    public SQLiteDatabase db;


    EditText user_name;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name=findViewById(R.id.user_name);
        password=findViewById(R.id.password);

        //Base de datos
        dbhelper=new IncidenciaBDHelper(getApplicationContext());
        db=dbhelper.getWritableDatabase();
    }

    public void registrar(View v){
        String nombre_usuario=user_name.getText().toString();
        String contrasenia=password.getText().toString();
        if(nombre_usuario.contains("@") && contrasenia.length()==0){
            Toast.makeText(this,"Ingresando",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,Menu_principal.class);
            startActivity(i);
        }else{
            Toast.makeText(this,"Usuario o contraseña invalido",Toast.LENGTH_SHORT).show();
        }
    }


}