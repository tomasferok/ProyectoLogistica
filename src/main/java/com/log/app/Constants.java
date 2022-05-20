package com.log.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.log.app.entidades.Categoria;
import com.log.app.entidades.Producto;
import com.log.app.entidades.SubCategoria;
import com.log.app.entidades.TipoProducto;

public class Constants {

        public static Categoria categoriaComida = new Categoria("Comida", 1l);
        public static SubCategoria subCategoriaComida = new SubCategoria("Comida", 1l);
        public static TipoProducto tipoProducto = new TipoProducto(1l, 123, "TipoProducto", categoriaComida,
                        subCategoriaComida,
                        "Descripcion", 124.0, 1.0);

        public static Producto producto = new Producto(1l, tipoProducto, 124.0, 1.0);

        public static List<TipoProducto> tiposProductos = new ArrayList<TipoProducto>(Arrays.asList(
                        tipoProducto, tipoProducto, tipoProducto));

        public static List<String> listaEstadosProducto = new ArrayList<String>(Arrays.asList("Disponible",
                        "Reservado", "No Disponible"));

}
