package com.log.app.services.Interfaces;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import com.log.app.entidades.Pedido;
import com.log.app.entidades.Producto;
import com.log.app.entidades.Recepcion;
import com.log.app.entidades.TipoProducto;

public interface IEtiquetaService {
    public byte[] crearEtiquetaRecepcion(Recepcion recepcion) throws IOException;

    public byte[] crearEtiquetaPedido(Pedido pedido) throws IOException;
    
    public byte[] crearEtiquetaPedidoPendiente(Pedido pedido) throws IOException;

    public byte[] crearEtiquetaPedidoDespacho(Pedido pedido) throws IOException;

    public byte[] crearEtiquetaPedidoEntrega(Pedido pedido) throws IOException;

    public byte[] crearEtiquetaProducto(TipoProducto tipoProducto, int cantidad) throws IOException;

    public byte[] crearEtiquetaCodigosDeBarraProductos(Recepcion recepcion) throws IOException;
}
