package com.log.app.helpers;

import com.log.app.entidades.Usuario;

/**
 * Clase representativa de un response de autenticacion
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */
public class AuthenticationResponse {
    private String jwt;

    String email;
    
    Long idUsuario;

  

    


    public AuthenticationResponse(String jwt, String email, Long idUsuario) {
        this.jwt = jwt;
        this.email = email;
        this.idUsuario = idUsuario;
    }

    



    public String getEmail() {
        return email;
    }





    public void setEmail(String email) {
        this.email = email;
    }





    public Long getIdUsuario() {
        return idUsuario;
    }





    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }





    public String getJwt() {
        return jwt;
    }


    public void setJwt(String jwt) {
        this.jwt = jwt;
    }


    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

}
