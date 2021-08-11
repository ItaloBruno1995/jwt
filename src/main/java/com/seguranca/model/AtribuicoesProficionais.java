package com.seguranca.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "AtribuicoesProficionais")
@Data
public class AtribuicoesProficionais {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "descricao")
private String descricao;


//MUITOS ATRIBUTOS PARA UMA PESSOA
@ManyToOne(targetEntity = Pessoa.class)
private Pessoa pessoa;

	

}
