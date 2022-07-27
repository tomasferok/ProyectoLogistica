package com.log.app.services.Impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.log.app.daos.IProductoDao;
import com.log.app.daos.IRecepcionDao;
import com.log.app.data.ReporteProductosInterface;
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
import com.log.app.services.Interfaces.IRecepcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio de la entidad Recepcion
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
public class RecepcionService implements IRecepcionService {
    @Autowired
    IRecepcionDao recepcionDao;

    @Autowired
    UserService userService;

    @Autowired
    IProductoDao productoDao;

    
    /** 
     * @return Iterable<Recepcion>
     */
    public Iterable<Recepcion> findAll() {
        return recepcionDao.findAll();
    }

    
    /** 
     * @param recepcion
     * @return Recepcion
     */
    public Recepcion save(Recepcion recepcion) {
        recepcion.setFechaRecepcion(new Date());
        try {

            return recepcionDao.save(recepcion);

        } catch (Exception e) {
            // TODO: handle exceptio
            System.out.println(e.getMessage());
            return null;
        }
    }

    
    /** 
     * @param controlarRecepcionRequest
     * @return Recepcion
     * @throws RecepcionConDiferenciasExeption
     */
    @Transactional
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
        // ACTUALIZAMOS EL STOCK DE PRODUCTOS
        productosRecibidos.entrySet().forEach(

                (entry) -> {

                    Producto stockProducto = productoDao
                            .findByTipoProducto_idTipoProd(entry.getKey());
                    double cantidadDisponibleTotal = stockProducto.getCantidadDisponible() + entry.getValue();
                    stockProducto.setCantidadDisponible(cantidadDisponibleTotal);

                    productoDao.save(stockProducto);

                });
        EstadoRecepcion estadoRecepcion = new EstadoRecepcion();
        estadoRecepcion.setFecha(new Date());
        estadoRecepcion.setTipoEstado(tipoEstadoRecepcion);
        estadoRecepcion.setUsuario(usuario);

        // TODO: VERIFICAR
        recepcion.getEstadoRecepcion().add(estadoRecepcion);
        return recepcionDao.save(recepcion);
    }

    
    /** 
     * @return long
     */
    public long count() {
        return recepcionDao.count();
    }

    
    /** 
     * @param idRecepcion
     * @param idUsuario
     * @return Recepcion
     */
    public Recepcion cancelarRecepcion(Long idRecepcion, Long idUsuario) {
        // TODO: AGREGAR MOTIVO EN LA CANCELACION, EL CUAL DEBE VENIR EN EL REQUEST

        Recepcion recepcion = recepcionDao.findById(idRecepcion).get();
        TipoEstadoRecepcion tipoEstadoRecepcion = TipoEstadoRecepcion.CANCELADO;
        Usuario usuario = userService.findById(idUsuario);
        EstadoRecepcion estadoRecepcion = new EstadoRecepcion();
        estadoRecepcion.setFecha(new Date());
        estadoRecepcion.setTipoEstado(tipoEstadoRecepcion);
        estadoRecepcion.setUsuario(usuario);
        recepcion.getEstadoRecepcion().add(estadoRecepcion);
        return recepcionDao.save(recepcion);
    }

    
    /** 
     * @param id
     * @return Recepcion
     */
    public Recepcion findById(Long id) {
        return recepcionDao.findById(id).get();
    }

    
    /** 
     * @param year
     * @return List<ReporteProductos>
     */
    public List<ReporteProductosInterface> reporteProductosPedidosAnual(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 0, 01);
        Date startDate = calendar.getTime();
        calendar.set(year, 11, 31);
        Date endDate = calendar.getTime();
        List<ReporteProductosInterface> reporteProductos = recepcionDao.sumProductosSolicitadosByMonthBetweenFechas(startDate,
                endDate);
        return reporteProductos;
    }

    
    /** 
     * @param year
     * @param idProducto
     * @return List<ReporteProductos>
     */
    public List<ReporteProductosInterface> reporteProductoPedidoAnual(int year, long idProducto) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 0, 01);
        Date startDate = calendar.getTime();
        calendar.set(year, 11, 31);
        Date endDate = calendar.getTime();
        List<ReporteProductosInterface> reporteProductos = recepcionDao.sumProductosSolicitadosByMonthBetweenFechasByProducto(
                startDate,
                endDate, idProducto);
        return reporteProductos;
    }

    public void delete(Recepcion recepcion) {
        recepcionDao.delete(recepcion);
    }
}
