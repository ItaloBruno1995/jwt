package com.seguranca.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.seguranca.dto.PessoaAuthenticationRequestDTO;
import com.seguranca.dto.PessoaDTO;
import com.seguranca.dto.PessoaPostDTO;
import com.seguranca.dto.PessoaPutDTO;
import com.seguranca.model.Pessoa;
import com.seguranca.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private final PessoaRepository pessoarRepository;
	
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
	
	
	//salvar 
	public Pessoa save(PessoaPostDTO pessoaPost) {
		Pessoa pessoa = new Pessoa();
		
		
		
		pessoa.setNome(pessoaPost.getNome());
		pessoa.setSobreNome(pessoaPost.getSobreNome());
		pessoa.setSenha(pessoaPost.getSenha());
		
		return pessoa;
		
		
	}
	
	//alterar senha 
	public Pessoa alterarSenha(Long id,PessoaPutDTO pessoa) throws Exception {
		Pessoa pessoaPut = new Pessoa();
		
		Optional<Pessoa>  p = pessoarRepository.findById(id);
		
		
		//VERIFICAR SE EXISTE:
			if(p.isPresent()) {
				pessoaPut= p.get();
				pessoaPut.setSenha(pessoa.getSenha());
		//INCRIPT DE SENHA AQUI:
				
				
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
	
	
	
	
	
}
