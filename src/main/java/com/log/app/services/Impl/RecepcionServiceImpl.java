package com.log.app.services.Impl;

import com.log.app.Constants;
import com.log.app.daos.IRecepcionDao;
import com.log.app.daos.RecepcionProductosRepository;
import com.log.app.data.Result;
import com.log.app.entidades.Recepcion;
import com.log.app.entidades.RecepcionProducto;
import com.log.app.helpers.GlobalExceptionHandler;
import com.log.app.services.RecepcionService;
import com.log.app.services.UserService;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecepcionServiceImpl implements RecepcionService {

    @Autowired
    IRecepcionDao recepcionDao;

    @Autowired
    RecepcionProductosRepository productosRepository;

    @Autowired
    UserService userService;

    @Override
    public Result save(Recepcion recepcion) {
        try {

            return new Result(Constants.RESULT_OK, recepcionDao.save(recepcion));

        } catch (Exception e) {
            //TODO: handle exceptio
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Iterable<Recepcion> findAll() {
        return recepcionDao.findAll();
    }

    @Override
    public Result update(Recepcion recepcion, Long id) throws Exception{
        Optional<Recepcion> recep = recepcionDao.findById(id);
        if(recep.isPresent()){
            if(recepcion.getEstado().equalsIgnoreCase(Constants.PEDIDO_ACTIVADO))
                    recep.get().setEstado(Constants.PEDIDO_ACTIVADO);
            if(recepcion.getEstado().equalsIgnoreCase(Constants.PEDIDO_CANCELADO))
                    recep.get().setEstado(Constants.PEDIDO_CANCELADO);
            return new Result(Constants.RESULT_OK, recepcionDao.save(recep.get()));
        }else{
            throw new Exception(GlobalExceptionHandler.ERR_RECEPCION_NOT_EXISTS.getError_code());
        }
    }

    @Override
    public Result getCodeRecepcion() {
        Integer code = recepcionDao.getCodeRecepcion();
        return new Result(Constants.RESULT_OK, code);
    }

    @Override
    public Result getStatus(String body) throws JSONException, Exception {
        JSONObject jsonObject = new JSONObject(body);
        Optional<Recepcion> recepcion = recepcionDao.findById(jsonObject.getLong("id_recepcion"));
        JSONArray jsonArray = jsonObject.getJSONArray("productos");
        if(recepcion.isPresent()){
            List<RecepcionProducto> listProductos = recepcion.get().getProductos();
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject object = new JSONObject(jsonArray.getString(i));
                Long idProducto = object.getLong("id_producto");
                Optional<RecepcionProducto> producto = listProductos.stream().filter(l -> Objects.equals(l.getProducto().getIdTipoProd(), idProducto)).findFirst();
                if(producto.isPresent()){
                    if(producto.get().getCantidad() != object.getDouble("cantidad"))
                        throw new Exception(GlobalExceptionHandler.ERR_RECEPCION_DIFERENCE.getError_code());
                }
            }
        }
        return new Result(Constants.RESULT_OK, Constants.MERCADERIA_CORRECTA);
    }
}
