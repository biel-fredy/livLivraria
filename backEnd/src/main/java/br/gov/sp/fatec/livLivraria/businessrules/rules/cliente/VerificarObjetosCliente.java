package br.gov.sp.fatec.livLivraria.businessrules.rules.cliente;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioCliente;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCliente;
import br.gov.sp.fatec.livLivraria.entities.Cliente;
import br.gov.sp.fatec.livLivraria.entities.Endereco;

public class VerificarObjetosCliente implements RegraNegocioCliente {

	@Override
	public ResultadoStrategyCliente processar(Cliente cliente) {
		List<String> mensagensErro = new ArrayList<String>();
		
		if (cliente.getEnderecos().size() <= 0) {
			mensagensErro.add("Nenhum endereço cadastrado");
		}else {
			boolean enderecoEntrega = false;
			boolean enderecoCobranca = false;
			for(Endereco endereco : cliente.getEnderecos()) {
				if(endereco.getEnderecoEntrega()) {
					enderecoEntrega = true;
				}
				if(endereco.getEnderecoCobranca() == null) {
					endereco.setEnderecoCobranca(true);
				}
				if(endereco.getEnderecoCobranca()) {
					enderecoCobranca = true;
				}
				if(enderecoEntrega && enderecoCobranca) {
					break;
				}
			}
			if(!enderecoEntrega) {
				mensagensErro.add("Nenhum endereço de entrega fornecido");
			}
			if(!enderecoCobranca) {
				mensagensErro.add("Nenhum endereco de cobrança fornecido");
			}
		}
		
		ResultadoStrategyCliente resultado = new ResultadoStrategyCliente(mensagensErro, cliente);
		return resultado;
	}

}
