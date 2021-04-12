package br.com.veiculos.registrodeveiculo.controller.dto;

import com.sun.istack.NotNull;

import br.com.veiculos.registrodeveiculo.models.Modelo;

public class ModeloDto {
	
	@NotNull
	public String descricao;
	@NotNull
	public String ano;

	public ModeloDto(Modelo modelo) {
		this.descricao = getDescricao();
		this.ano = getAno();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

}
