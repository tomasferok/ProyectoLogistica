package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_categorias")
public class SubCategoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSubCat;
	
	private String nombre;

	public Long getIdSubCat() {
		return idSubCat;
	}

	public void setIdSubCat(Long idSubCat) {
		this.idSubCat = idSubCat;
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

	public SubCategoria(String nombre) {
		this.nombre = nombre;
	}
	public SubCategoria(String nombre, Long idSubCat) {
		this.nombre = nombre;
		this.idSubCat = idSubCat;

	}
	public SubCategoria() {
	}
	
}
