package com.log.app.services.Impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.ITipoProductoDao;
import com.log.app.data.ReporteProductos;
import com.log.app.entidades.TipoProducto;
import com.log.app.helpers.ReporteProductosMasVendidos;
import com.log.app.services.Interfaces.ITipoProductoService;

@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

	@Autowired
	ITipoProductoDao tipoProductoDao;

	@Override
	public List<TipoProducto> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoProducto>) tipoProductoDao.findAll();
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
	public TipoProducto findByCodigoDeBarras(Integer codigoDeBarras) {
		// TODO Auto-generated method stub
		return tipoProductoDao.findByCodigoDeBarras(codigoDeBarras);
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

	@Override
	public List<TipoProducto> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return tipoProductoDao.findByNombreIgnoreCaseContaining(nombre);
	}



	@Override
	public List<ReporteProductosMasVendidos> productosMasVendidos(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, 01, 01);
		Date startDate = calendar.getTime();
		calendar.set(year, 12, 31);
		Date endDate = calendar.getTime();

		return tipoProductoDao.productosMasVendidos(startDate, endDate);
	}

}
