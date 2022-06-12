package com.log.app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "pedidos")
@Data

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

}
