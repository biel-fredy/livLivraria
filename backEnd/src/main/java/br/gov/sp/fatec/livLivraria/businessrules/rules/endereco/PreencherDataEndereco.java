package br.gov.sp.fatec.livLivraria.businessrules.rules.endereco;

import java.time.Instant;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioEndereco;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyEndereco;
import br.gov.sp.fatec.livLivraria.entities.Endereco;

public class PreencherDataEndereco implements RegraNegocioEndereco {

	@Override
	public ResultadoStrategyEndereco processar(Endereco endereco) {
		endereco.setDataCadastro(Instant.now());
		return new ResultadoStrategyEndereco(null, endereco);
	}

}
