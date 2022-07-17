package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad Empresa
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "empresas")
@Data

public class Empresa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;
	@Column(nullable = false, unique = true)
	private String nomEmpresa;
	@Column(nullable = false,  unique = true)
	private String contacto;
	@Column(nullable = false, unique = true)
	private int documento;
	@Column(nullable = false,  unique = true)
	private String email;
	
	
	

}
