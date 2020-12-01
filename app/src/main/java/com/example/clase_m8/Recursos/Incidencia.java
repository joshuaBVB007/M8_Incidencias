package com.example.clase_m8.Recursos;

public class Incidencia {
    public String contenido;
    public String nivel_peligro;


    public Incidencia(String contenido,String nivel_peligro) {
        this.contenido = contenido;
        this.nivel_peligro=nivel_peligro;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNivel_peligro() {
        return nivel_peligro;
    }

    public void setNivel_peligro(String nivel_peligro) {
        this.nivel_peligro = nivel_peligro;
    }

}
