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

import lombok.Data;

@Entity(name = "recepciones_productos")
@Data

public class RecepcionProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcionProducto;

    @ManyToOne()
    @JoinColumn(nullable = false)

    private TipoProducto producto;

    @Column(name = "cantidad")
    Double cantidad;

}
