package br.com.veiculos.registrodeveiculo.service;

import java.util.List;

import br.com.veiculos.registrodeveiculo.controller.form.AtualizacaoModeloForm;
import br.com.veiculos.registrodeveiculo.controller.form.ModeloForm;
import br.com.veiculos.registrodeveiculo.models.Modelo;

public interface ModeloService {

	List<Modelo> findAll();

	Modelo save(ModeloForm form);

	Modelo findById(Long id);

	Modelo update(Long id, AtualizacaoModeloForm form);

	void remover(long id);

}
