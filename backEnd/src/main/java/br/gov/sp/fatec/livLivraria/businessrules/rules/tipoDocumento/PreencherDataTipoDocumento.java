package br.gov.sp.fatec.livLivraria.businessrules.rules.tipoDocumento;

import java.time.Instant;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioTipoDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyTipoDocumento;
import br.gov.sp.fatec.livLivraria.entities.TipoDocumento;

public class PreencherDataTipoDocumento implements RegraNegocioTipoDocumento {

	@Override
	public ResultadoStrategyTipoDocumento processar(TipoDocumento tipoDocumento) {
		tipoDocumento.setDataCadastro(Instant.now());
		return new ResultadoStrategyTipoDocumento(null, tipoDocumento);
	}

}
