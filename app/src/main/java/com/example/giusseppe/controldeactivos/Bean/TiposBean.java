package com.example.giusseppe.controldeactivos.Bean;

import java.io.Serializable;

/**
 * Created by Giusseppe on 03/07/2017.
 */

public class TiposBean implements Serializable {
    private int codigoTipo;
    private String descripcionTipo;

    public String toString(){
        return descripcionTipo;
    }

    public int getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(int codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
}
