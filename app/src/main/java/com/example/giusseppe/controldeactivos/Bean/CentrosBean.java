package com.example.giusseppe.controldeactivos.Bean;

import java.io.Serializable;

/**
 * Created by Giusseppe on 03/07/2017.
 */

public class CentrosBean implements Serializable {
    private int codigoCentro;
    private String descripcionCentro;

    public String toString(){
        return descripcionCentro;
    }

    public int getCodigoCentro() {
        return codigoCentro;
    }

    public void setCodigoCentro(int codigoCentro) {
        this.codigoCentro = codigoCentro;
    }

    public String getDescripcionCentro() {
        return descripcionCentro;
    }

    public void setDescripcionCentro(String descripcionCentro) {
        this.descripcionCentro = descripcionCentro;
    }
}
