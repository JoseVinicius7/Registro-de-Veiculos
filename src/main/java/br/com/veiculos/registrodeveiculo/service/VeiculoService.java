package br.com.veiculos.registrodeveiculo.service;

import java.util.List;

import br.com.veiculos.registrodeveiculo.controller.form.VeiculoForm;
import br.com.veiculos.registrodeveiculo.models.Veiculo;



public interface VeiculoService {



	Veiculo save(VeiculoForm form);
	
	List<Veiculo> findAll();
	
	

}