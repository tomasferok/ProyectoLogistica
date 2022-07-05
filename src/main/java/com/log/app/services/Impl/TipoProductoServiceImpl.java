package com.log.app.services.Impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.app.daos.ITipoProductoDao;
import com.log.app.data.ReporteProductos;
import com.log.app.entidades.Producto;
import com.log.app.entidades.TipoProducto;
import com.log.app.helpers.ReporteProductosMasVendidos;
import com.log.app.services.Interfaces.IProductoService;
import com.log.app.services.Interfaces.ITipoProductoService;

/**
 * Servicio de la entidad TipoProducto
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
@Service
public class TipoProductoServiceImpl implements ITipoProductoService {

	@Autowired
	ITipoProductoDao tipoProductoDao;

	@Autowired
	IProductoService productoService;
	/**
	 * @return List<TipoProducto>
	 */
	

	@Override
	public List<TipoProducto> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoProducto>) tipoProductoDao.findAll();

	}

	/**
	 * @param tipoProd
	 */
	@Override
	public TipoProducto save(TipoProducto tipoProd) {
		TipoProducto productoCreado = tipoProductoDao.save(tipoProd);
		Producto stock = new Producto();
		stock.setIdProd(productoCreado.getIdTipoProd());
		productoService.saveEmpyProducto(stock);
		return productoCreado;
	}

	@Override
	public void update(TipoProducto tipoProd) {
		tipoProductoDao.save(tipoProd);
	}

	/**
	 * @param idTipoProd
	 * @return TipoProducto
	 */

	@Override
	public TipoProducto findOne(Long idTipoProd) {
		// TODO Auto-generated method stub
		return tipoProductoDao.findById(idTipoProd).orElse(null);

	}

	/**
	 * @param codigoDeBarras
	 * @return TipoProducto
	 */
	@Override
	public TipoProducto findByCodigoDeBarras(Integer codigoDeBarras) {
		// TODO Auto-generated method stub
		return tipoProductoDao.findByCodigoDeBarras(codigoDeBarras);

	}

	/**
	 * @param idTipoProd
	 */
	@Override
	public void delete(Long idTipoProd) {
		tipoProductoDao.deleteById(idTipoProd);

	}

	/**
	 * @param idProv
	 * @return List<TipoProducto>
	 */
	@Override
	public List<TipoProducto> findByProvedor_IdProv(Long idProv) {
		// TODO Auto-generated method stub
		return tipoProductoDao.findByProvedor_IdProv(idProv);

	}

	/**
	 * @param nombre
	 * @return List<TipoProducto>
	 */
	@Override
	public List<TipoProducto> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return tipoProductoDao.findByNombreIgnoreCaseContaining(nombre);
	}

	/**
	 * @param year
	 * @return List<ReporteProductosMasVendidos>
	 */

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
