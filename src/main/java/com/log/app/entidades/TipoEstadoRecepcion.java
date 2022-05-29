package com.log.app.entidades;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoEstadoRecepcion {
    PENDIENTE("PENDIENTE"),
    RECIBIDO("RECIBIDO"),
    CANCELADO("CANCELADO");

    private String tipoEstadoRecepcion;

    private TipoEstadoRecepcion(String tipoEstadoRecepcion) {
        this.tipoEstadoRecepcion = tipoEstadoRecepcion;
    }

    @JsonValue
    public String getTipoEstadoRecepcion() {
        return tipoEstadoRecepcion;
    }
}

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name = "tipo_estado_recepcion")
// public class TipoEstadoRecepcion {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long idEstadoRecepcion;
// @Column(name = "nombre")
// private String nombre;
// }
