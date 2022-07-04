package com.log.app.helpers;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa el reporte de productos mas vendidos
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */

public interface ReporteProductosMasVendidos {


     String getNombre();

     int getIdTipoProd();

    double getCantidad();
    
}
