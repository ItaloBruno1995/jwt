package com.seguranca.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "departamento")
@Data
public class Departamento {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(name = "nome")
private String nome;

@Column(name = "localizacao")
private  String localizacao;

/* Um departamento tem varias pessoas*/

@OneToMany
//@JoinColumn(name = "post_id") nao criar tabela intermediaria
private List<Pessoa> pessoas;
	

}
