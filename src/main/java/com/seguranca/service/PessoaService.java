package com.seguranca.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seguranca.SegurancaApplication;
import com.seguranca.dto.PessoaAuthenticationRequestDTO;
import com.seguranca.dto.PessoaDTO;
import com.seguranca.dto.PessoaPostDTO;
import com.seguranca.dto.PessoaPutDTO;
import com.seguranca.event.PessoaCriada;
import com.seguranca.model.Pessoa;
import com.seguranca.repository.PessoaRepository;

@Service
public class PessoaService {
	
	//LOG:
	private static Logger logger = LoggerFactory.getLogger(PessoaService.class);
	
	
	
	private final PessoaRepository pessoarRepository;
	
	//MODELMAPPER:
	@Autowired
	private ModelMapper modelmapepr;
	
	
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoarRepository=pessoaRepository;
	}

	

	
	//CONVERTER PESSOA PARA PESSOADTO
	public  PessoaDTO converter(Pessoa pessoa) {
		PessoaDTO pessoaFindDto = new PessoaDTO();
		
		pessoaFindDto.setId(pessoa.getId());
		pessoaFindDto.setNome(pessoa.getNome());
		pessoaFindDto.setSobreNome(pessoa.getSobreNome());
		
		return pessoaFindDto;
		
	
	}
	
	

	
	
	
	//TESTE UNITARIO* 
	//alterar senha 
	public Pessoa alterarSenha(Long id,PessoaPutDTO pessoa) throws Exception {
		Pessoa pessoaPut = new Pessoa();
		
		Optional<Pessoa>  p = pessoarRepository.findById(id);
		
		
		//VERIFICAR SE EXISTE:
			if(p.isPresent()) {
				
				pessoaPut= p.get();
				pessoaPut.setSenha(pessoa.getSenha());
		//INCRIPT DE SENHA AQUI(?):
				

				return pessoaPut;
				
			}
			
			//NAO EXISTE:
			else {
				
						throw new Exception("Pessoa Não Encontrada!");
				
			}
		
		
	}
	
	public Pessoa authentication(PessoaAuthenticationRequestDTO  pessoa) {
		Pessoa p = new Pessoa();
		p.setNome(pessoa.getNome());
		p.setSenha(pessoa.getSenha());
		return p;
		
	}
	
	
	
	public Pessoa buscarPessoaPorId(Long id) throws Exception{
	
	
		
		Optional<Pessoa>  p = pessoarRepository.findById(id);
		Pessoa pessoa = null;
		
				
		if(!p.isPresent()) {
			logger.info("Pessoa com id: "+id+" Nao encontrada");
			throw new Exception("Pessoa não encontrada para o Id: "+id);
			
		}else {
			logger.info("Pessoa com id: "+id+ " encontrada");
			pessoa= p.get();
		
		}
		return pessoa;
	}
	
	
	//SAVE
	public Pessoa save(Pessoa pessoa) throws Exception{
		
		// VALIDAÇÃO ANTES DE SALVAR:
		
		if ( pessoa == null) {
			throw new Exception("Objeto vazio");
			
		}else {
			
			return pessoa;
			
		}
		
		
	}
	
	
	
	
	//EVENTOS:
	@Async//PROCESSAMENTO DO METODO : ASSICRONO
	@EventListener//OUVIR
	public void ComprovanteDePessoaCriada(PessoaCriada pessoaCriadaEvent) throws Exception {
		Pessoa pessoa = new Pessoa();
		
		pessoa = buscarPessoaPorId(pessoaCriadaEvent.getId());
		

	
		logger.info("Pessoa:  "+pessoa.getNome()+" "+pessoa.getSobreNome()+", Criada com Sucesso");
		logger.info("Pessoa Criada com sucesso");
		
		
		
	}
	
	
	//EVENTO: CRIPAR SENHA AO SALVAR DADOS NO BANCO
	@EventListener
	@Transactional//QUERYUPDATE
	public void CriparSenhaAoSalvarPessoa(PessoaCriada pessoaCriadaEvent) throws Exception {
		
		Pessoa pessoa = new Pessoa();
		
		pessoa = buscarPessoaPorId(pessoaCriadaEvent.getId());
		
		String encodedPassword = new BCryptPasswordEncoder().encode(pessoa.getSenha());

		pessoarRepository.updateCriparSenha(encodedPassword, pessoa.getId());
	
	}




	
	
	
	
	
	
}
