package com.log.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;


/**
 * Configuracion de la aplicacion en el entorno de gcp
 * 
 * @author ClawTech - UTEC
 * @author www.clawtech.com.uy
 * @version 1.0
 * @since 1.0
 */

@Configuration
@PropertySource(value = "classpath:application-gcp.properties" )
@Profile("gcp")
public class PropertiSourceGcp {

}


