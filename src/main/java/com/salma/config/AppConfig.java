package com.salma.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.salma")  // Scan automatique des composants
@Import({JpaConfig.class, WebConfig.class})  // Importe les autres configurations
public class AppConfig {
    
}