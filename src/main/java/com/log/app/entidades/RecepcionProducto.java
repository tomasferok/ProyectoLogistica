package com.log.app.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Entidad RecepcionProducto
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity(name = "recepciones_productos")
@Data

public class RecepcionProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcionProducto;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "id_tipo_producto")

    private TipoProducto producto;

    @Column(name = "cantidad", nullable = false)
    Double cantidad;

    @JoinColumn( name = "id_recepcion")
    @JsonIgnore
    @ManyToOne
    Recepcion recepcion;

}
