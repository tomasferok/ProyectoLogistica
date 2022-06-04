package com.log.app.entidades;

import com.fasterxml.jackson.annotation.JsonValue;

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
