package com.seguranca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seguranca.data.DetalheUsuarioData;
import com.seguranca.model.Pessoa;
import com.seguranca.repository.PessoaRepository;

@Component
public class DetalhePessoaServiceImpl implements UserDetailsService{

	private final PessoaRepository pessoaRepository;
	
	public DetalhePessoaServiceImpl(PessoaRepository pessoaRepository) {
		this.pessoaRepository=pessoaRepository;
	}
	
	
	@Override //METODO QUE VAI FAZER A CONSULTA DO USER
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<Pessoa> pessoa= pessoaRepository.findByNome(username);
		
		if(pessoa== null) {
			throw new UsernameNotFoundException("Usuario " + username + " nao encontrado");
			
		}
		
		return new DetalheUsuarioData(pessoa);

	}
	
	
	
}
