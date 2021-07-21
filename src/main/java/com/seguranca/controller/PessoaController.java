package com.seguranca.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguranca.dto.PessoaDTO;
import com.seguranca.model.Pessoa;
import com.seguranca.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	private final PessoaRepository pessoarRepository;
	
	//CONSTRUTOR( TUDO QUE CLASSE PRECISA RECEBER NO CONTRUTOR )
	public PessoaController(PessoaRepository pessoarRepository) {
		this.pessoarRepository=pessoarRepository;
	}
	
	
	@GetMapping("/")
	public List<PessoaDTO> findAll(){
		List<Pessoa> pessoas= pessoarRepository.findAll() ;
		//LAMBDAS PARA CONVERTE E RETORNAR;
		//MAPEAR UMA PESSOA PARA PESSOADTO
		return pessoas.stream()
				.map(PessoaDTO::converter)//MAPEANDO ENTIDADE PRA UMA PESSOADTO( CHAMADO O METODO CONVERTER DA PESSOADTO)
				.collect(Collectors.toList());//COLETANDO UMA LISTA
	}

}
