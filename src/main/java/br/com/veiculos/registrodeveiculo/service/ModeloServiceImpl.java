package br.com.veiculos.registrodeveiculo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veiculos.registrodeveiculo.controller.form.AtualizacaoModeloForm;
import br.com.veiculos.registrodeveiculo.controller.form.ModeloForm;
import br.com.veiculos.registrodeveiculo.exception.ModeloNotFoundException;
import br.com.veiculos.registrodeveiculo.models.Modelo;
import br.com.veiculos.registrodeveiculo.repository.ModeloRepository;

@Service
public class ModeloServiceImpl implements ModeloService {

	@Autowired
	private ModeloRepository modeloRepository;

	@Override
	public List<Modelo> findAll() {
		return modeloRepository.findAll();
	}

	@Override
	public Modelo save(ModeloForm form) {

		Modelo modelo = form.converter();
		return modeloRepository.save(modelo);
	}

	@Override
	public Modelo findById(Long id) {
		Optional<Modelo> modelo = modeloRepository.findById(id);

		return modelo.orElseThrow(() -> new ModeloNotFoundException("Modelo de id " + id + " não encontrado."));
	}

	@Override
	public Modelo update(Long id, AtualizacaoModeloForm form) {
		Optional<Modelo> optional = modeloRepository.findById(id);
		if (!optional.isPresent()) {
			throw new ModeloNotFoundException("Modelo de id " + id + " não encontrado.");
		}
		Modelo modelo = form.atualizar(id, modeloRepository);
		return modelo;
	}

	@Override
	public void remover(long id) {
		Optional<Modelo> optional = modeloRepository.findById(id);
		if (!optional.isPresent()) {
			throw new ModeloNotFoundException("Modelo de id " + id + " não encontrado.");
		}
		modeloRepository.deleteById(id);

	}
}
