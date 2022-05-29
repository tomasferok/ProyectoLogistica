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
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProd;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tipoProd_id")
	private TipoProducto tipoProducto;

	@Column(name = "cantidad_disponible")
	private double cantidadDisponible;
	@Column(name = "cantidad_reservada")
	private double cantidadReservada;
	@Column(name = "cantidad_cuarentena")
	private double cantidadEnCuarentena;

	private static final long serialVersionUID = 1L;

	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(double cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public double getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(double cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}

	

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public double getCantidadEnCuarentena() {
		return cantidadEnCuarentena;
	}

	public void setCantidadEnCuarentena(double cantidadEnCuarentena) {
		this.cantidadEnCuarentena = cantidadEnCuarentena;
	}

	public Producto() {
	}

	public Producto(Long idProd, TipoProducto tipoProducto, double cantidadDisponible, double cantidadReservada,
			double cantidadEnCuarentena) {
		this.idProd = idProd;
		this.tipoProducto = tipoProducto;
		this.cantidadDisponible = cantidadDisponible;
		this.cantidadReservada = cantidadReservada;
		this.cantidadEnCuarentena = cantidadEnCuarentena;
	}

	

}
