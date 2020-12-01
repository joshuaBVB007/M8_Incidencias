package com.example.clase_m8.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.clase_m8.Recursos.Incidencia;
import com.example.clase_m8.db.IncidenciaContract.*;

import java.util.ArrayList;

public class IncidenciaBDHelper extends SQLiteOpenHelper {
    //Esta es la tuya marta
    /*private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME +
            "(" + IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IncidenciaEntry.TABLE_NAME_TITLE + " TEXT)";
    */

    //LINEA DE ABAJO ES LA MIA:le he añadido IncidenciaEntry.TABLE_NAME_PRIORITY+"TEXT

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME +
            "(" + IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IncidenciaEntry.TABLE_NAME_TITLE+"TEXT,"+IncidenciaEntry.TABLE_NAME_PRIORITY+"TEXT)";


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
            ContentValues contenido=new ContentValues();
            contenido.put(IncidenciaEntry.TABLE_NAME_TITLE,miincidencia.getContenido());
            //Linea de abajo añadida
            contenido.put(IncidenciaEntry.TABLE_NAME_PRIORITY,miincidencia.getNivel_peligro());
            try {
                db.insert(IncidenciaEntry.TABLE_NAME,null,contenido);
            }catch (SQLException e){
                Log.i("prova","insert ko");
            }
        }else{
            Log.i("prova","database is closed");
        }
    }

    public static ArrayList<Incidencia> getAllIncidencies(SQLiteDatabase db){
        ArrayList<Incidencia> listIncidencies = new ArrayList<Incidencia>();
        //Selection all registers from the table Incidencia using Cursor
        Cursor cursor = db.query(IncidenciaEntry.TABLE_NAME,null,null,null,null,null,null);
        //Iteration on the cursor results and fill the array
        while (cursor.moveToNext()) {
            String inc = cursor.getString(cursor.getColumnIndex(IncidenciaEntry.TABLE_NAME_TITLE));
            String inc2 = cursor.getString(cursor.getColumnIndex(IncidenciaEntry.TABLE_NAME_PRIORITY));
            Incidencia incidencia = new Incidencia(inc,inc2);
            listIncidencies.add(incidencia);
        }
        cursor.close();
        return listIncidencies;
    }

    public void eliminarIncidencias(SQLiteDatabase db, SQLiteOpenHelper helper) {
        db = helper.getWritableDatabase();
        db.delete(IncidenciaEntry.TABLE_NAME,null,null);


    }


}
