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
import com.log.app.daos.IEspacioDao;
import com.log.app.daos.IPasilloDao;
import com.log.app.entidades.Deposito;
import com.log.app.entidades.Espacio;
import com.log.app.entidades.Pasillo;

public class EspacioServiceImplTest {

    @Mock
    IDepositoDao depositoDao;

    @Mock
    IPasilloDao pasilloDao;
    @Mock
    IEspacioDao espacioDao;
    @InjectMocks
    private EspacioServiceImpl espacioServiceImpl;

    Deposito deposito = new Deposito();

    Pasillo pasillo = new Pasillo();

    Espacio espacio = new Espacio();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        // GENERAMOS DATOS DEL DEPOSITO
        deposito.setIdDeposito(1l);
        deposito.setNomDeposito("DepositoTest");
        deposito.setDireccion("Direccion test");

        // GENERAMOS DATOS DEL PASILLO
        pasillo.setIdPasillo(1l);
        pasillo.setNomPasillo("PasilloTest");
        pasillo.setDeposito(deposito);
        
        // GENERAMOS DATOS DEL ESPACIO
        espacio.setIdEsp(1l);
        espacio.setNomEspacio("EspacioTest");
        espacio.setPasillo(pasillo);
        // GENERAMOS LISTA DE ESPACIOS
        pasillo.setEspacio(Arrays.asList(espacio));
        // GENERAMOS LISTA DE PASILLOS
        deposito.setPasillos(Arrays.asList(pasillo));

        // MOCKEAMOS DEPOSITO DAO
        org.mockito.Mockito.when(depositoDao.findById(1l)).thenReturn(Optional.ofNullable(deposito));
        org.mockito.Mockito.when(depositoDao.save(deposito)).thenReturn(deposito);
        org.mockito.Mockito.when(depositoDao.findAll()).thenReturn(Arrays.asList(deposito));

        // MOCKEAMOS PASILLO DAO

        org.mockito.Mockito.when(pasilloDao.findById(1l)).thenReturn(Optional.ofNullable(pasillo));
        org.mockito.Mockito.when(pasilloDao.save(pasillo)).thenReturn(pasillo);

        // MOCKEAMOS ESPACIO DAO
        org.mockito.Mockito.when(espacioDao.save(espacio)).thenReturn(espacio);

    }

    @Test
    void testDelete() {
        espacioServiceImpl.delete(espacio.getIdEsp());
        org.mockito.Mockito.verify(espacioDao, org.mockito.Mockito.times(1)).deleteById(espacio.getIdEsp());

    }

    @Test
    void testFindAll() {

        org.mockito.Mockito.when(espacioDao.findAll()).thenReturn(Arrays.asList(espacio));
        espacioServiceImpl.findAll();
        org.mockito.Mockito.verify(espacioDao, org.mockito.Mockito.times(1)).findAll();
    }

    @Test
    void testFindById() {
        org.mockito.Mockito.when(espacioDao.findById(1l)).thenReturn(Optional.ofNullable(espacio));
        espacioServiceImpl.findById(1l);
        org.mockito.Mockito.verify(espacioDao, org.mockito.Mockito.times(1)).findById(1l);
    }

    @Test
    void testSave() {
        espacioServiceImpl.save(espacio);
        org.mockito.Mockito.verify(espacioDao, org.mockito.Mockito.times(1)).save(espacio);
    }

    // @Test
    // void testUpdate() {
    //     espacio.setIdEsp(2l);
    //     espacioServiceImpl.update(espacio);
    //     assertEquals(espacioServiceImpl.update(espacio).getIdEsp(), 2l);
    //     org.mockito.Mockito.verify(espacioDao, org.mockito.Mockito.times(1)).save(espacio);
    // }
}
