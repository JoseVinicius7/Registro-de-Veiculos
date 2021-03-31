package br.com.veiculos.registrodeveiculo.controller.form;

import com.sun.istack.NotNull;

import br.com.veiculos.registrodeveiculo.models.Veiculo;
import br.com.veiculos.registrodeveiculo.repository.VeiculoRepository;

public class AtualizacaoVeiculoForm {
	@NotNull
	private String descricao;
	@NotNull
	private String dataRegistro;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	public Veiculo atualizar(Long id, VeiculoRepository veiculoRepository) {
		Veiculo veiculo = veiculoRepository.getOne(id);
		veiculo.setDescricao(this.descricao);
		veiculo.setDataRegistro(this.dataRegistro);
		
		return veiculo;
		
	}
}
