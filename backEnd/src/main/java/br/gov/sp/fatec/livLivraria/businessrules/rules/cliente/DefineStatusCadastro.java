package br.gov.sp.fatec.livLivraria.businessrules.rules.cliente;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioCliente;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCliente;
import br.gov.sp.fatec.livLivraria.entities.Cliente;

public class DefineStatusCadastro implements RegraNegocioCliente {

	@Override
	public ResultadoStrategyCliente processar(Cliente cliente) {
		cliente.setStatus(true);
		ResultadoStrategyCliente resultado = new ResultadoStrategyCliente(null, cliente);
		return resultado;
	}
}
