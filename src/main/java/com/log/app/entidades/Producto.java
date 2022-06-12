package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * Esta clase define la entidad Producto.
 * La misma guarda la cantidad y estado de los productos en el stock
 * 
 * @author: ClawTech Team
 * 
 * 
 * 
 */

@Entity
@Table(name = "productos")
@Data
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProd;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "tipoProd_id")

	private TipoProducto tipoProducto;

	@Column(name = "cantidad_disponible")
	private double cantidadDisponible;
	@Column(name = "cantidad_reservada")
	private double cantidadReservada;
	@Column(name = "cantidad_cuarentena")
	private double cantidadEnCuarentena;

	private static final long serialVersionUID = 1L;

}
