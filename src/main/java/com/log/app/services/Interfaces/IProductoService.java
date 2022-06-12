package com.log.app.services.Interfaces;

import com.log.app.data.Result;
import com.log.app.entidades.Producto;

import java.util.List;

import org.codehaus.jettison.json.JSONException;

public interface IProductoService {

    Producto save(String body) throws JSONException, Exception;

    Iterable<Producto> findProductosDisponibles();

    Iterable<Producto> findAll();

    void delete(Long id);

    void update(Producto producto);

    Producto updateStock(String body) throws JSONException;

    Producto getStockProductos();

    Producto updateProducto(Long id, String body) throws Exception;

    void deleteProducto(Long id) throws Exception;

    Producto saveEmpyProducto(Producto producto);

    public List<Producto> findByNombre(String nombre);

    public void updateCantidadReservada(Long id, int cantidad);

    public void updateCantidadEnCuarentena(Long id, int cantidad);

    public void updateCantidadDisponible(Long id, int cantidad);
}
