package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProd;

	private String descripcion;

	private String unidad;

	private float neto;

	private Long codProv;
	private String proveedor;

	
	private String familia;

	private String subfamilia;

	private Long CBunidad;

	private static final long serialVersionUID = 1L;

	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public float getNeto() {
		return neto;
	}

	public void setNeto(float neto) {
		this.neto = neto;
	}

	public Long getCodProv() {
		return codProv;
	}

	public void setCodProv(Long codProv) {
		this.codProv = codProv;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getSubfamilia() {
		return subfamilia;
	}

	public void setSubfamilia(String subfamilia) {
		this.subfamilia = subfamilia;
	}

	public Long getCBunidad() {
		return CBunidad;
	}

	public void setCBunidad(Long cBunidad) {
		CBunidad = cBunidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
