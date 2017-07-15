package com.example.giusseppe.controldeactivos.Bean;

import java.io.Serializable;

/**
 * Created by Giusseppe on 03/07/2017.
 */

public class ActivosBean implements Serializable{
    private int codigoActivo;
    private int codigoCentro;
    private int codigoGrupo;
    private int codigoUbicacion;
    private int codigoTipo;
    private int codigoResponsable;
    private int vidaUtil;
    private String descripcionActivo;
    private String modeloActivo;
    private String serieActivo;
    private String placaActivo;
    private double valorCompra;

    public int getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(int codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public int getCodigoCentro() {
        return codigoCentro;
    }

    public void setCodigoCentro(int codigoCentro) {
        this.codigoCentro = codigoCentro;
    }

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public int getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(int codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public int getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(int codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public int getCodigoResponsable() {
        return codigoResponsable;
    }

    public void setCodigoResponsable(int codigoResponsable) {
        this.codigoResponsable = codigoResponsable;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getDescripcionActivo() {
        return descripcionActivo;
    }

    public void setDescripcionActivo(String descripcionActivo) {
        this.descripcionActivo = descripcionActivo;
    }

    public String getModeloActivo() {
        return modeloActivo;
    }

    public void setModeloActivo(String modeloActivo) {
        this.modeloActivo = modeloActivo;
    }

    public String getSerieActivo() {
        return serieActivo;
    }

    public void setSerieActivo(String serieActivo) {
        this.serieActivo = serieActivo;
    }

    public String getPlacaActivo() {
        return placaActivo;
    }

    public void setPlacaActivo(String placaActivo) {
        this.placaActivo = placaActivo;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
}
