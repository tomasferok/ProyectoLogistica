package com.log.app.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estado_pedido")
public class EstadoPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoPedido;
	

	
	private Date fecha;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Usuario usuario;
	


	@Enumerated(EnumType.STRING)

	private TipoEstadoPedido tipoEstadoPedido;

	
	
	public TipoEstadoPedido getTipoEstadoPedido() {
		return tipoEstadoPedido;
	}

	public void setTipoEstadoPedido(TipoEstadoPedido tipoEstadoPedido) {
		this.tipoEstadoPedido = tipoEstadoPedido;
	}

	public EstadoPedido() {
	}

	public Long getIdEstadoPedido() {
		return idEstadoPedido;
	}

	public void setIdEstadoPedido(Long idEstadoPedido) {
		this.idEstadoPedido = idEstadoPedido;
	}

	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
    
}
