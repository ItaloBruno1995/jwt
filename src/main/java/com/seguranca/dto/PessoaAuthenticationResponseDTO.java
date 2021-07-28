package com.seguranca.dto;

import lombok.Data;

@Data
public class PessoaAuthenticationResponseDTO {
private final String jwt;
	
	 public PessoaAuthenticationResponseDTO(String jwt) {
		this.jwt = jwt;
	}
}
