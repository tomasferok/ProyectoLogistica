package com.log.app.entidades;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "espacios")
public class Espacio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEsp;
	private String nomEspacio;
	private double capacidad;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Producto> productos;
	private String estadoProducto;
	
}
