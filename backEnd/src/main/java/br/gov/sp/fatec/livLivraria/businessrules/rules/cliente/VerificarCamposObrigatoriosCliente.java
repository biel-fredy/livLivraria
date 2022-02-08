package br.gov.sp.fatec.livLivraria.businessrules.rules.cliente;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioCliente;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCliente;
import br.gov.sp.fatec.livLivraria.entities.Cliente;
import br.gov.sp.fatec.livLivraria.entities.Endereco;

public class VerificarCamposObrigatoriosCliente implements RegraNegocioCliente {

	@Override
	public ResultadoStrategyCliente processar(Cliente cliente) {
		List<String> mensagensErro = new ArrayList<String>();
		String nome = cliente.getNome();

		
//
//		if (cliente.getDocumentos().size() <= 0) {
//			msg.append("Nenhum documento cadastrado");
//			msg.append("\n");
//		}

		if (nome == null || nome.trim() == "") {
			mensagensErro.add("Nome não pode ser vazio!");
		}

		ResultadoStrategyCliente resultado = new ResultadoStrategyCliente(mensagensErro, cliente);
		return resultado;
	}

}
