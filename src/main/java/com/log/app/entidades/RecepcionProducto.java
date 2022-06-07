package com.log.app.entidades;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name = "recepciones_productos")
public class RecepcionProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcionProducto;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private TipoProducto producto;

    @Column(name = "cantidad")
    private Double cantidad;

}
