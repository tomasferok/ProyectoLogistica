package com.log.app.data;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Interfaz que representa los valores de un reporte de productos
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
public interface ReporteCategorias {
    int getYear();

    int getMes();

    // String getNombre();

    // int getIdTipoProd();

    double getCantidad();
}
