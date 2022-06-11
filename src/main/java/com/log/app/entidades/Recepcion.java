package com.log.app.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "recepciones")
public class Recepcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcion;
    @Column(name = "fecha_recepcion")
    private Date fechaRecepcion;
    @ManyToOne
    private Proveedor provedor;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recepcion_id_recepcion")
    private List<RecepcionProducto> productos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EstadoRecepcion> estadoRecepcion;

    public Recepcion() {
    }

    public Recepcion(Date fechaRecepcion, Proveedor provedor, List<RecepcionProducto> productos, List<EstadoRecepcion> estadoRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
        this.provedor = provedor;
        this.productos = productos;
        this.estadoRecepcion = estadoRecepcion;
    }

    public Long getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(Long idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Proveedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Proveedor provedor) {
        this.provedor = provedor;
    }

    public List<RecepcionProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<RecepcionProducto> productos) {
        this.productos = productos;
    }

    public List<EstadoRecepcion> getEstadoRecepcion() {
        return estadoRecepcion;
    }

    public void setEstadoRecepcion(List<EstadoRecepcion> estadoRecepcion) {
        this.estadoRecepcion = estadoRecepcion;
    }

    
    public void addEstadoRecepcion(EstadoRecepcion estadoRecepcion) {
        this.estadoRecepcion.add(estadoRecepcion);
    }

}