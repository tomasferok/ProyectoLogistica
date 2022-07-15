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
 * Entidad Cliente
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "clientes")
@Data

public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	@Column(nullable = false, unique = true)

	private String nombre;
	@Column(nullable = false, unique = true)

	private String razonSocial;
	@Column(nullable = false, unique = true)

	private String documento;
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)

	private String ciudad;
	@Column(nullable = false, unique = true)

	private String email;
	@Column(nullable = false)

	private String telefono;

	private static final long serialVersionUID = 1L;

}
