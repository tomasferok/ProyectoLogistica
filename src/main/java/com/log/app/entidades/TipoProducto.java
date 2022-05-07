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
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
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
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria_id")
	private List<Categoria> categorias;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "subCategoria_id")
	private List<SubCategoria> subCats;
	private String descripcion;
	private double precio;
	private double neto;
	
	

	public TipoProducto() {
		this.categorias = new ArrayList<Categoria>();
		this.subCats = new ArrayList<SubCategoria>();
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<SubCategoria> getSubCats() {
		return subCats;
	}

	public void setSubCats(List<SubCategoria> subCats) {
		this.subCats = subCats;
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
public void addCategorias(Categoria categoria) {
	this.categorias.add(categoria);
}

public void addSubCats(SubCategoria subCat) {
	this.subCats.add(subCat);
}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
