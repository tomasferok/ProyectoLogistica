package com.log.app.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Boolean active;

    @ManyToOne
    private TipoUsuario tipoUsuario;


    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String email, String password, Boolean active, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.active = active;
        this.tipoUsuario = tipoUsuario;
    }
}
