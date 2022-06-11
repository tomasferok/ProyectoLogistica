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

@Entity
@Table(name = "pedidos_producto")
public class PedidoProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoProducto;

    @ManyToOne()
    @JoinColumn(nullable = false)

    private TipoProducto producto;

    @Column(name = "cantidad")
    Double cantidad;

    public Long getIdPedidoProducto() {
        return idPedidoProducto;
    }

    public void setIdPedidoProducto(Long idPedidoProducto) {
        this.idPedidoProducto = idPedidoProducto;
    }

    public TipoProducto getProducto() {
        return producto;
    }

    public void setProducto(TipoProducto producto) {
        this.producto = producto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public PedidoProducto(Long idPedidoProducto, TipoProducto producto, Double cantidad) {
        this.idPedidoProducto = idPedidoProducto;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public PedidoProducto() {
    }

}
