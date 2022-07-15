package com.log.app.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(nullable = false, unique = true)
	private int codigoDeBarras;
	@Column(nullable = false, unique = true)

	private String nombre;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "subCategoria_id")
	private SubCategoria subCat;
	@Column(nullable = false)

	private String descripcion;
	@Column(nullable = false)

	private double precio;
	@Column(nullable = false)

	private double precioDeVenta;
	@Column(nullable = false)

	private double neto;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_prov")
	private Proveedor provedor;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)

	private MetodoPicking metodoPicking;

	private String imageUrl;

}
