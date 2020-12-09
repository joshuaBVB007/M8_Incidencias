package com.example.clase_m8.Recursos;

import android.text.format.DateFormat;
import android.util.Log;

import com.example.clase_m8.Vista_Enfocada;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Incidencia {
    public String contenido;
    public String prioridad;
    public String desc;
    public long fecha;
    public int estado;
    public int id;
    public static int idsiguiente=1;
    public String detalle;

    /*
    1-pueda que el idsiguiente sea el problema
    2-que el metodo update sume las keys

     */


    public Incidencia(String contenido, String prioridad,String desc) {
        this.contenido = contenido;
        this.prioridad =prioridad;
        this.desc=desc;
        this.id=idsiguiente;
        idsiguiente++;
    }

    public String getId() {

        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public String dimeFecha(){//ESTE METODO LO USAMOS EN EL RECYCLER_ADAPTER
        Long fecha = this.getFecha()*1000;
        Log.i("test", "" + fecha);

        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String hora_definitiva=format.format(fecha);

        String dateString = DateFormat.format("MM/dd/yyyy HH:mm:ss", new Date(fecha)).toString();

        return dateString;
    }


    public String getEstado() {
        String dato=String.valueOf(estado);
        return dato;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    public String getDetalle() {
        return "Detalles";
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }


}
