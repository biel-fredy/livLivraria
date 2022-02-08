package br.gov.sp.fatec.livLivraria.businessrules.rules.cliente;

import java.time.Instant;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioCliente;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCliente;
import br.gov.sp.fatec.livLivraria.entities.Cliente;

public class PreencherDataCliente implements RegraNegocioCliente {

	@Override
	public ResultadoStrategyCliente processar(Cliente cliente) {
		cliente.setDataCadastro(Instant.now());
		System.out.println(cliente.getDataCadastro());
		Instant teste = Instant.parse(cliente.getDataCadastro().toString());
		System.out.println(teste);
		return new ResultadoStrategyCliente(null, cliente);
	}

}
