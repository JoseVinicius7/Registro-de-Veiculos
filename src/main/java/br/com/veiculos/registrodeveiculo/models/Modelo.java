package br.com.veiculos.registrodeveiculo.models;

import java.time.Year;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

public class Modelo {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String descricao;
	@NotNull
	private Year ano;
}
