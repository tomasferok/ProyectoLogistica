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

import lombok.Data;


@Entity
@Table(name = "recepciones")
@Data

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


    
}