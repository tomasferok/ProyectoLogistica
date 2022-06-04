package com.log.app.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "estado_recepcion")
public class EstadoRecepcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoRecepcion;
    
    // @ManyToOne
    // @JsonIgnore
    // private Recepcion recepcion;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoEstadoRecepcion tipoEstado;


    @Column(name = "fecha_estado")
    private Date fecha;
    // @OneToOne
    // private EstadoRecepcion estadoAnterior;
    // public Long getIdEstadoRecepcion() {
    //     return idEstadoRecepcion;
    // }
    public void setIdEstadoRecepcion(Long idEstadoRecepcion) {
        this.idEstadoRecepcion = idEstadoRecepcion;
    }
    // public Recepcion getRecepcion() {
    //     return recepcion;
    // }
    // public void setRecepcion(Recepcion recepcion) {
    //     this.recepcion = recepcion;
    // }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public TipoEstadoRecepcion getTipoEstado() {
        return tipoEstado;
    }
    public void setTipoEstado(TipoEstadoRecepcion tipoEstado) {
        this.tipoEstado = tipoEstado;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    // public EstadoRecepcion getEstadoAnterior() {
    //     return estadoAnterior;
    // }
    // public void setEstadoAnterior(EstadoRecepcion estadoAnterior) {
    //     this.estadoAnterior = estadoAnterior;
    // }
    public EstadoRecepcion(Long idEstadoRecepcion, Usuario usuario, TipoEstadoRecepcion tipoEstado,
            Date fecha) {
        this.idEstadoRecepcion = idEstadoRecepcion;
        // this.recepcion = recepcion;
        this.usuario = usuario;
        this.tipoEstado = tipoEstado;
        this.fecha = fecha;
        // this.estadoAnterior = estadoAnterior;
    }

    public EstadoRecepcion() {
    }

    

}