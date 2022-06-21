package com.log.app.services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.log.app.daos.IDistribuidorDao;
import com.log.app.daos.IPedidoDao;
import com.log.app.daos.IProductoDao;
import com.log.app.daos.IUsuarioDao;
import com.log.app.entidades.Distribuidor;
import com.log.app.entidades.EstadoPedido;
import com.log.app.entidades.Pedido;
import com.log.app.entidades.PedidoProducto;
import com.log.app.entidades.Producto;
import com.log.app.entidades.TipoEstadoPedido;
import com.log.app.entidades.TipoProducto;
import com.log.app.entidades.Usuario;

public class PedidosServiceTest {
    @Mock
    IPedidoDao pedidoDao;

    @Mock
    IUsuarioDao usuarioDao;

    @Mock
    IProductoDao productoDao;

    @Mock
    IDistribuidorDao distribuidorDao;

    @InjectMocks
    private PedidosService pedidoService;

    private Pedido pedido = new Pedido();

    private PedidoProducto pedidoProducto = new PedidoProducto();

    private TipoProducto tipoProducto = new TipoProducto();

    private Producto producto = new Producto();

    private Usuario usuario = new Usuario();

    private Distribuidor distribuidor = new Distribuidor();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // PEDIDO
        pedido.setIdPedido(1l);
        pedido.setFechaPedido(new java.util.Date());

        // CREAMOS UN PRODUCTO
        tipoProducto.setIdTipoProd(1l);
        tipoProducto.setNombre("TipoProducto");

        producto.setIdProd(1l);
        producto.setTipoProducto(tipoProducto);
        producto.setCantidadReservada(1d);
        producto.setCantidadDisponible(1d);
        producto.setCantidadEnCuarentena(1d);

        // LISTA DE PRODUCTOS EN LA RECEPCION
        pedidoProducto.setIdPedidoProducto(1l);
        pedidoProducto.setCantidad(1.0);
        pedidoProducto.setProducto(tipoProducto);
        List<PedidoProducto> list = new ArrayList<>();
        list.add(pedidoProducto);

        // CREAMOS UN ESTADO DE RECEPCION
        List<EstadoPedido> estados = new ArrayList<>();
        EstadoPedido estado = new EstadoPedido();
        estado.setIdEstadoPedido(1l);
        estado.setTipoEstadoPedido(TipoEstadoPedido.PENDIENTE);

        // AGREGAMOS LOS DATOS AL PEDIDO
        pedido.setProductos(list);
        pedido.setEstadoPedido(estados);

        usuario.setIdUsuario(1l);
        usuario.setNombre("Usuario");
        usuario.setApellido("Apellido");
        usuario.setEmail("username@test.com");
        usuario.setPassword("password");

        // AGREGAMOS DATOS DEL DISTRIBUIDOR
        distribuidor.setIdDistribu(1l);
        distribuidor.setChofer("Distribuidor");

        // MOCKEAMOS LOS DAOS Y SERVICIOS EXTRAS

        org.mockito.Mockito.when(pedidoDao.findById(1l)).thenReturn(Optional.ofNullable(pedido));
        org.mockito.Mockito.when(pedidoDao.findAll()).thenReturn(Arrays.asList(pedido));
        org.mockito.Mockito.when(pedidoDao.save(pedido)).thenReturn(pedido);
        org.mockito.Mockito.when(pedidoDao.save(pedido)).thenReturn(pedido);
        org.mockito.Mockito.when(pedidoDao.findByFechaPedidoIsBetween(pedido
                .getFechaPedido(),
                pedido.getFechaPedido())).thenReturn(
                Arrays.asList(pedido));
        org.mockito.Mockito.when(pedidoDao.findByfechaPedido(
                pedido.getFechaPedido())).thenReturn(
                Arrays.asList(pedido));

