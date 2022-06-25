package com.log.app.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "espacio_producto")
@Data
public class ProductoEspacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspacioProducto;

    @OneToOne()
    @JoinColumn(nullable = false, name = "id_tipo_producto")

    private TipoProducto producto;

    @Column(name = "cantidad")
    Double cantidad;

    @JoinColumn(name = "id_espacio")
    @JsonIgnore
    @ManyToOne
    Espacio espacio;
}
