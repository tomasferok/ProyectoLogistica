package com.log.app.data;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public interface ReporteProductos {
    int getYear();

    int getMes();

    // String getNombre();

    // int getIdTipoProd();

    double getCantidad();
}
