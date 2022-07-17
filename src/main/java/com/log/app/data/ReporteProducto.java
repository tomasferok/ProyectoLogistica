package com.log.app.data;

import java.io.Serializable;

public class ReporteProducto implements ReporteProductosInterface, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer year;
    private Integer mes;
    private Double cantidad;

    public ReporteProducto() {

    }

    public ReporteProducto(Integer year, Integer mes, Double cantidad) {
        this.year = year;
        this.mes = mes;
        this.cantidad = cantidad;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ReporteProducto [year=" + year + ", mes=" + mes
                + ", cantidad=" + cantidad + "]";
    }
};
