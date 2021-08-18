package com.seguranca.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.seguranca.dto.PessoaPutDTO;
import com.seguranca.model.Pessoa;



@SpringBootTest//TESTE
@RunWith(SpringRunner.class)//EXECUTAR
@WebAppConfiguration //SOBE AS CONFIG NECESSARIAS
public class PessoaServiceTeste {
	
//TESTAR SERVIÇO:

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
