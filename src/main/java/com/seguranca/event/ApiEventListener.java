package com.seguranca.event;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import org.springframework.context.event.*;

@Component
public class ApiEventListener<K, T> {
	
	@EventListener//FAZ COM O QUE O METODO ESCUTE UM EVENTO: RecursoCriadoEvent
	public  void adicionarHeaderLocation(RecursoCriadoEvent<K, T> event) {
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")	
				.buildAndExpand(event.getId()).toUri();
		
		
		//RETORNA A URI DO OBJETO CRIADO NO LOCATION, ASSIM QUE SALVAR A PESSOA
		event.getResponse().setHeader("Location", uri.toASCIIString());
		
	}

}
