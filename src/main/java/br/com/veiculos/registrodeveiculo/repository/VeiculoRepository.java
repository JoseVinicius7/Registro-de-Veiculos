package br.com.veiculos.registrodeveiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.veiculos.registrodeveiculo.models.Veiculo;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
