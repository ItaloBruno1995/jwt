package com.seguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seguranca.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	
}
