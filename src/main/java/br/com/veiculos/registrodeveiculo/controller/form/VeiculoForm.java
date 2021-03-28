package br.com.veiculos.registrodeveiculo.controller.form;

import java.util.List;
import java.util.stream.Collectors;

import com.sun.istack.NotNull;

import br.com.veiculos.registrodeveiculo.controller.dto.VeiculoDto;
import br.com.veiculos.registrodeveiculo.models.Veiculo;

public class VeiculoForm {

	@NotNull
	private String descricao;
	@NotNull
	private String dataRegistro;

	public String getDescricao() {
		return descricao;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}	
	

	public static List<VeiculoDto> converter(List<Veiculo> veiculo) {

		return veiculo.stream().map(VeiculoDto::new).collect(Collectors.toList());
	}

	public Veiculo converter() {
		
		return new Veiculo(descricao,dataRegistro);
	}
}
