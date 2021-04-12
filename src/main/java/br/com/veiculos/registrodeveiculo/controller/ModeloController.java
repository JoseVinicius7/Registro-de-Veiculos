package br.com.veiculos.registrodeveiculo.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.veiculos.registrodeveiculo.controller.dto.ModeloDto;
import br.com.veiculos.registrodeveiculo.controller.form.AtualizacaoModeloForm;
import br.com.veiculos.registrodeveiculo.controller.form.ModeloForm;
import br.com.veiculos.registrodeveiculo.models.Modelo;
import br.com.veiculos.registrodeveiculo.service.ModeloService;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

	@Autowired
	ModeloService modeloService;

	@GetMapping
	public List<Modelo> lista() {
		return modeloService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ModeloDto> detalhar(@PathVariable Long id) {
		Modelo modelo = modeloService.findById(id);

		return ResponseEntity.ok(new ModeloDto(modelo));
	};

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ModeloDto> atualizar(@PathVariable Long id,
			@RequestBody @Validated AtualizacaoModeloForm form) {
		Modelo modelo = modeloService.update(id, form);

		return ResponseEntity.ok(new ModeloDto(modelo));
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ModeloDto> Cadastrar(@RequestBody @Validated ModeloForm form,
			UriComponentsBuilder uriBuilder) {

		Modelo modelo = modeloService.save(form);

		URI uri = uriBuilder.path("/modelo/{id}").buildAndExpand(modelo.getId()).toUri();
		return ResponseEntity.created(uri).body(new ModeloDto(modelo));
	};

	@DeleteMapping("/{id}")
	@Transactional

	public ResponseEntity<?> remover(@PathVariable long id) {

		modeloService.remover(id);

		return ResponseEntity.noContent().build();
	}
}
