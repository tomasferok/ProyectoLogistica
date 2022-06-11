package com.log.app.services;

import com.log.app.daos.IProductoDao;
import com.log.app.daos.IRecepcionDao;
import com.log.app.entidades.Recepcion;
import com.log.app.exepciones.RecepcionConDiferenciasExeption;
import com.log.app.helpers.CancelarRecepcionRequest;
import com.log.app.helpers.ControlarRecepcionRequest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;

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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recepcion.setIdRecepcion(1l);
        recepcion.setFechaRecepcion(new Date());

        request.setIdRecepcion(1l);
        request.setIdUsuario(1l);
        request.setControlarDiferencias(false);

        cancelarRecepcionRequest.setIdRecepcion(1l);
        cancelarRecepcionRequest.setIdUsuario(1l);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        org.mockito.Mockito.when(recepcionService.findAll()).thenReturn(Arrays.asList(recepcion));
        assertNotNull(recepcionService.findAll());
    }

    @Test
    void save() {
        org.mockito.Mockito.when(recepcionService.save(recepcion)).thenReturn(recepcion);
        assertNotNull(recepcionService.save(recepcion));
    }

    @Test
    void recibirRecepcion() throws RecepcionConDiferenciasExeption {
    //     org.mockito.Mockito.when(recepcionService.recibirRecepcion(request)).thenReturn(recepcion);
    //     assertNotNull(recepcionService.recibirRecepcion(request));
    }

    @Test
    void count() {
        org.mockito.Mockito.when(recepcionService.count()).thenReturn(1l);
        assertNotNull(recepcionService.count());
    }

    @Test
    void cancelarRecepcion() {

        // org.mockito.Mockito.when(recepcionService.cancelarRecepcion(cancelarRecepcionRequest)).thenReturn(recepcion);
        // assertNotNull(recepcionService.cancelarRecepcion(cancelarRecepcionRequest));

    }

    @Test
    void findById() {

        // org.mockito.Mockito.when(recepcionService.findById(1l)).thenReturn(recepcion);
        // assertNotNull(recepcionService.findById(1l));

    }
}