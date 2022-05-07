package com.log.app.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProd;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tipoProd_id")
	private List<TipoProducto> tipoProductos;

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

	

	public List<TipoProducto> getTipoProductos() {
		return tipoProductos;
	}

	public void setTipoProductos(List<TipoProducto> tipoProductos) {
		this.tipoProductos = tipoProductos;
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

	public void addTipoProducto(TipoProducto tipoProd) {
		this.tipoProductos.add(tipoProd);
	}
}
