package com.log.app.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

/**
 * Entidad EstadoRecpcion
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "estado_recepcion")
@Data

public class EstadoRecepcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoRecepcion;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false)
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEstadoRecepcion tipoEstado;
    @Column(name = "fecha_estado", nullable = false)
    private Date fecha;
    
    

}