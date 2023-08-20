package com.a2valdez.tradulate;

import java.io.Serializable;

public class Palabra implements Serializable {

    private String castellano;

    private String ingles;

    private int foto;

    public Palabra(String castellano, String ingles, int foto) {
        this.castellano = castellano;
        this.ingles = ingles;
        this.foto = foto;
    }

    public String getCastellano() {
        return castellano;
    }

    public void setCastellano(String castellano) {
        this.castellano = castellano;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
