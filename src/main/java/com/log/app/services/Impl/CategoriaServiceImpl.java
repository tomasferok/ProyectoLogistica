package com.log.app.services.Impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.log.app.daos.ICategoriaDao;
import com.log.app.data.ReporteCategorias;
import com.log.app.data.ReporteProducto;
import com.log.app.data.ReporteProductosInterface;
import com.log.app.entidades.Categoria;
import com.log.app.services.Interfaces.ICategoriaService;

/**
 * Servicio de la entidad Categoria
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaDao categoriaDao;

	/**
	 * @return List<Categoria>
	 */

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return categoriaDao.findAll();
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaDao.
		/**
		 * @param idCat
		 * @return Categoria
		 */
				save(categoria);

	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findOne(Long idCat) {
		// TODO Auto-generated method stub
		return categoriaDao.findById(
				/**
				 * @param idCat
				 */
				idCat).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idCat) {
		categoriaDao.deleteById(idCat);
	}

	@Override

	public List<Map<Object, Object>> reporteVentasPorCategoria(Integer year) {
		List<Categoria> categorias = categoriaDao.findAll();
		Calendar calendar = Calendar.getInstance();
		Date fechaActual = new Date();
		calendar.set(year.intValue(), 0, 1);
		Date startDate = calendar.getTime();
		calendar.set(year.intValue(), 11, 31);
		Date endDate = calendar.getTime();
		List<ReporteCategorias> reporteProductos = categoriaDao
				.sumProductosPorCategoriaByMonth(startDate, endDate);
		calendar.setTime(startDate);
		List<Map<Object, Object>> reporteAnual = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> mapVentasPorCategoria = new HashMap<Object, Object>();
		while (calendar.getTime().before(endDate) && calendar.getTime().before(fechaActual)) {
			Date fecha = calendar.getTime();
			mapVentasPorCategoria.put("date", fecha);
			List<ReporteCategorias> reporteProductosDelMes = reporteProductos.stream()
					.filter(reporte -> reporte.getYear().equals(calendar.get(Calendar.YEAR)))
					.filter(reporte -> reporte.getMes().equals(calendar.get(Calendar.MONTH) + 1))
					.collect(Collectors.toList());
			for (Categoria categoria : categorias) {
				Double cantidad = reporteProductosDelMes.stream()
						.filter(reporte -> reporte.getIdCat().equals(categoria.getIdCat()))
						.mapToDouble(reporte -> reporte.getCantidad()).sum();
				mapVentasPorCategoria.put(categoria.getNombre(), cantidad);
			}
			calendar.add(Calendar.MONTH, 1);
			reporteAnual.add(mapVentasPorCategoria);
			System.out.println(calendar.getTime());
			mapVentasPorCategoria = new HashMap<Object, Object>();
		}
		return reporteAnual;
	}

	@Override

	public List<ReporteProducto> reporteCategoriaVentasAnual(Integer year, Long idCat){
		List<ReporteProducto> reporteFinal = new ArrayList<ReporteProducto>();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year.intValue(), 0, 1);
		Date startDate = calendar.getTime();
		calendar.set(year.intValue(), 11, 31);
		Date endDate = calendar.getTime();
		calendar.setTime(startDate);
		List<ReporteProductosInterface> reporteInicial = categoriaDao.sumProductosVendidosByMonthBetweenFechasByCategoria(startDate,endDate, idCat);
		while (calendar.getTime().before(endDate) && calendar.getTime().before(new Date())) {
			ReporteProducto reporteMensual = new ReporteProducto();
			Double cantidad = reporteInicial.stream()
					.filter(reporte -> reporte.getMes().equals(calendar.get(Calendar.MONTH) + 1))
					.filter(reporte -> reporte.getYear().equals(calendar.get(Calendar.YEAR)))
					.mapToDouble(reporte -> reporte.getCantidad()).sum();

			reporteMensual.setCantidad(cantidad);
			reporteMensual.setMes(calendar.get(Calendar.MONTH) + 1);
			reporteMensual.setYear(calendar.get(Calendar.YEAR));
			reporteFinal.add(reporteMensual);

			calendar.add(Calendar.MONTH, 1);
		}
	

	return reporteFinal;
	}

	public List<ReporteProducto> reporteCategoriaComprasAnual(Integer year, Long idCat){
		List<ReporteProducto> reporteFinal = new ArrayList<ReporteProducto>();

		Calendar calendar = Calendar.getInstance();
		calendar.set(year.intValue(), 0, 1);
		Date startDate = calendar.getTime();
		calendar.set(year.intValue(), 11, 31);
		Date endDate = calendar.getTime();
		calendar.setTime(startDate);
		List<ReporteProductosInterface> reporteInicial = categoriaDao
				.sumProductosSolicitadosByMonthBetweenFechasByCategoria(startDate, endDate, idCat);
		while (calendar.getTime().before(endDate) && calendar.getTime().before(new Date())) {
			ReporteProducto reporteMensual = new ReporteProducto();
			Double cantidad = reporteInicial.stream()
					.filter(reporte -> reporte.getMes().equals(calendar.get(Calendar.MONTH) + 1))
					.filter(reporte -> reporte.getYear().equals(calendar.get(Calendar.YEAR)))
					.mapToDouble(reporte -> reporte.getCantidad()).sum();

			reporteMensual.setCantidad(cantidad);
			reporteMensual.setMes(calendar.get(Calendar.MONTH) + 1);
			reporteMensual.setYear(calendar.get(Calendar.YEAR));
			reporteFinal.add(reporteMensual);

			calendar.add(Calendar.MONTH, 1);
		}

		return reporteFinal;
	}

}
