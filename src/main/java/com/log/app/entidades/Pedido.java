package com.log.app.entidades;

import lombok.Data;

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
@Data
@Table(name = "pedidos")
public class Pedido implements Serializable {

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
	private List<PedidoProducto> productos;

}
