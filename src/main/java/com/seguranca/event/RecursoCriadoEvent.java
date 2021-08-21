package com.seguranca.event;

import javax.servlet.http.HttpServletResponse;

import lombok.Data;

/*
 * CLASSE GENERICA PRA CRIAR RECURSOS DE  EVENTOS
 * PARA IMPREMENTAÇÃO EM OUTRAS CLASSES
 */
@Data
public class RecursoCriadoEvent<K,T> {

	private K id;
	private T recurso;
	private HttpServletResponse response;
	
	
	public RecursoCriadoEvent(T recurso) {
		this.recurso=recurso;
		
	}
	
	public RecursoCriadoEvent(K id, T recurso, HttpServletResponse response) {
		this.id=id;
		this.recurso=recurso;
		this.response=response;
		
	}
	
	
}
