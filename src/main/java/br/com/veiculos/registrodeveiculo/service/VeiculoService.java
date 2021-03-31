package br.com.veiculos.registrodeveiculo.service;

import java.util.List;

import br.com.veiculos.registrodeveiculo.controller.form.AtualizacaoVeiculoForm;
import br.com.veiculos.registrodeveiculo.controller.form.VeiculoForm;
import br.com.veiculos.registrodeveiculo.models.Veiculo;



public interface VeiculoService {



	Veiculo save(VeiculoForm form);
	
	List<Veiculo> findAll();

	Veiculo findById(Long id);

	Veiculo update(Long id, AtualizacaoVeiculoForm form);

	void remover(long id);
	
	

}
