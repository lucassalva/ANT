package com.app.usuario.pesca;

import java.io.Serializable;

public class PezModel implements Serializable{

    String nombre, epoca, carnada, lugar;
    Integer peso, id;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre()

    {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEpoca() {
        return epoca;
    }

    public void setEpoca(String epoca) {
        this.epoca = epoca;
    }

    public String getCarnada() {
        return carnada;
    }

    public void setCarnada(String carnada) {
        this.carnada = carnada;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