        org.mockito.Mockito.when(usuarioDao.findById(1l)).thenReturn(Optional.ofNullable(usuario));
        org.mockito.Mockito.when(productoDao.findByTipoProducto_idTipoProd(1l)).thenReturn(producto);
        org.mockito.Mockito.when(pedidoDao.count()).thenReturn(1l);
        org.mockito.Mockito.when(distribuidorDao.findById(1l)).thenReturn(Optional.ofNullable(distribuidor));

    }

    @Test
    void testCambiarEstadoPedido() {

        pedidoService.cambiarEstadoPedido(pedido, 1l, TipoEstadoPedido.ENTREGADO);
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).save(pedido);
        int ultimoEstado = pedido.getEstadoPedido().size() - 1;

        assertEquals(TipoEstadoPedido.ENTREGADO, pedido.getEstadoPedido().get(ultimoEstado).getTipoEstadoPedido());

    }

    @Test
    void testCancelarPedido() {

        pedidoService.cancelarPedido(pedido.getIdPedido(), 1l);
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).save(pedido);
        int ultimoEstado = pedido.getEstadoPedido().size() - 1;
        assertEquals(TipoEstadoPedido.CANCELADO, pedido.getEstadoPedido().get(ultimoEstado).getTipoEstadoPedido());
    }

    @Test
    void testControlarPedido() {

        pedidoService.controlarPedido(pedido.getIdPedido(), 1l);
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).save(pedido);
        int ultimoEstado = pedido.getEstadoPedido().size() - 1;
        assertEquals(TipoEstadoPedido.CONTROLADO, pedido.getEstadoPedido().get(ultimoEstado).getTipoEstadoPedido());
    }

    @Test
    void testDelete() {

        pedidoService.delete(pedido);
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).delete(pedido);
    }

    @Test
    void testDeleteById() {

        pedidoService.deleteById(pedido.getIdPedido());
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).deleteById(pedido.getIdPedido());

    }

    @Test
    void testDespacharPedido() {

        pedidoService.despacharPedido(pedido.getIdPedido(), usuario.getIdUsuario(), distribuidor.getIdDistribu());
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).save(pedido);
        int ultimoEstado = pedido.getEstadoPedido().size() - 1;
        assertEquals(TipoEstadoPedido.DESPACHADO, pedido.getEstadoPedido().get(ultimoEstado).getTipoEstadoPedido());
    }

    @Test
    void testDevolverPedido() {

        pedidoService.devolverPedido(pedido.getIdPedido(), 1l);
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).save(pedido);
        int ultimoEstado = pedido.getEstadoPedido().size() - 1;
        assertEquals(TipoEstadoPedido.DEVUELTO, pedido.getEstadoPedido().get(ultimoEstado).getTipoEstadoPedido());
    }

    @Test
    void testEntregarPedido() {

        pedidoService.entregarPedido(pedido.getIdPedido(), 1l);
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).save(pedido);
        int ultimoEstado = pedido.getEstadoPedido().size() - 1;
        assertEquals(TipoEstadoPedido.ENTREGADO, pedido.getEstadoPedido().get(ultimoEstado).getTipoEstadoPedido());

    }

    @Test
    void testFindAll() {

        List<Pedido> pedidos = pedidoService.findAll();
        assertEquals(1, pedidos.size());

    }

    @Test
    void testFindByFecha() {

        List<Pedido> pedidos = pedidoService.findByFecha(pedido.getFechaPedido());
        assertEquals(1, pedidos.size());

    }

    @Test
    void testFindByFehaPedidoIsBetween() {
        List<Pedido> pedidos = pedidoService.findByFehaPedidoIsBetween(pedido.getFechaPedido(),
                pedido.getFechaPedido());
        assertEquals(1, pedidos.size());

    }

    @Test
    void testFindById() {

        Pedido pedido = pedidoService.findById(1l);
        assertEquals(1l, pedido.getIdPedido());

    }

    @Test
    void testPrepararPedido() {

        pedidoService.prepararPedido(pedido.getIdPedido(), 1l);
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).save(pedido);
        int ultimoEstado = pedido.getEstadoPedido().size() - 1;
        assertEquals(TipoEstadoPedido.PREPARADO, pedido.getEstadoPedido().get(ultimoEstado).getTipoEstadoPedido());

    }

    @Test
    void testSave() {

        pedidoService.save(pedido);
        org.mockito.Mockito.verify(pedidoDao, org.mockito.Mockito.times(1)).save(pedido);

    }
}
