package com.log.app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Cliente cliente;
	private String direccion;
	private double total;
	private Date duracionEstimada;
	private Date duracionFinal;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Distribuidor distribuidor;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	private List<EstadoPedido> estadoPedido;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PedidoProducto> productos;
	private Date fechaPedido;

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Pedido() {
		this.productos = new ArrayList<PedidoProducto>();
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

	public Date getDuracionEstimada() {
		return duracionEstimada;
	}

	public void setDuracionEstimada(Date duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}

	public Date getDuracionFinal() {
		return duracionFinal;
	}

	public void setDuracionFinal(Date duracionFinal) {
		this.duracionFinal = duracionFinal;
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public List<EstadoPedido> getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(List<EstadoPedido> estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public List<PedidoProducto> getProductos() {
		return productos;
	}

	public void setProductos(List<PedidoProducto> productos) {
		this.productos = productos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addProducto(PedidoProducto producto) {
		productos.add(producto);
	}

	public void addEstado(EstadoPedido estado) {
		estadoPedido.add(estado);
	}

	public Pedido(Long idPedido, Cliente cliente, String direccion, double total,
			Date duracionEstimada,
			Date duracionFinal, Distribuidor distribuidor,
			List<EstadoPedido> estadoPedido, List<PedidoProducto> productos,
			Date fechaPedido) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.direccion = direccion;
		this.total = total;
		this.duracionEstimada = duracionEstimada;
		this.duracionFinal = duracionFinal;
		this.distribuidor = distribuidor;
		this.estadoPedido = estadoPedido;
		this.productos = productos;
		this.fechaPedido = fechaPedido;
	}

}
