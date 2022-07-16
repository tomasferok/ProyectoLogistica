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

/**
 * Entidad Recepcion
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "recepciones")
@Data

public class Recepcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcion;
    @Column(name = "fecha_recepcion", nullable = false)
    private Date fechaRecepcion;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Proveedor provedor;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_recepcion")
    private List<RecepcionProducto> productos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_recepcion")
    private List<EstadoRecepcion> estadoRecepcion;

}