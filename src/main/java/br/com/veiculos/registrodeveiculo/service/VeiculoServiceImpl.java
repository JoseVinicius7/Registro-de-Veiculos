package br.com.veiculos.registrodeveiculo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.veiculos.registrodeveiculo.controller.form.VeiculoForm;
import br.com.veiculos.registrodeveiculo.models.Veiculo;
import br.com.veiculos.registrodeveiculo.repository.VeiculoRepository;

@Service
public class VeiculoServiceImpl implements VeiculoService {
  
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	
	@Override
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	@Override
	public Veiculo save(VeiculoForm form) {
		Veiculo veiculo = form.converter();
		
		return veiculoRepository.save(veiculo);
		
	}

}
