package com.log.app.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tipo_usuarios")
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario", nullable = false, unique = true)
    private Long idTipoUsuario;
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "tipoUsuario", fetch = javax.persistence.FetchType.EAGER)
    @JsonManagedReference
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public TipoUsuario(String nombre) {
        this.nombre = nombre;
    }

    public TipoUsuario() {
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        idTipoUsuario = idTipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

   

    
}
