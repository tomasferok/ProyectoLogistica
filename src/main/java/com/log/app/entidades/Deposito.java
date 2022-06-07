package com.log.app.entidades;

import lombok.Data;

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
@Data
@Table(name = "depositos")
public class Deposito implements Serializable {

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

	
	
	

}
