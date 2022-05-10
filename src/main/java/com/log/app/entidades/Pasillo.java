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
@Table(name = "pasillos")
public class Pasillo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPasillo;
	private String nomPasillo;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Deposito deposito;

	public Long getIdPasillo() {
		return idPasillo;
	}

	public void setIdPasillo(Long idPasillo) {
		this.idPasillo = idPasillo;
	}

	public String getNomPasillo() {
		return nomPasillo;
	}

	public void setNomPasillo(String nomPasillo) {
		this.nomPasillo = nomPasillo;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	
	
}
