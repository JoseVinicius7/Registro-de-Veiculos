package br.com.veiculos.registrodeveiculo.controller.form;

import java.util.List;
import java.util.stream.Collectors;

import com.sun.istack.NotNull;

import br.com.veiculos.registrodeveiculo.controller.dto.ModeloDto;
import br.com.veiculos.registrodeveiculo.models.Modelo;

public class ModeloForm {

	@NotNull
	private String descricao;
	@NotNull
	private String ano;
	
	public String getDescricao() {
		return descricao;
	}

	public String getAno() {
		return ano;
	}

	public static List<ModeloDto> converter(List<Modelo> modelo) {

		return modelo.stream().map(ModeloDto::new).collect(Collectors.toList());
	}

	public Modelo converter() {
		
		return new Modelo(descricao,ano);
	}
}
