package com.log.app.entidades;

import lombok.*;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Esta clase define la entidad Producto.
 * La misma guarda la cantidad y estado de los productos en el stock
 * 
 * @author: ClawTech Team
 * 
 * 
 * 
 */

@Entity
@Data
@Table(name = "productos")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProd;

	@ManyToOne()
	@JoinColumn(name = "id_tipo_producto", nullable = false)
	private TipoProducto tipoProducto;

	@Column(name = "precio")
	private double precio;
	@Column(name = "neto")
	private double neto;
	@Column(name = "codigo_barra")
	private String codigoDeBarras;

	private static final long serialVersionUID = 1L;

}
