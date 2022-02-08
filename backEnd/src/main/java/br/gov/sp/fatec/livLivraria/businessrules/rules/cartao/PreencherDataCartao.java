package br.gov.sp.fatec.livLivraria.businessrules.rules.cartao;

import java.time.Instant;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioCartao;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCartao;
import br.gov.sp.fatec.livLivraria.entities.Cartao;

public class PreencherDataCartao implements RegraNegocioCartao {

	@Override
	public ResultadoStrategyCartao processar(Cartao cartao) {
		cartao.setDataCadastro(Instant.now());
		return new ResultadoStrategyCartao(null, cartao);
	}

}
