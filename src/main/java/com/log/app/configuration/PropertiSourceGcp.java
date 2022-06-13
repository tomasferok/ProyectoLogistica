package com.log.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application-gcp.properties" )
@Profile("gcp")
public class PropertiSourceGcp {

}


