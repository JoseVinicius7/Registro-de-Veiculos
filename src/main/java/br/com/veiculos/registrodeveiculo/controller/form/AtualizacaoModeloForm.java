package br.com.veiculos.registrodeveiculo.controller.form;

import com.sun.istack.NotNull;

import br.com.veiculos.registrodeveiculo.models.Modelo;
import br.com.veiculos.registrodeveiculo.repository.ModeloRepository;

public class AtualizacaoModeloForm {

	@NotNull
	private String descricao;
	@NotNull
	private String ano;

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

	public Modelo atualizar(Long id, ModeloRepository modeloRepository) {
		Modelo modelo = modeloRepository.getOne(id);
		modelo.setDescricao(this.descricao);
		modelo.setAno(this.ano);

		return modelo;

	}
}
