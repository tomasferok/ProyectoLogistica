package com.log.app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Entidad EspacioPedido
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "estado_pedido")
@Data

public class EstadoPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstadoPedido;

	@Column(nullable = false)
	private Date fecha;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(nullable = false)
	private Usuario usuario;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoEstadoPedido tipoEstadoPedido;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_pedido")
	@JsonIgnore
	Pedido pedido;

}
