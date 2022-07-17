package com.log.app.services.Interfaces;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.log.app.data.ReporteProducto;
import com.log.app.entidades.Categoria;



public interface ICategoriaService {

	public List<Categoria> findAll();

	public Categoria save(Categoria categoria);
	
	public Categoria findOne(Long idCat);
	
	public void delete(Long idCat);

	List<Map<Object, Object>> reporteVentasPorCategoria(Integer year);

	public List<ReporteProducto> reporteCategoriaVentasAnual(Integer year, Long idCat);

	public List<ReporteProducto> reporteCategoriaComprasAnual(Integer year, Long idCat);

}
