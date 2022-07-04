package com.log.app.helpers;

import java.util.Map;

/*
 */
 *Esta clase representa los parametros solicitados para controlar una recepcion
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */


public class ControlarRecepcionRequest {
    

    private Long idRecepcion;
    private Map<Long, Double> productosRecibidos;
    private Long idUsuario;
    private Boolean controlarDiferencias;


    public Long getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(Long idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    public Map<Long, Double> getProductosRecibidos() {
        return productosRecibidos;
    }

    public void setProductosRecibidos(Map<Long, Double> productosRecibidos) {
        this.productosRecibidos = productosRecibidos;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getControlarDiferencias() {
        return controlarDiferencias;
    }

    public void setControlarDiferencias(Boolean controlarDiferencias) {
        this.controlarDiferencias = controlarDiferencias;
    }

    public ControlarRecepcionRequest(Long idRecepcion, Map<Long, Double> productosRecibidos, Long idUsuario, Boolean controlarDiferencias) {
        this.idRecepcion = idRecepcion;
        this.productosRecibidos = productosRecibidos;
        this.idUsuario = idUsuario;
        this.controlarDiferencias = controlarDiferencias;
    }

    public ControlarRecepcionRequest() {
    }

}
