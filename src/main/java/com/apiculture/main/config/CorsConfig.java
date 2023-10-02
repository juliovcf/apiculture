package com.apiculture.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // Esto es necesario en versiones más recientes de Spring Boot
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // Permite solicitudes desde cualquier origen
        .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
        .allowedHeaders("*") // Cabeceras permitidas
        .allowCredentials(false) // No permite credenciales (por defecto)
        .maxAge(3600); // Tiempo máximo de caché de preflights (en segundos)
  }
}
