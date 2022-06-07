
package com.log.app.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.log.app.services.EtiquetaService;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EtiquetasRestController
 */
@RestController
@RequestMapping("/api")
public class EtiquetasRestController {

    @Autowired
    EtiquetaService etiquetaService;

    @GetMapping("/etiquetas")
    public String crearEtiquetas() throws IOException {
        etiquetaService.crearInvoice();
        return "ok";
    }
}