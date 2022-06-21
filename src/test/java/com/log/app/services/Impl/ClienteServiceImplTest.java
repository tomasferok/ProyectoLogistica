package com.log.app.services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.log.app.daos.IClienteDao;
import com.log.app.entidades.Cliente;

public class ClienteServiceImplTest {

    @Mock
    IClienteDao clienteDao;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    Cliente cliente = new Cliente();


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // RECEPCION
        cliente.setIdCliente(1l);
        cliente.setNombre("ClienteTest");
        cliente.setRazonSocial("RazonTest");
        cliente.setDocumento("documentoTest");

        org.mockito.Mockito.when(clienteDao.findById(1l)).thenReturn(Optional.ofNullable(cliente));
        
        org.mockito.Mockito.when(clienteDao.save(cliente)).thenReturn(cliente);
        org.mockito.Mockito.when(clienteDao.findAll()).thenReturn(Arrays.asList(cliente));
        org.mockito.Mockito.when(clienteDao.findByDocumentoIgnoreCaseContaining(
                "documentoTest")).thenReturn(Arrays.asList(cliente));

    };


    @Test
    void testDelete() {
            
            clienteService.delete(1l);
            org.mockito.Mockito.verify(clienteDao, org.mockito.Mockito.times(1)).deleteById(1l);
    
    }

    @Test
    void testFindAll() {

        assertEquals(1, clienteService.findAll().size());

    }

    @Test
    void testFindByDocumentoIgnoreCaseContaining() {
            
            assertEquals(1, clienteService.findByDocumentoIgnoreCaseContaining("documentoTest").size());
    

    }

    @Test
    void testFindOne() {

        assertEquals(cliente, clienteService.findOne(1l));

    }

    @Test
    void testSave() {

        assertEquals(cliente, clienteService.save(cliente));


    }
}
