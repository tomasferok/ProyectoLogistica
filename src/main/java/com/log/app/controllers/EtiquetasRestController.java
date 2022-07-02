
package com.log.app.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.log.app.services.Impl.RecepcionService;
import com.log.app.services.Impl.TipoProductoServiceImpl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.app.services.Impl.EtiquetaService;
import com.log.app.services.Impl.PedidosService;

/**
 * Esta clase controla las peticiones de etiquetas del api
 * 
 * @author Clawtech
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*" })
public class EtiquetasRestController {

        @Autowired
        EtiquetaService etiquetaService;

        @Autowired
        RecepcionService recepcionService;

        @Autowired

        PedidosService pedidoService;

        @Autowired
        TipoProductoServiceImpl tipoProductoService;

        /**
         * @param idRecepcion
         * @return ResponseEntity<Resource>
         * @throws IOException
         */
        @GetMapping("/etiquetas/recepcion/{idRecepcion}")
        public ResponseEntity<Resource> crearEtiquetaRecepcion(@PathVariable Long idRecepcion) throws IOException {

                byte[] pdfResult = etiquetaService.crearEtiquetaRecepcion(recepcionService.findById(idRecepcion));
                return ResponseEntity.ok()
                                .contentType(MediaType.parseMediaType("application/pdf"))
                                .header(HttpHeaders.CONTENT_DISPOSITION,
                                                "attachment; filename=\"" + "etiquetas" + "idRecepcion" + ".pdf" + "\"")

                                .body(new ByteArrayResource(pdfResult));
        }

        /**
         * @param idRecepcion
         * @return ResponseEntity<Resource>
         * @throws IOException
         */
        @GetMapping("/etiquetas/productos/recepcion/{idRecepcion}")
        public ResponseEntity<Resource> crearEtiquetaProductosRecepcion(@PathVariable Long idRecepcion)
                        throws IOException {

                byte[] pdfResult = etiquetaService
                                .crearEtiquetaCodigosDeBarraProductos(recepcionService.findById(idRecepcion));
                return ResponseEntity.ok()
                                .contentType(MediaType.parseMediaType("application/pdf"))
                                .header(HttpHeaders.CONTENT_DISPOSITION,
                                                "attachment; filename=\"" + "etiquetas" + "idRecepcion" + ".pdf" + "\"")

                                .body(new ByteArrayResource(pdfResult));
        }

        /**
         * @param idPedido
         * @return ResponseEntity<Resource>
         * @throws IOException
         */
        @GetMapping("/etiquetas/pedido/{idPedido}")
        public ResponseEntity<Resource> crearEtiquetaPedido(@PathVariable Long idPedido) throws IOException {

                byte[] pdfResult = etiquetaService.crearEtiquetaPedido(pedidoService.findById(idPedido));
                return ResponseEntity.ok()
                                .contentType(MediaType.parseMediaType("application/pdf"))
                                .header(HttpHeaders.CONTENT_DISPOSITION,
                                                "attachment; filename=\"" + "etiquetas" + "idRecepcion" + ".pdf" + "\"")

                                .body(new ByteArrayResource(pdfResult));
        }

        /**
         * @param idProducto
         * @return ResponseEntity<Resource>
         * @throws IOException
         */
        @GetMapping("/etiquetas/tipoProducto/{idProducto}")
        public ResponseEntity<Resource> crearEtiquetaProducto(@PathVariable Long idProducto) throws IOException {

                byte[] pdfResult = etiquetaService.crearEtiquetaProducto(tipoProductoService.findOne(idProducto), 1);
                return ResponseEntity.ok()
                                .contentType(MediaType.parseMediaType("application/pdf"))
                                .header(HttpHeaders.CONTENT_DISPOSITION,
                                                "attachment; filename=\"" + "etiquetas" + "idRecepcion" + ".pdf" + "\"")

                                .body(new ByteArrayResource(pdfResult));
        }
}