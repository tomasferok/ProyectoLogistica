package com.log.app.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provedores")
public class Provedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProvedor;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "contacto")

    private String contacto;
    @Column(name = "email")

    private String email;
}
