package com.log.app.services;

import java.util.List;

import com.log.app.data.Result;
import com.log.app.entidades.TipoProducto;

public interface ITipoProductoService {

	public Result findAll();

	public void save(TipoProducto idTipoProd);
	
	public TipoProducto findOne(Long idTipoProd);
	
	public void delete(Long idTipoProd);


	public List<TipoProducto> findByProvedor_IdProv(Long idProv);
}
