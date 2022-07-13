package com.log.app.services.Impl;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
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
	private Storage storage;

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
		stock.setTipoProducto(productoCreado);
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

	@Override

	public String prueba() {
		String value = "Hello, World!";
		byte[] bytes = value.getBytes();
		Bucket bucket = storage.get("clawtechpics");
		Blob blob = bucket.create("clawtechpics", bytes);
		blob.getSelfLink();
		Blob blob1   = bucket.get("clawtechpics");
		String s = new String(blob1.getContent());

		return blob.getSelfLink();
	}


	public String saveImage(MultipartFile file, String tipoProductoNombre) {
		byte[] bytes;
		try {
			bytes = file.getBytes();
			Bucket bucket = storage.get("clawtechpics");
			Blob blob = bucket.create("tipoProducto/" + tipoProductoNombre + ".png", bytes);
			blob.getSelfLink();
			return blob.getSelfLink();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
