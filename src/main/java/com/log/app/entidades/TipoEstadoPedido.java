package com.log.app.entidades;


import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumerado Estados de Pedido
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
public enum TipoEstadoPedido {
//PENDIENTE, PREPARADO, CONTROLADO, DESPACHADO, ENTREGADO, CANCELADO

    PENDIENTE("PENDIENTE"),
    PREPARADO("PREPARADO"),
    CONTROLADO("CONTROLADO"),
    DESPACHADO("DESPACHADO"),
    ENTREGADO("ENTREGADO"),
    CANCELADO("CANCELADO"),
    DEVUELTO("DEVUELTO");


    private String tipoEstadoPedido;

    private TipoEstadoPedido(String tipoEstadoPedido) {
        this.tipoEstadoPedido = tipoEstadoPedido;
    }

    @JsonValue
    public String getTipoEstadoPedido() {
        return tipoEstadoPedido;
    }
    }




// package com.log.app.entidades;

// import java.io.Serializable;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name = "tipo_estado_pedidos")
// public class TipoEstadoPedido implements Serializable {
// 	/**
// 	 * 
// 	 */
// 	private static final long serialVersionUID = 1L;
// 	@Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long idTipEstPedido;
//     @Column(name = "nombre")
//     private String nombre;
// 	public Long getIdTipEstPedido() {
// 		return idTipEstPedido;
// 	}
// 	public void setIdTipEstPedido(Long idTipEstPedido) {
// 		this.idTipEstPedido = idTipEstPedido;
// 	}
// 	public String getNombre() {
// 		return nombre;
// 	}
// 	public void setNombre(String nombre) {
// 		this.nombre = nombre;
// 	}
    
    
// }
