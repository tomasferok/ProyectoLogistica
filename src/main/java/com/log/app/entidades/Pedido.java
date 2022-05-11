package com.log.app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "pedidos")
public class Pedido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Cliente cliente;
	private String direccion;
	private double total;
	private double duracionEstimada;
	private double duracionFinal;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Distribuidor distribuidor;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private EstadoPedido estadoPedido;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Producto> productos;
	
	
	public Pedido() {
		this.productos = new ArrayList<Producto>();
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getDuracionEstimada() {
		return duracionEstimada;
	}
	public void setDuracionEstimada(double duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}
	public double getDuracionFinal() {
		return duracionFinal;
	}
	public void setDuracionFinal(double duracionFinal) {
		this.duracionFinal = duracionFinal;
	}
	public Distribuidor getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}
	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void add(Producto producto) {
		productos.add(producto);
	}
}
