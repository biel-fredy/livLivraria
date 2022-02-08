package br.gov.sp.fatec.livLivraria.businessrules.results;

import java.util.List;

import br.gov.sp.fatec.livLivraria.entities.Endereco;

public class ResultadoStrategyEndereco extends AbstractResultadoStrategy {

	private Endereco endereco;

	public ResultadoStrategyEndereco() {
	}

	public ResultadoStrategyEndereco(List<String> mensagens, Endereco endereco) {
		super(mensagens);
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	

}
