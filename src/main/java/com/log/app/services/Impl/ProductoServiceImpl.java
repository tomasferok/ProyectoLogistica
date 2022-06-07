package com.log.app.services.Impl;

import com.log.app.Constants;
import com.log.app.daos.IProductoDao;
import com.log.app.daos.ITipoProductoDao;
import com.log.app.data.Result;
import com.log.app.entidades.Producto;

import com.log.app.entidades.TipoProducto;
import com.log.app.helpers.GlobalExceptionHandler;
import com.log.app.services.ProductoService;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    IProductoDao productoDao;
    @Autowired
    ITipoProductoDao tipoProductoDao;

    public Producto saveEmpyProducto(Producto producto) {
        //producto.setCantidadDisponible(0);
        //producto.setCantidadEnCuarentena(0);
        //producto.setCantidadReservada(0);
        return productoDao.save(producto);

    }

    @Override
    public Result save(String body) throws JSONException, Exception {
        JSONObject object = new JSONObject(body);
        JSONArray array = new JSONArray();
        Producto producto = new Producto();
        if(object.has("precio") && object.get("precio") != null)
            producto.setPrecio(object.getDouble("precio"));
        if(object.has("neto") && object.get("neto") != null)
            producto.setNeto(object.getDouble("neto"));
        if(object.has("codigoDeBarras") && object.get("codigoDeBarras") != null)
            producto.setCodigoDeBarras(object.getString("codigoDeBarras"));
        if(object.has("tipoProducto")){
            array = object.getJSONArray("tipoProducto");
        }
        JSONObject json = new JSONObject(array.getString(0));
        TipoProducto tipoProducto = new TipoProducto();
        if(json.has("id")){
            tipoProducto.setIdTipoProd(json.getLong("id"));
            Optional<TipoProducto> tipo = tipoProductoDao.findById(tipoProducto.getIdTipoProd());
            if(tipo.isPresent()){
                producto.setTipoProducto(tipo.get());
                return new Result(Constants.RESULT_OK,productoDao.save(producto));
            }

            else
                throw new Exception(GlobalExceptionHandler.ERR_TIPO_PRODUCTO_NOT_EXISTS.getError_code());
        }
        else
            throw new Exception(GlobalExceptionHandler.ERR_PARAM_ID_TIPO_PRODUCTO.getError_code());


    }

    @Override
    public Iterable<Producto> findProductosDisponibles() {
        return null;//productoDao.findByCantidadDisponibleGreaterThan(0);
    }

    @Override
    public Iterable<Producto> findAll() {
        return productoDao.findAll();
    }

    public Producto findById(Long id) {
        return productoDao.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    public void update(Producto producto) {
        productoDao.save(producto);
    }

    /*public void updateCantidadDisponible(Long id, int cantidad) {
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
    }*/

    @Override
    public Result updateStock(String body) throws JSONException {
        JSONObject jsonObject = new JSONObject(body);
        JSONArray array = jsonObject.getJSONArray("producto");
        List<Producto> productoList = productoDao.findAllProductos();
        List<Producto> productos = new ArrayList<>();
        for(int i = 0; i<array.length(); i++){
            JSONObject object = new JSONObject(array.getString(i));
            Long idProd = object.getLong("id_producto");
            Optional<Producto> producto = productoList.stream().filter(p -> Objects.equals(p.getIdProd(), idProd)).findFirst();
            if(producto.isPresent()){
               //productos.add(productoDao.updateStockProducto(producto.get().getIdProd(), producto.get().getCantidadDisponible() + object.getDouble("cantidad")));
            }//else
                //productos.add(save(producto.get()));
        }

        return new Result(Constants.RESULT_OK, productos);
    }

    @Override
    public Result getStockProductos() {
        return new Result(Constants.RESULT_OK, productoDao.findAllProductos());
    }

    @Override
    public Result updateProducto(Long id, String body) throws Exception {
        Optional<Producto> producto = productoDao.findById(id);
        if(producto.isPresent()){
            JSONObject object = new JSONObject(body);
            Producto p = new Producto();
            if(object.has("precio") && object.get("precio") != null)
                p.setPrecio(object.getDouble("precio"));
            if(object.has("neto") && object.get("neto") != null)
                p.setNeto(object.getDouble("neto"));
            if(object.has("codigoDeBarras") && object.get("codigoDeBarras") != null)
                p.setCodigoDeBarras(object.getString("codigoDeBarras"));
            p.setTipoProducto(producto.get().getTipoProducto());
            p.setIdProd(producto.get().getIdProd());
            return new Result(Constants.RESULT_OK,productoDao.save(p));
        }else
            throw new Exception(GlobalExceptionHandler.ERR_PRODUCTO_NOT_EXISTS.getError_code());
    }

    @Override
    public void deleteProducto(Long id) throws Exception {
        Optional<Producto> producto = productoDao.findById(id);
        if(producto.isPresent())
            productoDao.delete(producto.get());
        else
            throw new Exception(GlobalExceptionHandler.ERR_PRODUCTO_NOT_EXISTS.getError_code());
    }
}
