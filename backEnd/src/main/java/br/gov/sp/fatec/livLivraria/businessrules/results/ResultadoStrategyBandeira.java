package br.gov.sp.fatec.livLivraria.businessrules.results;

import java.util.List;

import br.gov.sp.fatec.livLivraria.entities.Bandeira;

public class ResultadoStrategyBandeira extends AbstractResultadoStrategy {

	private Bandeira bandeira;

	public ResultadoStrategyBandeira() {
	}

	public ResultadoStrategyBandeira(List<String> mensagens, Bandeira bandeira) {
		super(mensagens);
		this.bandeira = bandeira;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

}
