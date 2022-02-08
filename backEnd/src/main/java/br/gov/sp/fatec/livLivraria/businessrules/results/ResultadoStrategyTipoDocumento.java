package br.gov.sp.fatec.livLivraria.businessrules.results;

import java.util.List;

import br.gov.sp.fatec.livLivraria.entities.TipoDocumento;

public class ResultadoStrategyTipoDocumento extends AbstractResultadoStrategy {

	private TipoDocumento tipoDocumento;

	public ResultadoStrategyTipoDocumento() {
	}

	public ResultadoStrategyTipoDocumento(List<String> mensagens, TipoDocumento tipoDocumento) {
		super(mensagens);
		this.tipoDocumento = tipoDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}
