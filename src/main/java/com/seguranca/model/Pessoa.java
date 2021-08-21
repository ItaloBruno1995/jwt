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
import javax.validation.constraints.NotNull;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NonNull;


@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotNull
@Column(name = "nome")
private String nome;
@NotNull
@Column(name = "sobreNome")
private String sobreNome;

@NotNull
@Column(name = "senha")
private String senha;







}


