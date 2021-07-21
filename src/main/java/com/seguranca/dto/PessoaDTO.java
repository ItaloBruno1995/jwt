package com.seguranca.dto;

import com.seguranca.model.Pessoa;

import lombok.Data;

//REPASSAR DADOS
@Data
public class PessoaDTO {

	private Long id;

	private String nome;

	private String sobreNome;
	
	
	
	//CONVERTER PESSOA PARA PESSOADTO
	public static PessoaDTO converter(Pessoa p) {
		PessoaDTO pessoa = new PessoaDTO();
		
		pessoa.setId(p.getId());
		pessoa.setNome(p.getNome());
		pessoa.setSobreNome(p.getSobreNome());
		
		return pessoa;
	}
	
}
