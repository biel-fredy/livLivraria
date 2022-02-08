package br.gov.sp.fatec.livLivraria.businessrules;

import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCliente;
import br.gov.sp.fatec.livLivraria.entities.Cliente;

public interface RegraNegocioCliente {

	public ResultadoStrategyCliente processar(Cliente cliente);

}
