package com.seguranca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.seguranca.model.Pessoa;
import com.seguranca.service.PessoaService;

@SpringBootTest
class SegurancaApplicationTests {

	@Test
	void contextLoads() {
	}
	

	 @Autowired
	 private PessoaService pessoaService; //CLASSES QUE VOU TESTAR
	 
	 //OBJETO PARA PASSAR AO METODO:



	 @Test
	 public void buscarPorPessoaTeste() throws Exception {
		 
		
		 
		 Pessoa pessoa=  pessoaService.buscarPessoaPorId(Long.parseLong("1"));
		 
		 //SABER SE REALMENTE RETORNOU UMA PESSOA:
		 			//ESPERANDO,O QUE VEIO
		 assertEquals("Jonas", pessoa.getNome()); //COMAPARAÇÃO PRA SABER SE DA CERTO
		 assertEquals("1", String.valueOf(pessoa.getId()));
		 assertEquals("esticado",pessoa.getSobreNome());
		 //assertEquals("inveteemmim", pessoa.getSenha());
		 
		 //assertFalse(pessoa.isPresent);//usado para delete
	 }
		
	
	
	

}
