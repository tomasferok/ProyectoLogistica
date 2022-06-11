package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "depositos")
public class Deposito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPasillo;
	private String nomDeposito;
	private String direccion;
	private double cantidadOcup;
	private double cantidadTotal;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Empresa empresa;
	public Long getIdPasillo() {
		return idPasillo;
	}
	public void setIdPasillo(Long idPasillo) {
		this.idPasillo = idPasillo;
	}
	public String getNomDeposito() {
		return nomDeposito;
	}
	public void setNomDeposito(String nomDeposito) {
		this.nomDeposito = nomDeposito;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getCantidadOcup() {
		return cantidadOcup;
	}
	public void setCantidadOcup(double cantidadOcup) {
		this.cantidadOcup = cantidadOcup;
	}
	public double getCantidadTotal() {
		return cantidadTotal;
	}
	public void setCantidadTotal(double cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
