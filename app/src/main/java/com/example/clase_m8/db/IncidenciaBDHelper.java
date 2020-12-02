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
import com.example.clase_m8.db.IncidenciaConstantesTabla.*;

import java.util.ArrayList;

import static com.example.clase_m8.db.IncidenciaConstantesTabla.IncidenciaEntry.DATABASE_NAME;
import static com.example.clase_m8.db.IncidenciaConstantesTabla.IncidenciaEntry.DATABASE_VERSION;

public class IncidenciaBDHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME +
            "(" + IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IncidenciaEntry.TABLE_NAME_TITLE+" TEXT,"+
            IncidenciaEntry.TABLE_NAME_PRIORITY+" TEXT,"+
            IncidenciaEntry.TABLE_NAME_DATE + " TEXT,"+
            IncidenciaEntry.TABLE_NAME_DESCRIPTION + " TEXT)";



    public IncidenciaBDHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {//SE CREA LA TABLA AL INICIAR ESTA ACTIVIY
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public void insertIncidencia(SQLiteDatabase db, Incidencia miincidencia) {
        if(db.isOpen()){
            ContentValues contenido=new ContentValues();
            contenido.put(IncidenciaEntry.TABLE_NAME_TITLE,miincidencia.getContenido());
            contenido.put(IncidenciaEntry.TABLE_NAME_PRIORITY,miincidencia.getPrioridad());
            contenido.put(IncidenciaEntry.TABLE_NAME_DATE,miincidencia.getFecha());
            contenido.put(IncidenciaEntry.TABLE_NAME_DESCRIPTION,miincidencia.getDesc());
            try {
                db.insert(IncidenciaEntry.TABLE_NAME,null,contenido);
            }catch (SQLException e){
                Log.i("prova","insert not happened");
            }
        }else{
            Log.i("prova","database is closed");
        }
    }

    //EL METODO QUE FALLA ES ESTE
    public static ArrayList<Incidencia> getAllIncidencies(SQLiteDatabase db){
        ArrayList<Incidencia> listIncidencies = new ArrayList<Incidencia>();
        //Selection all registers from the table Incidencia using Cursor
        Cursor cursor = db.rawQuery("select * from "+IncidenciaEntry.TABLE_NAME,null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while (cursor.moveToNext()) {

                Incidencia incidencia = new Incidencia(cursor.getString(1),cursor.getString(2),cursor.getString(4));
                incidencia.setFecha(cursor.getLong(3));
                listIncidencies.add(incidencia);
                //

            }
        }

        cursor.close();
        return listIncidencies;
    }

    public void eliminarIncidencias(SQLiteDatabase db, SQLiteOpenHelper helper) {
        db = helper.getWritableDatabase();
        db.delete(IncidenciaEntry.TABLE_NAME,null,null);
    }


}
