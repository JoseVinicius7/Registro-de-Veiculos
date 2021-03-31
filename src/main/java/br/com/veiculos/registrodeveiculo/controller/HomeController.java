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

import br.com.veiculos.registrodeveiculo.controller.dto.VeiculoDto;
import br.com.veiculos.registrodeveiculo.controller.form.AtualizacaoVeiculoForm;
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

	@GetMapping("/{id}")
	public ResponseEntity<VeiculoDto> detalhar(@PathVariable Long id) {
		Veiculo veiculo = veiculoService.findById(id);

		return ResponseEntity.ok(new VeiculoDto(veiculo));

	}

	@PostMapping
	@Transactional
	public ResponseEntity<VeiculoDto> cadastrar(@RequestBody @Validated VeiculoForm form,
			UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = veiculoService.save(form);
		URI uri = uriBuilder.path("/veiculo/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	};
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeiculoDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoVeiculoForm form) {
		Veiculo veiculo = veiculoService.update(id, form);
		
		return ResponseEntity.ok(new VeiculoDto(veiculo));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	
	public ResponseEntity<?> remover (@PathVariable long id){
		
		veiculoService.remover(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
}
