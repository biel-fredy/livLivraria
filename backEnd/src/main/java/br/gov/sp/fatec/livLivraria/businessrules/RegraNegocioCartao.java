package br.gov.sp.fatec.livLivraria.businessrules;

import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCartao;
import br.gov.sp.fatec.livLivraria.entities.Cartao;

public interface RegraNegocioCartao {

	public ResultadoStrategyCartao processar(Cartao cartao);

}
