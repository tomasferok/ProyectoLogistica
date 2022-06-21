package com.log.app.services.Impl;

import com.log.app.daos.IProductoDao;
import com.log.app.daos.IRecepcionDao;
import com.log.app.entidades.*;
import com.log.app.exepciones.RecepcionConDiferenciasExeption;
import com.log.app.helpers.CancelarRecepcionRequest;
import com.log.app.helpers.ControlarRecepcionRequest;
import com.log.app.services.Impl.RecepcionService;
import com.log.app.services.Impl.UserService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RecepcionServiceTest {
    @Mock
    IRecepcionDao recepcionDao;

    @Mock
    UserService userService;

    @Mock
    IProductoDao productoDao;

    @InjectMocks
    private RecepcionService recepcionService;

    private Recepcion recepcion = new Recepcion();

    private ControlarRecepcionRequest request = new ControlarRecepcionRequest(

    );

    private CancelarRecepcionRequest cancelarRecepcionRequest = new CancelarRecepcionRequest(

    );

    private RecepcionProducto recepcionProducto = new RecepcionProducto();

    private TipoProducto tipoProducto = new TipoProducto();

    private Producto producto = new Producto();

    private Usuario usuario = new Usuario();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // RECEPCION
        recepcion.setIdRecepcion(1l);
        recepcion.setFechaRecepcion(new Date());

        // REQUEST DE CONTROL DE RECEPCION
        request.setIdRecepcion(1l);
        Map<Long, Double> map = new HashMap<>();
        map.put(1l, 1d);

        request.setIdUsuario(1l);
        request.setControlarDiferencias(true);
        request.setProductosRecibidos(map);

        // CREAMOS UN PRODUCTO
        tipoProducto.setIdTipoProd(1l);
        tipoProducto.setNombre("TipoProducto");

        producto.setIdProd(1l);
        producto.setTipoProducto(tipoProducto);
        producto.setCantidadReservada(1d);
        producto.setCantidadDisponible(1d);
        producto.setCantidadEnCuarentena(1d);

        // LISTA DE PRODUCTOS EN LA RECEPCION
        recepcionProducto.setIdRecepcionProducto(1l);
        recepcionProducto.setCantidad(1.0);
        recepcionProducto.setProducto(tipoProducto);
        List<RecepcionProducto> list = new ArrayList<>();
        list.add(recepcionProducto);

        // CREAMOS UN ESTADO DE RECEPCION
        List<EstadoRecepcion> estados = new ArrayList<>();
        EstadoRecepcion estado = new EstadoRecepcion();
        estado.setIdEstadoRecepcion(1l);
        estado.setTipoEstado(TipoEstadoRecepcion.PENDIENTE);

        // AGREGAMOS LOS DATOS A LA RECEPCION
        recepcion.setProductos(list);
        recepcion.setEstadoRecepcion(estados);

        cancelarRecepcionRequest.setIdRecepcion(1l);
        cancelarRecepcionRequest.setIdUsuario(1l);

        usuario.setIdUsuario(1l);
        usuario.setNombre("Usuario");
        usuario.setApellido("Apellido");
        usuario.setEmail("username@test.com");
        usuario.setPassword("password");

        // MOCKEAMOS LOS DAOS Y SERVICIOS EXTRAS

        org.mockito.Mockito.when(recepcionDao.findById(1l)).thenReturn(Optional.ofNullable(recepcion));
        org.mockito.Mockito.when(recepcionDao.findAll()).thenReturn(Arrays.asList(recepcion));
        org.mockito.Mockito.when(recepcionDao.save(recepcion)).thenReturn(recepcion);
        org.mockito.Mockito.when(recepcionDao.save(recepcion)).thenReturn(recepcion);
        org.mockito.Mockito.when(userService.findById(1l)).thenReturn((usuario));
        org.mockito.Mockito.when(productoDao.findByTipoProducto_idTipoProd(1l)).thenReturn(producto);
        org.mockito.Mockito.when(recepcionDao.count()).thenReturn(1l);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        assertEquals(Arrays.asList(recepcion), recepcionService.findAll());
    }

    @Test
    void save() {
        assertNotNull(recepcionService.save(recepcion));
    }

    @Test
    void recibirRecepcion() throws RecepcionConDiferenciasExeption {
        assertNotNull(recepcionService.recibirRecepcion(request));
        int ultimoEstado = recepcion.getEstadoRecepcion().size() - 1;
        assertEquals(TipoEstadoRecepcion.RECIBIDO, recepcion.getEstadoRecepcion().get(ultimoEstado).getTipoEstado());
    }

    @Test
    void count() {
        assertNotNull(recepcionService.count());
        assertEquals(1l, recepcionService.count());

    }

    @Test
    void cancelarRecepcion() {

        assertEquals(recepcion, recepcionService.cancelarRecepcion(1l, 1l));
        int ultimoEstado = recepcion.getEstadoRecepcion().size() - 1;
        EstadoRecepcion estadoRecepcion = recepcion.getEstadoRecepcion().get(ultimoEstado);
        assertEquals(TipoEstadoRecepcion.CANCELADO, estadoRecepcion.getTipoEstado());
    }

    @Test
    void findById() {
        org.mockito.Mockito.when(recepcionDao.findById(1l)).thenReturn(Optional.ofNullable(recepcion));

        assertEquals(recepcion, recepcionService.findById(1l));

    }
}