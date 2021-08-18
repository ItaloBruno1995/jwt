package com.seguranca.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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

import com.seguranca.SegurancaApplication;
import com.seguranca.data.DetalheUsuarioData;
import com.seguranca.dto.PessoaAuthenticationRequestDTO;
import com.seguranca.dto.PessoaAuthenticationResponseDTO;
import com.seguranca.dto.PessoaDTO;
import com.seguranca.dto.PessoaPostDTO;
import com.seguranca.dto.PessoaPutDTO;

import com.seguranca.model.Pessoa;
import com.seguranca.repository.PessoaRepository;
import com.seguranca.security.JWTConfiguracao;
import com.seguranca.service.DetalhePessoaServiceImpl;
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
	
	@Autowired
	private ModelMapper modelmapepr;
	
	

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
	public PessoaDTO buscarPorId(@PathVariable("id") Long id) throws Exception {
		PessoaDTO dto = new PessoaDTO();
		/*Pessoa pessoa = pessoarRepository.getOne(id);
		return pessoaService.converter(pessoa);
		*/
		/*LOG*/
		
		
	
		Pessoa pessoa = pessoaService.buscarPessoaPorId(id);
		
		
		//CONVERTER PARA DTO
		
		/*
		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getNome());
		dto.setSobreNome(pessoa.getSobreNome());
		*/		
		
		//CONVERTER E RETORNAR PESSOA PARA pessoaDTO
		return modelmapepr.map(pessoa, PessoaDTO.class);
		
	}
	
	
	@PostMapping("/save")
	@ApiOperation(value = "Salva um usario")
	public void salvar(@RequestBody PessoaPostDTO pessoa) {
		Pessoa p= pessoaService.save(pessoa);
		pessoarRepository.save(p);
		
		
	}
	
	
	@PutMapping("senha/{id}")
	@ApiOperation(value = "Altera a Senha de Um Usuario")
	public void atualizarPessoa(@PathVariable Long id ,@RequestBody PessoaPutDTO pessoa) throws Exception {
		
		Pessoa p = pessoaService.alterarSenha(id, pessoa);
		//ENCRIPT SENHA
		String encodedPassword = new BCryptPasswordEncoder().encode(p.getSenha());
		p.setSenha(encodedPassword);
		
		pessoarRepository.save(p);
		
	}
	
	
	
	//LOGIN
	//*http://localhost:8080/login
	//*PASSAR USERNAME E SENHA DO OBJETO
	
	//CRIAR DELETE

}
