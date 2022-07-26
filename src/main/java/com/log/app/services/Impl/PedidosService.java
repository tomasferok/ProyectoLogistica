package com.log.app.services.Impl;

import com.log.app.daos.ICategoriaDao;
import com.log.app.daos.IClienteDao;
import com.log.app.daos.IDistribuidorDao;
import com.log.app.daos.IPedidoDao;
import com.log.app.daos.IProductoDao;
import com.log.app.daos.IUsuarioDao;
import com.log.app.data.ReporteCategorias;
import com.log.app.data.ReporteProductosInterface;
import com.log.app.entidades.*;
import com.log.app.services.Interfaces.IPedidosService;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio de la entidad Pedidos
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
public class PedidosService implements IPedidosService {
    Logger logger = Logger.getLogger("PedidosService Logger");

    @Autowired
    private IPedidoDao pedidosDao;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IDistribuidorDao distribuidorDao;

    @Autowired
    private IProductoDao productoDao;

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private ICategoriaDao categoriaDao;

    // @Autowired
    // private VentasService ventasService;

    /**
     * @param pedido
     * @return Pedido
     */

    @Override
    @Transactional
    public Pedido save(Pedido pedido) {
        try {
            Long idCliente = clienteDao.findByDocumento(pedido.getCliente().getDocumento()).isPresent()
                    ? clienteDao.findByDocumento(pedido.getCliente().getDocumento()).get().getIdCliente()
                    : null;
            pedido.getCliente().setIdCliente(idCliente);
            clienteDao.save(pedido.getCliente());
        
            pedido.getProductos().forEach(producto -> {
                Producto prod = productoDao.findByTipoProducto_idTipoProd(producto.getProducto().getIdTipoProd());
                prod.setCantidadDisponible(prod.getCantidadDisponible() - producto.getCantidad());
                prod.setCantidadReservada(prod.getCantidadReservada() + producto.getCantidad());
                productoDao.save(prod);
            });
            return pedidosDao.save(pedido);
        } catch (Exception e) {
            // TODO: handle exceptio
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @return List<Pedido>
     */

    public List<Pedido> findAll() {
        return pedidosDao.findAll();
    }

    /**
     * @param id
     * @return Pedido
     */

    public Pedido findById(Long id) {
        return pedidosDao.findById(id).get();
    }

    /**
     * @param id
     */

    public void deleteById(Long id) {
        pedidosDao.deleteById(id);
    }

    /**
     * @param pedido
     */

    public void delete(Pedido pedido) {
        pedidosDao.delete(pedido);
    }

    /**
     * @param fecha
     * @return List<Pedido>
     */

    public List<Pedido> findByFecha(Date fecha) {
        return pedidosDao.findByfechaPedido(fecha);
    }

    /**
     * @param idPedido
     * @param idUsuario
     * @return Pedido
     */

    public Pedido cancelarPedido(Long idPedido, Long idUsuario) {
        Pedido pedido = pedidosDao.findById(idPedido).get();
        pedido.getProductos().forEach(producto -> {
            Producto prod = productoDao.findByTipoProducto_idTipoProd(producto.getProducto().getIdTipoProd());
            prod.setCantidadReservada(prod.getCantidadReservada() - producto.getCantidad());
            productoDao.save(prod);
        });
        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE
        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.CANCELADO);

    }

    /**
     * @param idPedido
     * @param idUsuario
     * @return Pedido
     */

    public Pedido prepararPedido(Long idPedido, Long idUsuario) {
        Pedido pedido = pedidosDao.findById(idPedido).get();

        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE
        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.PREPARADO);

    }

    /**
     * @param idPedido
     * @param idUsuario
     * @return Pedido
     */

