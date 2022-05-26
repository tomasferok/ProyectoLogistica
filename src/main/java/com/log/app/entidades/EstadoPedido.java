package com.log.app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado_pedido")
public class EstadoPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoPedido;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
	private Date fechaPedido;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Usuario usuarios;
	
	
	private EstadoPedido estadosPedidosAnteriores;

	
	public EstadoPedido() {
		this.pedidos= new ArrayList<Pedido>();
	}

	public Long getIdEstadoPedido() {
		return idEstadoPedido;
	}

	public void setIdEstadoPedido(Long idEstadoPedido) {
		this.idEstadoPedido = idEstadoPedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public EstadoPedido getEstadosPedidosAnteriores() {
		return estadosPedidosAnteriores;
	}

	public void setEstadosPedidosAnteriores(EstadoPedido estadosPedidosAnteriores) {
		this.estadosPedidosAnteriores = estadosPedidosAnteriores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void add(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
    
}
