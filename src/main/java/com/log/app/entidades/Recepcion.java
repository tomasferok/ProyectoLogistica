package com.log.app.entidades;

import com.log.app.Constants;
import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Data
@Table(name = "recepciones")
public class Recepcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecepcion;

    @Column(name = "fecha_recepcion")
    private Date fechaRecepcion;

    @ManyToOne
    private Proveedor provedor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "recepcion_id_recepcion")
    private List<RecepcionProducto> productos;

    @Column(name = "estado")
    private String estado = Constants.PEDIDO_RECIBIDO;

    @Column(name = "codigo")
    private String codigo;

}