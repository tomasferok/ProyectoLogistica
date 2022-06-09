package com.log.app.services;

import com.log.app.daos.IDistribuidorDao;
import com.log.app.daos.IPedidoDao;
import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.Distribuidor;
import com.log.app.entidades.EstadoPedido;
import com.log.app.entidades.Pedido;
import com.log.app.entidades.TipoEstadoPedido;
import com.log.app.entidades.Usuario;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService implements IPedidosService {

    @Autowired
    private IPedidoDao pedidosDao;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IDistribuidorDao distribuidorDao;

    @Override
    public Pedido save(Pedido pedido) {

        try {

            return pedidosDao.save(pedido);
        } catch (

        Exception e) {
            // TODO: handle exceptio
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Iterable<Pedido> findAll() {
        return pedidosDao.findAll();
    }

    public Pedido findById(Long id) {
        return pedidosDao.findById(id).get();
    }

    public void deleteById(Long id) {
        pedidosDao.deleteById(id);
    }

    public void delete(Pedido pedido) {
        pedidosDao.delete(pedido);
    }

    public List<Pedido> findByFecha(Date fecha) {
        return pedidosDao.findByfechaPedido(fecha);
    }

    public Pedido cancelarPedido(Long idPedido, Long idUsuario) {
        Pedido pedido = pedidosDao.findById(idPedido).get();

        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE
        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.CANCELADO);

    }

    public Pedido prepararPedido(Long idPedido, Long idUsuario) {
        Pedido pedido = pedidosDao.findById(idPedido).get();

        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE
        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.PREPARADO);

    }

    public Pedido controlarPedido(Long idPedido, Long idUsuario) {
        Pedido pedido = pedidosDao.findById(idPedido).get();

        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE
        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.CONTROLADO);

    }

    public Pedido despacharPedido(Long idPedido, Long idUsuario, Long idUsuarioDistribuidor) {
        Pedido pedido = pedidosDao.findById(idPedido).get();
        Distribuidor distribuidor = distribuidorDao.findById(idUsuarioDistribuidor).get();
        pedido.setDistribuidor(distribuidor);
        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE
        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.DESPACHADO);

    }

    public Pedido entregarPedido(Long idPedido, Long idUsuario) {

        // TODO: AGREGAR EXEPCION EN CASO DE QUE YA ESTE CANCELADO U EN UN ESTADO
        // INCONSISTENTE
        Pedido pedido = pedidosDao.findById(idPedido).get();
        Date fecha = new Date();
        Date duracionTotal = new Date(fecha.getTime() - pedido.getFechaPedido().getTime());
        pedido.setDuracionFinal(duracionTotal);
        return cambiarEstadoPedido(pedido, idUsuario, TipoEstadoPedido.ENTREGADO);

    }

    public Pedido cambiarEstadoPedido(Pedido pedido, Long idUsuario, TipoEstadoPedido tipoEstadoPedido) {

        Usuario usuario = usuarioDao.findById(idUsuario).get();
        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.setTipoEstadoPedido(tipoEstadoPedido);
        estadoPedido.setUsuario(usuario);
        pedido.addEstado(estadoPedido);
        return pedidosDao.save(pedido);
    }

    public List<Pedido> findByFehaPedidoIsBetween(Date fechaPedidoStart, Date fechaPedidoEnd) {
        return pedidosDao.findByFechaPedidoIsBetween(fechaPedidoStart, fechaPedidoEnd);
    }

}
