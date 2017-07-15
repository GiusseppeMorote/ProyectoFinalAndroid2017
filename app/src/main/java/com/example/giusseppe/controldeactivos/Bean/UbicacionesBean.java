package com.example.giusseppe.controldeactivos.Bean;

import java.io.Serializable;

/**
 * Created by Giusseppe on 03/07/2017.
 */

public class UbicacionesBean implements Serializable{
    private int codigoUbicacion;
    private String descripcionUbicacion;

    public String toString(){
        return  descripcionUbicacion;
    }

    public int getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(int codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public String getDescripcionUbicacion() {
        return descripcionUbicacion;
    }

    public void setDescripcionUbicacion(String descripcionUbicacion) {
        this.descripcionUbicacion = descripcionUbicacion;
    }
}