    public Pedido controlarPedido(Long idPedido, Long idUsuario) {
        Pedido pedido = pedidosDao.findById(idPedido).get();

        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE
        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.CONTROLADO);

    }

    /**
     * @param idPedido
     * @param idUsuario
     * @param idUsuarioDistribuidor
     * @return Pedido
     */

    public Pedido despacharPedido(Long idPedido, Long idUsuario, Long idUsuarioDistribuidor) {
        logger.info("despacharPedido" + idPedido.toString() + idUsuario.toString() + idUsuarioDistribuidor.toString());
        Pedido pedido = pedidosDao.findById(idPedido).get();
        Distribuidor distribuidor = distribuidorDao.findById(idUsuarioDistribuidor).get();
        pedido.setDistribuidor(distribuidor);
        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE
        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.DESPACHADO);

    }

    /**
     * @param idPedido
     * @param idUsuario
     * @return Pedido
     */

    public Pedido entregarPedido(Long idPedido, Long idUsuario) {

        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE

        // GUARDAMOS LAS VENTAS COMPLETAS EN LA BASE DE DATOS DE MONGO
        // Venta venta = new Venta();
        // venta.setListaProducto(new HashMap<>());

        Pedido pedido = pedidosDao.findById(idPedido).get();
        Date fecha = new Date();
        
        // Duration duration = Duration.between(fecha.getTime(),
        // pedido.getFechaPedido().getTime());
        long diffInMillies = Math.abs(fecha.getTime() - pedido.getFechaPedido().getTime());
        long duracionTotal = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
        System.out.println("DIFERENCIA TOTAL: " + diffInMillies);

        System.out.println("DURACION TOTAL: " + duracionTotal);

        // Date duracionTotal = new Date(fecha.getTime() -
        // pedido.getFechaPedido().getTime());
        pedido.setDuracionFinal(duracionTotal);
        // ACTUALIZAMOS EL STOCK DE LOS PRODUCTOS Y AGREGAMOS LOS PRODUCTOS A LA VENTA
        pedido.getProductos().forEach(producto -> {
            Producto prod = productoDao.findByTipoProducto_idTipoProd(producto.getProducto().getIdTipoProd());
            prod.setCantidadReservada(prod.getCantidadReservada() - producto.getCantidad());
            productoDao.save(prod);
        });

        // venta.setDuracion(duracionTotal);
        // venta.setFecha(pedido.getFechaPedido());
        // venta.setTotal(pedido.getTotal());
        // ventasService.save(venta);

        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.ENTREGADO);

    }

    /**
     * @param pedido
     * @param idUsuario
     * @param tipoEstadoPedido
     * @return Pedido
     */

    public Pedido cambiarEstadoPedido(Pedido pedido, Long idUsuario, TipoEstadoPedido tipoEstadoPedido) {

        Usuario usuario = usuarioDao.findById(idUsuario).get();
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.setTipoEstadoPedido(tipoEstadoPedido);
        estadoPedido.setFecha(new Date());
        estadoPedido.setUsuario(usuario);
        pedido.getEstadoPedido().add(estadoPedido);
        return pedidosDao.save(pedido);
    }

    /**
     * @param fechaPedidoStart
     * @param fechaPedidoEnd
     * @return List<Pedido>
     */

    public List<Pedido> findByFehaPedidoIsBetween(Date fechaPedidoStart, Date fechaPedidoEnd) {
        return pedidosDao.findByFechaPedidoIsBetween(fechaPedidoStart, fechaPedidoEnd);
    }

    /**
     * @param idPedido
     * @param idUsuario
     * @return Pedido
     */

    public Pedido devolverPedido(Long idPedido, Long idUsuario) {
        Pedido pedido = pedidosDao.findById(idPedido).get();
        Date fecha = new Date();

        pedido.getProductos().forEach(producto -> {
            // venta.getListaProducto().put(producto.getProducto().getNombre(),
            // producto.getCantidad());

            Producto prod = productoDao.findByTipoProducto_idTipoProd(producto.getProducto().getIdTipoProd());
            prod.setCantidadDisponible(prod.getCantidadDisponible() + producto.getCantidad());
            productoDao.save(prod);
        });

        // venta.setDuracion(duracionTotal);
        // venta.setFecha(pedido.getFechaPedido());
        // venta.setTotal(pedido.getTotal());
        // ventasService.save(venta);

        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.DEVUELTO);
    }

    /**
     * @param year
     * @return List<ReporteProductos>
     */

    public List<ReporteProductosInterface> reporteProductosVendidosAnual(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 0, 01);
        Date startDate = calendar.getTime();
        calendar.set(year, 12, 31);
        Date endDate = calendar.getTime();
        List<ReporteProductosInterface> reporteProductos = pedidosDao
                .sumProductosVendidosByMonthBetweenFechas(startDate, endDate);
        return reporteProductos;
    }

    /**
     * @param year
     * @param idProducto
     * @return List<ReporteProductos>
     */

    public List<ReporteProductosInterface> reporteProductoVendidoAnual(int year, long idProducto) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, 01, 01);
        Date startDate = calendar.getTime();
        calendar.set(year, 12, 31);
        Date endDate = calendar.getTime();
        List<ReporteProductosInterface> reporteProductos = pedidosDao
                .sumProductosVendidosByMonthBetweenFechasByTipoProducto(startDate, endDate, idProducto);
        return reporteProductos;
    }


    @Override
    public List<Pedido> findByDistribuidor_UsuarioAndDuracionFinalNull(Long id) {
        
        return pedidosDao.findByDistribuidor_UsuarioAndDuracionFinalNull(usuarioDao.findById(id).get());
    }



    

}
