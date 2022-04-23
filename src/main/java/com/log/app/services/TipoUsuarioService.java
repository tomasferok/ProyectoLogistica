package com.log.app.services;

import java.util.List;

import com.log.app.daos.ITipoUsuarioDao;
import com.log.app.entidades.TipoUsuario;

import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {
    private ITipoUsuarioDao tipoUsuarioDao;

    public TipoUsuarioService(ITipoUsuarioDao tipoUsuarioDao) {
        this.tipoUsuarioDao = tipoUsuarioDao;
    }

    public TipoUsuario findById(Long id) {
        TipoUsuario tipoUsuario = tipoUsuarioDao.findById(id).get();
        
        return tipoUsuario;
    }
    public List<TipoUsuario> findAll() {
        List<TipoUsuario> tipoUsuarios = tipoUsuarioDao.findAll();
        
        return tipoUsuarios;
    }

}
