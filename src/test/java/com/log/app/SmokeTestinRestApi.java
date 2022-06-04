package com.log.app;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.log.app.controllers.TipoProductosRestController;
import com.log.app.services.TipoProductoServiceImpl;

@SpringBootTest

public class SmokeTestinRestApi {
    @Autowired
    private TipoProductoServiceImpl controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

}
