package com.seguranca.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seguranca.dto.PessoaAuthenticationRequestDTO;
import com.seguranca.dto.PessoaAuthenticationResponseDTO;
import com.seguranca.dto.PessoaDTO;
import com.seguranca.dto.PessoaPostDTO;
import com.seguranca.dto.PessoaPutDTO;

import com.seguranca.model.Pessoa;
import com.seguranca.repository.PessoaRepository;

import com.seguranca.service.PessoaService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "API REST Usuarios") //SW :http://localhost:8080/swagger-ui.html#/
@CrossOrigin(origins = "*")//LIBERAR DOMINIO
public class PessoaController {
	
	private final PessoaRepository pessoarRepository;
	private final PessoaService pessoaService;
	
	

	//CONSTRUTOR( TUDO QUE CLASSE PRECISA RECEBER NO CONTRUTOR )
	public PessoaController(PessoaRepository pessoaRepository, PessoaService pessoaService
							) {
		this.pessoarRepository=pessoaRepository;
		this.pessoaService = pessoaService;

	
		
	}
	
	
	
	@GetMapping("/")
	@ApiOperation(value = "Retorna todos os usuarios")
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
	@ApiOperation(value = "Retorna um unico usuario")
	public PessoaDTO buscarPorId(@PathVariable("id") Long id) {
		
		Pessoa pessoa = pessoarRepository.getOne(id);
		return pessoaService.converter(pessoa);
		
	}
	
	@PostMapping("/save")
	@ApiOperation(value = "Salva um usario")
	public void salvar(@RequestBody PessoaPostDTO pessoa) {
		Pessoa p= pessoaService.save(pessoa);
		pessoarRepository.save(p);
		
		
	}
	
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Altera a Senha de Um Usuario")
	public void atualizarPessoa(@PathVariable Long id ,@RequestBody PessoaPutDTO pessoa) throws Exception {
		
		Pessoa p = pessoaService.alterarSenha(id, pessoa);
		//ENCRIPT SENHA
		String encodedPassword = new BCryptPasswordEncoder().encode(p.getSenha());
		p.setSenha(encodedPassword);
		
		pessoarRepository.save(p);
		
	}
	
	
	
	//LOGIN
	

	
	//CRIAR DELETE

}
