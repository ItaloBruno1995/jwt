package com.seguranca.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguranca.dto.PessoaDTO;
import com.seguranca.dto.PessoaPostDTO;
import com.seguranca.dto.PessoaPutDTO;
import com.seguranca.model.Pessoa;
import com.seguranca.repository.PessoaRepository;
import com.seguranca.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	private final PessoaRepository pessoarRepository;
	private final PessoaService pessoaService;
	
	//CONSTRUTOR( TUDO QUE CLASSE PRECISA RECEBER NO CONTRUTOR )
	public PessoaController(PessoaRepository pessoaRepository, PessoaService pessoaService) {
		this.pessoarRepository=pessoaRepository;
		this.pessoaService = pessoaService;
	}
	
	
	
	@GetMapping("/")
	public List<PessoaDTO> findAll(){
		List<Pessoa> pessoas= pessoarRepository.findAll() ;
		//LAMBDAS PARA CONVERTE E RETORNAR;
		//MAPEAR UMA PESSOA PARA PESSOADTO
		
		return 
				pessoas.stream()
				.map(pessoaService::converter)//MAPEANDO ENTIDADE PRA UMA PESSOADTO( CHAMADO O METODO CONVERTER DA PESSOADTO)
				.collect(Collectors.toList());//COLETANDO UMA LISTA
	}
	
	
	
	@GetMapping("/{id}")
	public PessoaDTO buscarPorId(@PathVariable("id") Long id) {
		
		Pessoa pessoa = pessoarRepository.getOne(id);
		return pessoaService.converter(pessoa);
		
	}
	
	@PostMapping("/save")
	public void salvar(@RequestBody PessoaPostDTO pessoa) {
		Pessoa p= pessoaService.save(pessoa);
		pessoarRepository.save(p);
		
		
	}
	
	
	@PutMapping("/{id}")
	public void atualizarPessoa(@PathVariable Long id ,@RequestBody PessoaPutDTO pessoa) throws Exception {
		
		Pessoa p = pessoaService.alterarSenha(id, pessoa);
		
		pessoarRepository.save(p);
		
	}
	

}
