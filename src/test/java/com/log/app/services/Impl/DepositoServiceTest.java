package com.log.app.services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.log.app.daos.IDepositoDao;
import com.log.app.entidades.Deposito;
import com.log.app.entidades.Espacio;
import com.log.app.entidades.Pasillo;

public class DepositoServiceTest {

    @Mock
    IDepositoDao depositoDao;

    @InjectMocks
    private DepositoService depositoService;

    Deposito deposito = new Deposito();

    Pasillo pasillo = new Pasillo();

    Espacio espacio = new Espacio();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        //GENERAMOS DATOS DEL DEPOSITO
        deposito.setIdDeposito(1l);
        deposito.setNomDeposito("DepositoTest");
        deposito.setDireccion("Direccion test");


        //GENERAMOS DATOS DEL PASILLO
        pasillo.setIdPasillo(1l);
        pasillo.setNomPasillo("PasilloTest");
        pasillo.setDeposito(deposito);
        //GENERAMOS DATOS DEL ESPACIO
        espacio.setIdEsp(1l);
        espacio.setNomEspacio("EspacioTest");
        espacio.setPasillo(pasillo);
        //GENERAMOS LISTA DE ESPACIOS
        pasillo.setEspacio(Arrays.asList(espacio));
        //GENERAMOS LISTA DE PASILLOS
        deposito.setPasillos(Arrays.asList(pasillo));
        
        //MOCKEAMOS DEPOSITO DAO
        org.mockito.Mockito.when(depositoDao.findById(1l)).thenReturn(Optional.ofNullable(deposito));
        org.mockito.Mockito.when(depositoDao.save(deposito)).thenReturn(deposito);
        org.mockito.Mockito.when(depositoDao.findAll()).thenReturn(Arrays.asList(deposito));
    }



    @Test
    void testCreateDeposito() {
        depositoService.createDeposito(deposito);
        org.mockito.Mockito.verify(depositoDao, org.mockito.Mockito.times(1)).save(deposito);
        assertEquals(deposito, depositoService.createDeposito(deposito));
        
    }

    @Test
    void testDeleteDeposito() {
        depositoService.deleteDeposito(1l);
        org.mockito.Mockito.verify(depositoDao, org.mockito.Mockito.times(1)).deleteById(1l);

    }

    @Test
    void testGetAllDepositos() {
        assertEquals(1, depositoService.getAllDepositos().size());
    }

    @Test
    void testGetDepositoById() {

        assertEquals(deposito, depositoService.getDepositoById(1l));
    }

    @Test
    void testUpdateDeposito() {
        deposito.setIdDeposito(2l);
        assertEquals(deposito, depositoService.updateDeposito(deposito));
        assertEquals(2l, depositoService.updateDeposito(deposito).getIdDeposito());

    }
}
