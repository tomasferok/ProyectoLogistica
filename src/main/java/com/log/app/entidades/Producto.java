package com.log.app.entidades;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProd;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tipoProd_id")
	private TipoProducto tipoProducto;

	private double cantidadDisponible;

	private double cantidadReservada;


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

	public Producto() {
	}

	public Producto(TipoProducto tipoProducto, double cantidadDisponible, double cantidadReservada) {
		this.tipoProducto = tipoProducto;
		this.cantidadDisponible = cantidadDisponible;
		this.cantidadReservada = cantidadReservada;
	}

	

	
}
