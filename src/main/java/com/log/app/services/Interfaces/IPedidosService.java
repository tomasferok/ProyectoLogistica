package com.log.app.services.Interfaces;

import java.util.List;

import com.log.app.data.ReporteProductosInterface;
import com.log.app.entidades.Pedido;
import com.log.app.entidades.Usuario;

public interface IPedidosService {
    public Pedido save(Pedido pedido);

    public List<Pedido> findAll();

    List<ReporteProductosInterface> reporteProductoVendidoAnual(int year, long idProducto);

    List<Pedido> findByDistribuidor_UsuarioAndDuracionFinalNull(Long id);
    
}
