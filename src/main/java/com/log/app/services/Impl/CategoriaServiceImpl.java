package com.log.app.services.Impl;

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

	public Map<Categoria, Map<Date, Double>> reporteVentasPorCategoria(Integer year) {
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
		Map<Categoria, Map<Date, Double>> mapVentasPorCategoria = new HashMap<Categoria, Map<Date, Double>>();
		for (Categoria categoria : categorias) {
			Map<Date, Double> mapVentasPorMes = new HashMap<Date, Double>();
			List<ReporteCategorias> reporteProductosCategoria = reporteProductos.stream()
					.filter(reporte -> reporte.getIdCat() == categoria.getIdCat())
					.collect(Collectors.toList());
			while (calendar.getTime().before(endDate) && calendar.getTime().before(fechaActual)) {
				Date fecha = calendar.getTime();
				Double cantidad = 0d;
				List<ReporteCategorias> reporteProductosDelMes = reporteProductosCategoria.stream()
						.filter(reporte -> reporte.getYear().equals(calendar.get(Calendar.YEAR)))
						.filter(reporte -> reporte.getMes().equals(calendar.get(Calendar.MONTH) + 1))
						.collect(Collectors.toList());
				for (ReporteCategorias reporteCategorias : reporteProductos) {
					System.out.println(reporteCategorias.getYear() + " " + reporteCategorias.getMes());
					System.out.println(calendar.get(Calendar.YEAR) + " " + (calendar.get(Calendar.MONTH) + 1));
				}
				for (ReporteCategorias reporteCategorias : reporteProductosDelMes) {
					cantidad += reporteCategorias.getCantidad();
				}

				mapVentasPorMes.put(fecha, cantidad);
				calendar.add(Calendar.MONTH, 1);
			}
			mapVentasPorCategoria.put(categoria, mapVentasPorMes);
			calendar.setTime(startDate);
		}

		return mapVentasPorCategoria;

	}
}
