package com.log.app.services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.log.app.daos.IDistribuidorDao;
import com.log.app.entidades.Distribuidor;

public class DistribuidorServiceImplTest {

    @Mock
    IDistribuidorDao distribuidorDao;

    @InjectMocks
    private DistribuidorServiceImpl distribuidorService;

    Distribuidor distribuidor = new Distribuidor();

 @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // RECEPCION
        distribuidor.setIdDistribu(1l);
        distribuidor.setChofer("ChoferTest");
        distribuidor.setVehiculo("VehiculoTest");
        org.mockito.Mockito.when(distribuidorDao.findById(1l)).thenReturn(Optional.ofNullable(distribuidor));
        org.mockito.Mockito.when(distribuidorDao.save(distribuidor)).thenReturn(distribuidor);
        org.mockito.Mockito.when(distribuidorDao.findAll()).thenReturn(Arrays.asList(distribuidor));

        
    }



    @Test
    void testDelete() {

    distribuidorService.delete(1l);
        org.mockito.Mockito.verify(distribuidorDao, org.mockito.Mockito.times(1)).deleteById(1l);
     
    }

    @Test
    void testFindAll() {

        assertEquals(1, distribuidorService.findAll().size());

    }

    @Test
    void testFindOne() {

        assertEquals(distribuidor, distribuidorService.findOne(1l));
    }

    @Test
    void testSave() {

        assertEquals(distribuidor, distribuidorService.save(distribuidor));
    }
}
