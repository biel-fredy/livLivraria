package br.gov.sp.fatec.livLivraria.businessrules;

import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyEndereco;
import br.gov.sp.fatec.livLivraria.entities.Endereco;

public interface RegraNegocioEndereco {

	public ResultadoStrategyEndereco processar(Endereco endereco);

}
