package com.log.app.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recepciones")
public class Recepcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcion;
    @Column(name = "fecha_recepcion")
    private String fechaRecepcion;
    @ManyToOne
    private Provedor provedor;
    @OneToMany
    private List<RecepcionProducto> productos;

    @OneToMany
    private List<EstadoRecepcion> estadoRecepcion;
}
