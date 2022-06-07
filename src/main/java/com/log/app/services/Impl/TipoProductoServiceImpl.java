package com.log.app.services.Impl;

import java.util.List;

import com.log.app.Constants;
import com.log.app.data.Result;
import com.log.app.services.ITipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.ITipoProductoDao;
import com.log.app.entidades.TipoProducto;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

	@Autowired
	ITipoProductoDao tipoProductoDao;

	@Override
	public Result findAll() {
		// TODO Auto-generated method stub
		return new Result(Constants.RESULT_OK, tipoProductoDao.findAll());
	}

	@Override
	public void save(TipoProducto tipoProd) {

		tipoProductoDao.save(tipoProd);
	}

	@Override
	public TipoProducto findOne(Long idTipoProd) {
		// TODO Auto-generated method stub
		return tipoProductoDao.findById(idTipoProd).orElse(null);
	}
	


	@Override
	public void delete(Long idTipoProd) {
		tipoProductoDao.deleteById(idTipoProd);
	}

	@Override
	public List<TipoProducto> findByProvedor_IdProv(Long idProv) {
		// TODO Auto-generated method stub
		return tipoProductoDao.findByProvedor_IdProv(idProv);
	}

}
