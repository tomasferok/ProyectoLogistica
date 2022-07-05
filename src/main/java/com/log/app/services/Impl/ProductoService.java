package com.log.app.services.Impl;

import com.log.app.daos.IProductoDao;
import com.log.app.entidades.Producto;
import com.log.app.services.Interfaces.IProductoService;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio de la entidad Producto
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
public class ProductoService implements IProductoService {

    @Autowired
    IProductoDao productoDao;

    
    /** 
     * @param producto
     * @return Producto
     */
    public Producto saveEmpyProducto(Producto producto) {
        
        producto.setCantidadDisponible(0);
        producto.setCantidadEnCuarentena(0);
        producto.setCantidadReservada(0);
        return productoDao.save(producto);

    }

    
    /** 
     * @param producto
     * @return Producto
     */
    public Producto save(Producto producto) {
        return productoDao.save(producto);

    }

    
    /** 
     * @return Iterable<Producto>
     */
    public Iterable<Producto> findProductosDisponibles() {
        return productoDao.findByCantidadDisponibleGreaterThan(0);
    }

    
    /** 
     * @return Iterable<Producto>
     */
    public Iterable<Producto> findAll() {
        return productoDao.findAll();
    }

    
    /** 
     * @param id
     * @return Producto
     */
    public Producto findById(Long id) {
        return productoDao.findById(id).get();
    }

    
    /** 
     * @param id
     */
    public void delete(Long id) {
        productoDao.deleteById(id);
    }

    
    /** 
     * @param producto
     */
    public void update(Producto producto) {
        productoDao.save(producto);
    }

    
    /** 
     * @param id
     * @param cantidad
     */
    public void updateCantidadDisponible(Long id, int cantidad) {
        Producto producto = productoDao.findById(id).get();
        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidad);
        productoDao.save(producto);
    }

    
    /** 
     * @param id
     * @param cantidad
     */
    public void updateCantidadEnCuarentena(Long id, int cantidad) {
        Producto producto = productoDao.findById(id).get();
        producto.setCantidadEnCuarentena(producto.getCantidadEnCuarentena() + cantidad);
        productoDao.save(producto);
    }

    
    /** 
     * @param id
     * @param cantidad
     */
    public void updateCantidadReservada(Long id, int cantidad) {
        Producto producto = productoDao.findById(id).get();
        producto.setCantidadReservada(producto.getCantidadReservada() + cantidad);
        productoDao.save(producto);
    }

    
    /** 
     * @param nombre
     * @return List<Producto>
     */
    public List<Producto> findByNombre(String nombre) {
        return productoDao.findByTipoProducto_NombreIgnoreCaseContaining(nombre);
    }
    
    /** 
     * @param codigo
     * @return List<Producto>
     */
    public List<Producto> findByCodigoDeBarras(int codigo) {
        return productoDao.findByTipoProducto_CodigoDeBarras(codigo);
    }


    
    /** 
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteProducto(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }

    
    /** 
     * @return Producto
     */
    @Override
    public Producto getStockProductos() {
        // TODO Auto-generated method stub
        return null;
    }

    
    /** 
     * @param body
     * @return Producto
     * @throws JSONException
     * @throws Exception
     */
    @Override
    public Producto save(String body) throws JSONException, Exception {
        // TODO Auto-generated method stub
        return null;
    }

    
    /** 
     * @param id
     * @param body
     * @return Producto
     * @throws Exception
     */
    @Override
    public Producto updateProducto(Long id, String body) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    
    /** 
     * @param body
     * @return Producto
     * @throws JSONException
     */
    @Override
    public Producto updateStock(String body) throws JSONException {
        // TODO Auto-generated method stub
        return null;
    }

}
