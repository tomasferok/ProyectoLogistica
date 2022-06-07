package com.log.app.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Data
@Table(name = "tipo_productos")
public class TipoProducto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_producto")
	private Long idTipoProd;

	private String nombre;
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "subCategoria_id")
	private SubCategoria subCat;
	private String descripcion;

	@Column(name = "cantidad_disponible")
	private double cantidadDisponible;
	@Column(name = "cantidad_reservada")
	private double cantidadReservada;
	@Column(name = "cantidad_cuarentena")
	private double cantidadEnCuarentena;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProv")
	private Proveedor provedor;

	@OneToMany(mappedBy = "tipoProducto")
	private Set<Producto> productos;

}
