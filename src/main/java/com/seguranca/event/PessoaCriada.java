package com.seguranca.event;

import javax.servlet.http.HttpServletResponse;

import com.seguranca.model.Pessoa;

import lombok.Data;

@Data
public class PessoaCriada extends RecursoCriadoEvent<Long, Pessoa>{
	
	private Pessoa pessoaCriada;
	
	public PessoaCriada( Pessoa pessoaCriada, HttpServletResponse response) {
		super(pessoaCriada.getId(), pessoaCriada, response);
		this.pessoaCriada=pessoaCriada;
	}



}
