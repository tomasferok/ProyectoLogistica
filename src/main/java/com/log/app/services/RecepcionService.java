package com.log.app.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.log.app.daos.IProductoDao;
import com.log.app.daos.IRecepcionDao;
import com.log.app.entidades.EstadoRecepcion;
import com.log.app.entidades.Producto;
import com.log.app.entidades.Recepcion;
import com.log.app.entidades.RecepcionProducto;
import com.log.app.entidades.TipoEstadoRecepcion;
import com.log.app.entidades.TipoProducto;
import com.log.app.entidades.Usuario;
import com.log.app.exepciones.RecepcionConDiferenciasExeption;
import com.log.app.helpers.CancelarRecepcionRequest;
import com.log.app.helpers.ControlarRecepcionRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecepcionService {
    @Autowired
    IRecepcionDao recepcionDao;

    @Autowired
    UserService userService;

    @Autowired
    IProductoDao productoDao;

    public Iterable<Recepcion> findAll() {
        return recepcionDao.findAll();
    }

    public Recepcion save(Recepcion recepcion) {

        try {
            return recepcionDao.save(recepcion);

        } catch (Exception e) {
            // TODO: handle exceptio
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Recepcion recibirRecepcion(
            ControlarRecepcionRequest controlarRecepcionRequest) throws RecepcionConDiferenciasExeption {
        TipoEstadoRecepcion tipoEstadoRecepcion = TipoEstadoRecepcion.RECIBIDO;
        Usuario usuario = userService.findById(controlarRecepcionRequest.getIdUsuario());
        Recepcion recepcion = recepcionDao.findById(controlarRecepcionRequest.getIdRecepcion()).get();

        Map<Long, Double> productosRecibidos = controlarRecepcionRequest.getProductosRecibidos();
        List<Double> cantidadesEsperadas = new ArrayList<>();
        recepcion.getProductos().forEach(x -> {
            cantidadesEsperadas.add(x.getCantidad());

        });

        boolean existenDiferencias = !cantidadesEsperadas.containsAll(
                productosRecibidos.values());

        if (existenDiferencias && controlarRecepcionRequest.getControlarDiferencias()) {
            throw new RecepcionConDiferenciasExeption(
                    "La recepcion contiene diferencias. Modifica los datos o haz click en aceptar con diferencias");
        }

        productosRecibidos.entrySet().forEach(

                (entry) -> {

                    Producto stockProducto = productoDao
                            .findByTipoProducto_idTipoProd(entry.getKey());
                    double cantidadDisponibleTotal = stockProducto.getCantidadDisponible() + entry.getValue();
                    stockProducto.setCantidadDisponible(cantidadDisponibleTotal);

                    productoDao.save(stockProducto);

                });
        EstadoRecepcion estadoRecepcion = new EstadoRecepcion(null, usuario, tipoEstadoRecepcion, new Date());
        recepcion.addEstadoRecepcion(estadoRecepcion);
        return recepcionDao.save(recepcion);
    }

    public long count() {
        return recepcionDao.count();
    }

  

    public Recepcion cancelarRecepcion(CancelarRecepcionRequest cancelarRecepcionRequest) {
        // TODO: AGREGAR MOTIVO EN LA CANCELACION, EL CUAL DEBE VENIR EN EL REQUEST

        Recepcion recepcion = recepcionDao.findById(cancelarRecepcionRequest.getIdRecepcion()).get();
        TipoEstadoRecepcion tipoEstadoRecepcion = TipoEstadoRecepcion.CANCELADO;
        Usuario usuario = userService.findById(cancelarRecepcionRequest.getIdUsuario());
        EstadoRecepcion estadoRecepcion = new EstadoRecepcion(null, usuario, tipoEstadoRecepcion, new Date());
        recepcion.addEstadoRecepcion(estadoRecepcion);
        return recepcionDao.save(recepcion);
    }

    public Recepcion findById(Long id) {
        return recepcionDao.findById(id).get();
    }

}
