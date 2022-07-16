package com.log.app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

/**
 * Entidad Pedido
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
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
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = false)
	private Cliente cliente;
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
	private double total;
	private Long duracionEstimada;
	private Long duracionFinal;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Distribuidor distribuidor;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pedido")
	private List<EstadoPedido> estadoPedido;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pedido")
	private List<PedidoProducto> productos;
	@Column(nullable = false)
	private Date fechaPedido;

}
