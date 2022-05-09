package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distribuidores")
public class Distribuidor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDistribu;
	
	private String veichulo;
	
	private String matricula;
	
	private String chofer;

	public Long getIdDistribu() {
		return idDistribu;
	}

	public void setIdDistribu(Long idDistribu) {
		this.idDistribu = idDistribu;
	}

	public String getVeichulo() {
		return veichulo;
	}

	public void setVeichulo(String veichulo) {
		this.veichulo = veichulo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getChofer() {
		return chofer;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
