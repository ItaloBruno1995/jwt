package com.seguranca.data;

import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.seguranca.model.Pessoa;


//DETALHES DO USUARIO
public class DetalheUsuarioData implements UserDetails {

	
	
	private final Optional<Pessoa> pessoa;
	
	public DetalheUsuarioData(Optional<Pessoa> pessoa) {
		this.pessoa=pessoa;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	@Override
	public String getPassword() {
		
		return pessoa.orElse(new Pessoa()).getSenha();
	}

	@Override
	public String getUsername() {
		
		return pessoa.orElse(new Pessoa()).getSenha();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
