package com.example.giusseppe.controldeactivos.Bean;

import java.io.Serializable;

/**
 * Created by Giusseppe on 03/07/2017.
 */

public class GruposBean implements Serializable {
    private int codigoGrupo;
    private String descripcionGrupo;

    public String toString(){
        return descripcionGrupo;
    }

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getDescripcionGrupo() {
        return descripcionGrupo;
    }

    public void setDescripcionGrupo(String descripcionGrupo) {
        this.descripcionGrupo = descripcionGrupo;
    }
}
