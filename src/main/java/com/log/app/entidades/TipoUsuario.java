package com.log.app.entidades;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumerado TipoUsuario
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
public enum TipoUsuario {
    ADMIN("ADMIN"), USUARIO("USUARIO");

    private String tipoUsuario;

    private TipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @JsonValue
    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
