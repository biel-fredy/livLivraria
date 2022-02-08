package br.gov.sp.fatec.livLivraria.businessrules.rules.endereco;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioEndereco;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyEndereco;
import br.gov.sp.fatec.livLivraria.entities.Endereco;

public class VerificarCamposObrigatoriosEndereco implements RegraNegocioEndereco {

	@Override
	public ResultadoStrategyEndereco processar(Endereco endereco) {
		List<String> mensagensErro = new ArrayList<String>();

		String logradouro = endereco.getLogradouro();
		String numero = endereco.getNumero();
		String cep = endereco.getCep();

		if (logradouro == null || logradouro.trim() == "") {
			mensagensErro.add("Logradouro não pode ser vazio!");
		}

		if (numero == null || numero.trim() == "") {
			mensagensErro.add("Número do endereço não pode ser vazio!");
		}

		if (cep == null || cep.trim() == "") {
			mensagensErro.add("CEP não pode ser vazio!");
		}
		
		if (mensagensErro.size() <= 0) {
			return new ResultadoStrategyEndereco(mensagensErro, endereco);
		}

		return new ResultadoStrategyEndereco(null, endereco);
	}

}
