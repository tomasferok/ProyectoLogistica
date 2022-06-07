package com.log.app.entidades;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
@Table(name = "sub_categorias")
public class SubCategoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSubCat;
	
	private String nombre;

}
