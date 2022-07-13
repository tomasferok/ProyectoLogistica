package com.log.app.services.Interfaces;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.log.app.data.ReporteProductos;
import com.log.app.entidades.TipoProducto;
import com.log.app.helpers.ReporteProductosMasVendidos;

public interface ITipoProductoService {

	public List<TipoProducto> findAll();

	public TipoProducto save(TipoProducto idTipoProd);

	public TipoProducto findOne(Long idTipoProd);

	public void delete(Long idTipoProd);

	public List<TipoProducto> findByNombre(String nombre);

	public List<TipoProducto> findByProvedor_IdProv(Long idProv);

	public TipoProducto findByCodigoDeBarras(Integer codigoDeBarras);


	List<ReporteProductosMasVendidos>  productosMasVendidos(int year);
void update(TipoProducto tipoProd) ;

public String prueba();
}
