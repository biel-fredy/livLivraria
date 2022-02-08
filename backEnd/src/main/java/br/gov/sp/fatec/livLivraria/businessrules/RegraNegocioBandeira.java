package br.gov.sp.fatec.livLivraria.businessrules;

import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyBandeira;
import br.gov.sp.fatec.livLivraria.entities.Bandeira;

public interface RegraNegocioBandeira {

	public ResultadoStrategyBandeira processar(Bandeira bandeira);

}
