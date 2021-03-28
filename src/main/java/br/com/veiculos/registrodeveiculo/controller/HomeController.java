package br.com.veiculos.registrodeveiculo.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.veiculos.registrodeveiculo.controller.dto.VeiculoDto;
import br.com.veiculos.registrodeveiculo.controller.form.VeiculoForm;
import br.com.veiculos.registrodeveiculo.models.Veiculo;
import br.com.veiculos.registrodeveiculo.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")

public class HomeController {
	
	@Autowired
	private VeiculoService veiculoService;

	
	@GetMapping
	public List<Veiculo> lista() {
		return veiculoService.findAll();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VeiculoDto> cadastrar(@RequestBody @Validated VeiculoForm form,
			UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = veiculoService.save(form);
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	};

}
