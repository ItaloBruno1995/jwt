package com.seguranca.dto;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data

public class PessoaAuthenticationRequestDTO implements UserDetailsService {
	
	private String Nome;
	private String Senha;
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
