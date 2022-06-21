package com.log.app.services.Impl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.log.app.daos.ICategoriaDao;
import com.log.app.entidades.Categoria;

public class CategoriaServiceImplTest {
    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @Mock
    private ICategoriaDao categoriaDao;

    Categoria categoria = new Categoria();

    String nombreCategoriaTest = "CategoriaTest";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        // RECEPCION
        categoria.setIdCat(1l);
        categoria.setNombre(nombreCategoriaTest);
        org.mockito.Mockito.when(categoriaDao.findById(1l)).thenReturn(Optional.ofNullable(categoria));
        org.mockito.Mockito.when(categoriaDao.save(categoria)).thenReturn(categoria);
        org.mockito.Mockito.when(categoriaDao.findAll()).thenReturn(Arrays.asList(categoria));

    }

    @Test
    void testDelete() {

    categoriaService.delete(1l);
        org.mockito.Mockito.verify(categoriaDao, org.mockito.Mockito.times(1)).deleteById(1l);
     
    }

    @Test
    void testFindAll() {

        assertEquals(1, categoriaService.findAll().size());

    }

    @Test
    void testFindOne() {

        assertEquals(categoria, categoriaService.findOne(1l));


    }

    @Test
    void testSave() {

        assertEquals(categoria, categoriaService.save(categoria));


    }
}
