package com.seguranca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.seguranca.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public Optional<Pessoa> findByNome(String login);
	
	
}
