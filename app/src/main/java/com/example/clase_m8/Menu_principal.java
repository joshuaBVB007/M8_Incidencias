package com.example.clase_m8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.clase_m8.db.IncidenciaBDHelper;

public class Menu_principal extends AppCompatActivity {
    public IncidenciaBDHelper dbhelper;
    public SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //Base de datos
        dbhelper=new IncidenciaBDHelper(getApplicationContext());
        db=dbhelper.getWritableDatabase();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.con_expecificas,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if(id==R.id.Altas){
            Toast.makeText(this,"Altas",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.Medias){
            Toast.makeText(this,"Medias",Toast.LENGTH_SHORT).show();
        }else if(id==R.id.Bajas){
            Toast.makeText(this,"Bajas",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}