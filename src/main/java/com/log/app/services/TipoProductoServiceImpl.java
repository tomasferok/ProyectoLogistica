package com.log.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.ITipoProductoDao;
import com.log.app.entidades.TipoProducto;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

	@Autowired
	ITipoProductoDao productoService;

	@Override
	public List<TipoProducto> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoProducto>) productoService.findAll();
	}

	@Override
	public void save(TipoProducto tipoProd) {
		productoService.save(tipoProd);
	}

	@Override
	public TipoProducto findOne(Long idTipoProd) {
		// TODO Auto-generated method stub
		return productoService.findById(idTipoProd).orElse(null);
	}

	@Override
	public void delete(Long idTipoProd) {
		productoService.deleteById(idTipoProd);
	}

}
