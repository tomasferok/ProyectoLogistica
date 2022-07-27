package com.log.app.services.Impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.log.app.daos.IProductoDao;
import com.log.app.daos.ITipoProductoDao;
import com.log.app.entidades.Producto;
import com.log.app.entidades.TipoProducto;

public class ProductoServiceTest {

    @InjectMocks
    private ProductoService productoService;

    @Mock
    IProductoDao productoDao;

    @Mock
    ITipoProductoDao tipoProductoDao;

    Producto producto = new Producto();

    TipoProducto tipoProducto = new TipoProducto();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        producto.setIdProd(1l);
        producto.setTipoProducto(tipoProducto);
        producto.setCantidadDisponible(10);
        producto.setCantidadEnCuarentena(10);

        producto.setCantidadReservada(10);
        tipoProducto.setIdTipoProd(1l);
        tipoProducto.setNombre("TipoProducto");
        tipoProducto.setCodigoDeBarras("0000");
        tipoProducto.setPrecio(10.0);



        when(productoDao.findById(1l)).thenReturn(Optional.of(producto));
        when(productoDao.findById(2l)).thenReturn(Optional.empty());
        when(productoDao.findById(2l)).thenReturn(Optional.empty());


        when(tipoProductoDao.findById(1l)).thenReturn(Optional.of(tipoProducto));
        when(tipoProductoDao.findById(2l)).thenReturn(Optional.empty());

   
    }

    @Test
    void testDelete() {

        productoService.delete(1l);
        org.mockito.Mockito.verify(productoDao, org.mockito.Mockito.times(1)).deleteById(producto.getIdProd());

    }

    @Test
    void testDeleteProducto() {

    
    }

    @Test
    void testFindAll() {

        productoService.findAll();
        verify(productoDao, org.mockito.Mockito.times(1)).findAll();
    }

    @Test
    void testFindByCodigoDeBarras() {
            
            // productoService.findByCodigoDeBarras(0000);
            // verify(productoDao, org.mockito.Mockito.times(1)).findByTipoProducto_CodigoDeBarras(0000);
            // assertEquals(producto, productoService.findByCodigoDeBarras(0000));

    }

    @Test
    void testFindById() {

        productoService.findById(1l);
        verify(productoDao, org.mockito.Mockito.times(1)).findById(1l);
        assertEquals(producto, productoService.findById(1l));

    }

    @Test
    void testFindByNombre() {

        // productoService.findByNombre("TipoProducto");
        // verify(productoDao, org.mockito.Mockito.times(1)).findByTipoProducto_NombreIgnoreCaseContaining("TipoProducto");
        // assertEquals(producto, productoService.findByNombre("TipoProducto"));

    }

    @Test
    void testFindProductosDisponibles() {
            
            // productoService.findProductosDisponibles();
            // verify(productoDao, org.mockito.Mockito.times(1)).findByCantidadDisponibleGreaterThan(0);
            // assertEquals(producto, productoService.findProductosDisponibles());
    

    }

    @Test
    void testGetStockProductos() {

    }

    @Test
    void testSave() {

    }

    @Test
    void testSave2() {

    }

    @Test
    void testSaveEmpyProducto() {

    }

    @Test
    void testUpdate() {

    }

    @Test
    void testUpdateCantidadDisponible() {

    }

    @Test
    void testUpdateCantidadEnCuarentena() {

    }

    @Test
    void testUpdateCantidadReservada() {

    }

    @Test
    void testUpdateProducto() {

    }

    @Test
    void testUpdateStock() {

    }
}
