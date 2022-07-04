package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Entidad TipoProducto
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "tipo_productos")
@Data

public class TipoProducto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoProd;
	private int codigoDeBarras;
	private String nombre;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subCategoria_id")
	private SubCategoria subCat;
	private String descripcion;
	private double precio;
	private double neto;

	@ManyToOne(cascade = CascadeType.ALL)

	@JoinColumn(name = "id_prov")
	private Proveedor provedor;

}
