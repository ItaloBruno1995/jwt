package com.seguranca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.seguranca.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public Optional<Pessoa> findByNome(String login);
	
	
	/**
	 * Metodo usado no evento CRIPAR SENHA da pessoa
	 * @param Senha Cripada no evanto
	 * @param Id da pessoa criada
	 */
	@Modifying
	@Query("UPDATE Pessoa p SET p.senha = ?1 WHERE p.id = ?2")
	public void updateCriparSenha(String senhaCripada,  Long idPessoa);
	
	
	
}
