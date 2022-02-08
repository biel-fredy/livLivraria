package br.gov.sp.fatec.livLivraria.businessrules;

import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyDocumento;
import br.gov.sp.fatec.livLivraria.entities.Documento;

public interface RegraNegocioDocumento {

	public ResultadoStrategyDocumento processar(Documento documento);

}
