package com.log.app.entidades;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Entidad Pasillo
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "pasillos")
@Data

public class Pasillo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPasillo;
	@Column(nullable = false)

	private String nomPasillo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_deposito", nullable = false)
	@JsonIgnore
	private Deposito deposito;
	
	@OneToMany(mappedBy="pasillo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Espacio> espacio;
}
