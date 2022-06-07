package com.log.app.services;

import com.log.app.data.Result;
import com.log.app.entidades.Producto;
import org.codehaus.jettison.json.JSONException;

public interface ProductoService {

    Result save(String body) throws JSONException, Exception;
    Iterable<Producto> findProductosDisponibles();
    Iterable<Producto> findAll();
    void delete(Long id);
    void update(Producto producto);
    Result updateStock(String body) throws JSONException;
    Result getStockProductos();
    Result updateProducto(Long id, String body) throws Exception;
    void deleteProducto(Long id) throws Exception;
}
