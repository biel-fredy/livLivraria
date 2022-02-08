package br.gov.sp.fatec.livLivraria.businessrules.rules.documento;

import java.time.Instant;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyDocumento;
import br.gov.sp.fatec.livLivraria.entities.Documento;

public class PreencherDataDocumento implements RegraNegocioDocumento {

	@Override
	public ResultadoStrategyDocumento processar(Documento documento) {
		documento.setDataCadastro(Instant.now());
		return new ResultadoStrategyDocumento(null, documento);
	}

}
