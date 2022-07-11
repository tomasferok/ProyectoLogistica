
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
public enum MetodoPicking {
    FIFO("FIFO"), LIFO("LIFO"), FEFO("FEFO"), AZAR("AZAR"),;

    private String metodoPicking;

    private MetodoPicking(String metodoPicking) {
        this.metodoPicking = metodoPicking;
    }

    @JsonValue
    public String getMetodoPicking() {
        return metodoPicking;
    }
}
