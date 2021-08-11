package com.seguranca.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;


@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "nome")
private String nome;

@Column(name = "sobreNome")
private String sobreNome;

@Column(name = "senha")
private String senha;







}


