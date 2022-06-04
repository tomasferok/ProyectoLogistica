package com.log.app.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application-prod.properties" )
@Profile("prod")
public class PropertiSourceProd {

}


