package com.log.app.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity(name = "recepciones_producto")
public class RecepcionProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcionProducto;

    @ManyToOne
    private Recepcion recepcion;
    @ManyToOne
    private Producto producto;
    @Column(name = "cantidad")
    Double cantidad;
}
