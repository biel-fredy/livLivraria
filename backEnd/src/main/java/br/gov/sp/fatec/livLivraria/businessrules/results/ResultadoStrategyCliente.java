package br.gov.sp.fatec.livLivraria.businessrules.results;

import java.util.List;

import br.gov.sp.fatec.livLivraria.entities.Cliente;

public class ResultadoStrategyCliente extends AbstractResultadoStrategy {

	private Cliente cliente;

	public ResultadoStrategyCliente() {
	}

	public ResultadoStrategyCliente(List<String> mensagens, Cliente cliente) {
		super(mensagens);
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	

}
