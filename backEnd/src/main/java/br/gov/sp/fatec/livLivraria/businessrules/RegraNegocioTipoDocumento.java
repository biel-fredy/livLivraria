package br.gov.sp.fatec.livLivraria.businessrules;

import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyTipoDocumento;
import br.gov.sp.fatec.livLivraria.entities.TipoDocumento;

public interface RegraNegocioTipoDocumento {

	public ResultadoStrategyTipoDocumento processar(TipoDocumento tipoDocumento);

}
