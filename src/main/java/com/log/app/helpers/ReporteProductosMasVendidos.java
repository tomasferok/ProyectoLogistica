package com.log.app.helpers;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface ReporteProductosMasVendidos {


     String getNombre();

     int getIdTipoProd();

    double getCantidad();
    
}
