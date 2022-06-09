package com.log.app.daos;

import com.log.app.entidades.Recepcion;

import com.log.app.entidades.TipoEstadoRecepcion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IRecepcionDao extends JpaRepository<Recepcion, Long> {
    long countByEstadoRecepcion_TipoEstado(TipoEstadoRecepcion tipoEstado);


    List<Recepcion> findByFechaRecepcionIsBetween(Date fechaRecepcionStart, Date fechaRecepcionEnd);









}
