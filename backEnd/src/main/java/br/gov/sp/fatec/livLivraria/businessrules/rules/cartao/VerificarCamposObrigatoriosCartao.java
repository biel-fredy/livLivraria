package br.gov.sp.fatec.livLivraria.businessrules.rules.cartao;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioCartao;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCartao;
import br.gov.sp.fatec.livLivraria.entities.Cartao;

public class VerificarCamposObrigatoriosCartao implements RegraNegocioCartao {

	@Override
	public ResultadoStrategyCartao processar(Cartao cartao) {
		List<String> mensagensErro = new ArrayList<String>();


		ResultadoStrategyCartao resultado = new ResultadoStrategyCartao(mensagensErro, cartao);
		return resultado;
	}

}
