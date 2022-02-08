package br.gov.sp.fatec.livLivraria.businessrules.results;

import java.util.List;

import br.gov.sp.fatec.livLivraria.entities.Documento;

public class ResultadoStrategyDocumento extends AbstractResultadoStrategy {

	private Documento documento;

	public ResultadoStrategyDocumento() {
	}

	public ResultadoStrategyDocumento(List<String> mensagens, Documento documento) {
		super(mensagens);
		this.documento = documento;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}	

}
