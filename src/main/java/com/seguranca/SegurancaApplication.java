package com.seguranca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.seguranca") //scanearProject
@EntityScan(basePackages = "com.seguranca.model") //scanearJPA
public class SegurancaApplication {

	private static Logger looger= LoggerFactory.getLogger(SegurancaApplication.class);	
	
	
	public static void main(String[] args) {
		
	looger.info("Iniciando a api");
		
		SpringApplication.run(SegurancaApplication.class, args);
		
		
	looger.info("API Iniciada");
	}

}
