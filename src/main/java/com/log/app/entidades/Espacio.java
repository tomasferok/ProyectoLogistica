package com.log.app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Entidad Espacio
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "espacios")
@Data

public class Espacio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEsp;
	private String nomEspacio;
	@ManyToMany(fetch = FetchType.EAGER)	
	@JoinTable(name = "espacios_productos", joinColumns = @JoinColumn(name = "id_tipo_producto"), inverseJoinColumns = @JoinColumn(name = "id_espacio"))
	private List<TipoProducto> productos;
	@ManyToOne()
	@JoinColumn(name = "id_pasillo")
	@JsonIgnore
	private Pasillo pasillo;
}
