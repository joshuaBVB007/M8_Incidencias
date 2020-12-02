package com.example.clase_m8.Recursos;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Incidencia {
    public String contenido;
    public String prioridad;
    public String desc;
    public long fecha;


    public Incidencia(String contenido, String prioridad,String desc) {
        this.contenido = contenido;
        this.prioridad =prioridad;
        this.desc=desc;
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
        Date actual_hora=new java.util.Date();
        SimpleDateFormat hora=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String hora_definitiva=hora.format(actual_hora);
        return hora_definitiva;
    }


}
