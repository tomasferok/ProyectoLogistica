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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "espacios")
public class Espacio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEsp;
	private String nomEspacio;
	private double capacidad;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Producto> productos;
	private String estadoProducto;
	
	
	public Espacio() {
		this.productos = new ArrayList<Producto>();
	}
	public Long getIdEsp() {
		return idEsp;
	}
	public void setIdEsp(Long idEsp) {
		this.idEsp = idEsp;
	}
	public String getNomEspacio() {
		return nomEspacio;
	}
	public void setNomEspacio(String nomEspacio) {
		this.nomEspacio = nomEspacio;
	}
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public String getEstadoProducto() {
		return estadoProducto;
	}
	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void addProductos(Producto producto) {
		this.productos.add(producto);
	}
	
}
