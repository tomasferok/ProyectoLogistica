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
@Table(name = "tipo_productos")
public class TipoProducto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoProd;
	private int codigoDeBarras;
	private String nombre;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "subCategoria_id")
	private SubCategoria subCat;
	private String descripcion;
	private double precio;
	private double neto;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SubCategoria getSubCat() {
		return subCat;
	}

	public void setSubCat(SubCategoria subCat) {
		this.subCat = subCat;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getNeto() {
		return neto;
	}

	public void setNeto(double neto) {
		this.neto = neto;
	}

	public Long getIdTipoProd() {
		return idTipoProd;
	}

	public void setIdTipoProd(Long idTipoProd) {
		this.idTipoProd = idTipoProd;
	}

	public int getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(int codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TipoProducto() {

	}

	public TipoProducto(int codigoDeBarras, String nombre, Categoria categoria, SubCategoria subCat,
			String descripcion, double precio, double neto) {
		this.codigoDeBarras = codigoDeBarras;
		this.nombre = nombre;
		this.categoria = categoria;
		this.subCat = subCat;
		this.descripcion = descripcion;
		this.precio = precio;
		this.neto = neto;
	}

	public TipoProducto (Long idTipoProd, int codigoDeBarras, String nombre, Categoria categoria, SubCategoria subCat,
			String descripcion, double precio, double neto) {
		this.idTipoProd = idTipoProd;
		this.codigoDeBarras = codigoDeBarras;
		this.nombre = nombre;
		this.categoria = categoria;
		this.subCat = subCat;
		this.descripcion = descripcion;
		this.precio = precio;
		this.neto = neto;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

}
