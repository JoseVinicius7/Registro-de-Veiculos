package br.com.veiculos.registrodeveiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.veiculos.registrodeveiculo.models.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long>{

}
