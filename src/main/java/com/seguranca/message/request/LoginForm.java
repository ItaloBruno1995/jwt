package com.seguranca.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginForm {
	
@NotBlank
@Size(min = 3, max = 50)
private String nome;

@NotBlank
@Size(min = 3, max = 50)
private String senha;

	 
	
	

}
