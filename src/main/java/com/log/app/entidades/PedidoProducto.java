package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Entidad PedidoProducto
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "pedidos_producto")
@Data

public class PedidoProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoProducto;

    @ManyToOne()
    @JoinColumn(nullable = false, name = "id_tipo_producto")
    private TipoProducto producto;
    @Column(name = "cantidad", nullable = false)
    Double cantidad;
    @ManyToOne()
    @JsonIgnore
    @JoinColumn( name = "id_pedido")
    Pedido pedido;
}
