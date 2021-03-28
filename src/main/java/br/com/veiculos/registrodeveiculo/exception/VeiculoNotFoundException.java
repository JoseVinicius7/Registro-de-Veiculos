package br.com.veiculos.registrodeveiculo.exception;

public class VeiculoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VeiculoNotFoundException(String message) {
		super(message);
	}
}
