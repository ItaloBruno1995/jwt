package com.seguranca.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean //fabrica de objetos
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}
	
}
