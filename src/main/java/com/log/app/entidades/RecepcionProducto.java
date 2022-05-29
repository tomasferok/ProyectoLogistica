package com.log.app.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "recepciones_productos")
public class RecepcionProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcionProducto;

    // @ManyToOne()
    // @JoinColumn(nullable = false)
    // @JsonIgnore
    // private Recepcion recepcion;

    @ManyToOne()
    @JoinColumn(nullable = false)

    private TipoProducto producto;

    @Column(name = "cantidad")
    Double cantidad;

    public RecepcionProducto() {
    }

    public RecepcionProducto(Long idRecepcionProducto,  TipoProducto producto, Double cantidad) {
        this.idRecepcionProducto = idRecepcionProducto;
        // this.recepcion = recepcion;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Long getIdRecepcionProducto() {
        return idRecepcionProducto;
    }

    public void setIdRecepcionProducto(Long idRecepcionProducto) {
        this.idRecepcionProducto = idRecepcionProducto;
    }

    // public Recepcion getRecepcion() {
    //     return recepcion;
    // }

    // public void setRecepcion(Recepcion recepcion) {
    //     this.recepcion = recepcion;
    // }

    public TipoProducto getProducto() {
        return producto;
    }

    public void setProducto(TipoProducto producto) {
        this.producto = producto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

}
