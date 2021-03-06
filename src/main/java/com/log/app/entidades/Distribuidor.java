package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad distribuidor
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "distribuidores")
@Data
public class Distribuidor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDistribu;
	@Column(nullable = false)

	private String vehiculo;
	@Column(nullable = false)
	private String matricula;
	@Column(nullable = false, unique = true, length = 32)
	private String chofer;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
}
