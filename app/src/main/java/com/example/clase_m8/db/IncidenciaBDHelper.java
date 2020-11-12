package com.example.clase_m8.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.clase_m8.Recursos.Incidencia;
import com.example.clase_m8.db.IncidenciaContract.*;

public class IncidenciaBDHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME +
            "(" + IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IncidenciaEntry.TABLE_NAME_TITLE + " TEXT)";

    public IncidenciaBDHelper(@Nullable Context context) {
        super(context, "Incidencias.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void insertIncidencia(SQLiteDatabase db, Incidencia miincidencia) {
        if(db.isOpen()){
            ContentValues values=new ContentValues();

            values.put(IncidenciaEntry.TABLE_NAME_TITLE,miincidencia.getContenido());

            try {
                db.insert(IncidenciaEntry.TABLE_NAME,null,values);
            }catch (SQLException e){
                Log.i("prova","insert ko");
            }

        }else{
            Log.i("prova","database is closed");
        }

    }
}
