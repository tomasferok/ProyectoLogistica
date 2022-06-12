package com.log.app.services.Impl;

import com.log.app.daos.IProductoDao;
import com.log.app.entidades.Producto;
import com.log.app.services.Interfaces.IProductoService;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    IProductoDao productoDao;

    public Producto saveEmpyProducto(Producto producto) {
        
        producto.setCantidadDisponible(0);
        producto.setCantidadEnCuarentena(0);
        producto.setCantidadReservada(0);
        return productoDao.save(producto);

    }

    public Producto save(Producto producto) {
        return productoDao.save(producto);

    }

    public Iterable<Producto> findProductosDisponibles() {
        return productoDao.findByCantidadDisponibleGreaterThan(0);
    }

    public Iterable<Producto> findAll() {
        return productoDao.findAll();
    }

    public Producto findById(Long id) {
        return productoDao.findById(id).get();
    }

    public void delete(Long id) {
        productoDao.deleteById(id);
    }

    public void update(Producto producto) {
        productoDao.save(producto);
    }

    public void updateCantidadDisponible(Long id, int cantidad) {
        Producto producto = productoDao.findById(id).get();
        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidad);
        productoDao.save(producto);
    }

    public void updateCantidadEnCuarentena(Long id, int cantidad) {
        Producto producto = productoDao.findById(id).get();
        producto.setCantidadEnCuarentena(producto.getCantidadEnCuarentena() + cantidad);
        productoDao.save(producto);
    }

    public void updateCantidadReservada(Long id, int cantidad) {
        Producto producto = productoDao.findById(id).get();
        producto.setCantidadReservada(producto.getCantidadReservada() + cantidad);
        productoDao.save(producto);
    }

    public List<Producto> findByNombre(String nombre) {
        return productoDao.findByTipoProducto_NombreIgnoreCaseContaining(nombre);
    }

    @Override
    public void deleteProducto(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Producto getStockProductos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Producto save(String body) throws JSONException, Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Producto updateProducto(Long id, String body) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Producto updateStock(String body) throws JSONException {
        // TODO Auto-generated method stub
        return null;
    }

}
