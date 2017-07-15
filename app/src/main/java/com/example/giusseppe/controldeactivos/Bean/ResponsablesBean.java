package com.example.giusseppe.controldeactivos.Bean;

import java.io.Serializable;

/**
 * Created by Giusseppe on 03/07/2017.
 */

public class ResponsablesBean implements Serializable {
    private int codigoResponsable;
    private String nombreResponsable;
    private String usuarioResponsable;
    private String password;
    private String email;

    public String toString(){
        return nombreResponsable;
    }

    public int getCodigoResponsable() {
        return codigoResponsable;
    }

    public void setCodigoResponsable(int codigoResponsable) {
        this.codigoResponsable = codigoResponsable;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(String usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
