package com.log.app.services.Impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.log.app.entidades.Pedido;
import com.log.app.entidades.Producto;
import com.log.app.entidades.Recepcion;
import com.log.app.entidades.RecepcionProducto;
import com.log.app.entidades.TipoProducto;
import com.log.app.helpers.GeneratorEtiquetas;
import com.log.app.services.Interfaces.IEtiquetaService;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

/**
 * EtiquetaService es una clase que implementa la interfaz IEtiquetaService
 * y sirve para crear etiquetas de pedidos, recepciones, y
 * codigos de barra de productos
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */


@Service
public class EtiquetaService implements IEtiquetaService {
    EtiquetaService() {

    }

    
    GeneratorEtiquetas etiquetasGenerator = new GeneratorEtiquetas();

    
    /** 
     * Crea una etiqueta de recepcion
     * @param recepcion
     * @return byte[]
     * @throws IOException
     */
    @Override
    public byte[] crearEtiquetaRecepcion(Recepcion recepcion) throws IOException {
        // TODO Auto-generated method stub
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PDDocument MyPDF = etiquetasGenerator.createRemitoRecepcion(recepcion);
        MyPDF.save(output);
        MyPDF.close();

        return output.toByteArray();
    }


    
    /** 
     * Crea etiquetas para los productos de una recepcion
     * @param recepcion
     * @return byte[]
     * @throws IOException
     */
    @Override
    public byte[] crearEtiquetaCodigosDeBarraProductos(Recepcion recepcion) throws IOException {
        // TODO Auto-generated method stub
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PDDocument MyPDF = etiquetasGenerator.createEtiquetasProductoRecepcion(recepcion);
        MyPDF.save(output);
        MyPDF.close();
        return output.toByteArray();
    }

    
    /** 
     * Crea una etiqueta de pedido
     * @param pedido
     * @return byte[]
     * @throws IOException
     */
    @Override
    public byte[] crearEtiquetaPedido(Pedido pedido) throws IOException {
        // TODO Auto-generated method stub
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PDDocument MyPDF = etiquetasGenerator.createRemitoPedido(pedido);
        MyPDF.save(output);
        MyPDF.close();
        return output.toByteArray();
    }

    
    /** 
     * Crea una etiqueta de pedido pendiente
     * @param pedido
     * @return byte[]
     * @throws IOException
     */
    @Override
    public byte[] crearEtiquetaPedidoPendiente(Pedido pedido) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    
    /** 
     * Crea una etiqueta de pedido despacho
     * @param pedido
     * @return byte[]
     * @throws IOException
     */
    @Override
    public byte[] crearEtiquetaPedidoDespacho(Pedido pedido) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    
    /** 
     * Crea una etiqueta de pedido entrega
     * @param pedido
     * @return byte[]
     * @throws IOException
     */
    @Override
    public byte[] crearEtiquetaPedidoEntrega(Pedido pedido) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    
    /**
     * Crea una etiqueta de producto
     * 
     * @param tipoProducto
     * @return byte[]
     * @throws IOException
     */
    @Override
    public byte[] crearEtiquetaProducto(TipoProducto tipoProducto, int cantidad) throws IOException {
        // TODO Auto-generated method stub
        List<TipoProducto> productos =  new ArrayList<TipoProducto>();

        for (int i = 0; i < cantidad; i++) {
            productos.add(tipoProducto);
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PDDocument MyPDF = etiquetasGenerator.createEtiquetasListadoProductos(productos);
        MyPDF.save(output);
        MyPDF.close();
        return output.toByteArray();
    }
}