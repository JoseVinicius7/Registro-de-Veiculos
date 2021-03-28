package br.com.veiculos.registrodeveiculo.controller.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import br.com.veiculos.registrodeveiculo.models.Veiculo;

public class VeiculoDto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String descricao;
	@NotNull
	private String dataRegistro;

	public VeiculoDto (Veiculo veiculo) {
		this.id = veiculo.getId();
		this.descricao = veiculo.getDescricao();
		this.dataRegistro = veiculo.getDataRegistro();
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	
	 
	
}
