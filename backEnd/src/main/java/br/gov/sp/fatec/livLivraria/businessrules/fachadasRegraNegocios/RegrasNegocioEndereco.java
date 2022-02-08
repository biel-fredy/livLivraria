package br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioEndereco;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyEndereco;
import br.gov.sp.fatec.livLivraria.businessrules.rules.endereco.PreencherDataEndereco;
import br.gov.sp.fatec.livLivraria.businessrules.rules.endereco.VerificarCamposObrigatoriosEndereco;
import br.gov.sp.fatec.livLivraria.entities.Endereco;

@Service
public class RegrasNegocioEndereco {

	private Map<String, Map<String, List<RegraNegocioEndereco>>> regrasDeNegocio = new HashMap<String, Map<String, List<RegraNegocioEndereco>>>();

	public RegrasNegocioEndereco() {

		PreencherDataEndereco preencherDataEndereco = new PreencherDataEndereco();
		VerificarCamposObrigatoriosEndereco verificaObrigatoriosEndereco = new VerificarCamposObrigatoriosEndereco();

		List<RegraNegocioEndereco> rnsSalvarEndereco = new ArrayList<RegraNegocioEndereco>();
		rnsSalvarEndereco.add(preencherDataEndereco);
		rnsSalvarEndereco.add(verificaObrigatoriosEndereco);

		List<RegraNegocioEndereco> rnsAlterarEndereco = new ArrayList<RegraNegocioEndereco>();
		rnsAlterarEndereco.add(verificaObrigatoriosEndereco);

		Map<String, List<RegraNegocioEndereco>> rnsEndereco = new HashMap<String, List<RegraNegocioEndereco>>();
		rnsEndereco.put("SALVAR", rnsSalvarEndereco);
		rnsEndereco.put("ALTERAR", rnsAlterarEndereco);

		regrasDeNegocio.put(Endereco.class.getName(), rnsEndereco);
	}

	public ResultadoStrategyEndereco executarRegras(Endereco endereco, String operacao) {
		ResultadoStrategyEndereco resultado = new ResultadoStrategyEndereco();
		resultado.setEndereco(endereco);
		String nmClasse = endereco.getClass().getName();
		
		Map<String, List<RegraNegocioEndereco>> regrasClasse = regrasDeNegocio.get(nmClasse);

		if (regrasClasse != null) {
			List<RegraNegocioEndereco> regrasOperacao = regrasClasse.get(operacao);

			if (regrasOperacao != null) {
				for (RegraNegocioEndereco strategies : regrasOperacao) {
					ResultadoStrategyEndereco resultadoStrategy = strategies.processar(resultado.getEndereco());
					
					if (resultadoStrategy.getMensagens() != null) {
						for (String mensagemErro : resultadoStrategy.getMensagens()) {
							resultado.addMensagem(mensagemErro);
						}
					}
					
					resultado.setEndereco(resultadoStrategy.getEndereco());
				}
			}
		}
		return resultado;
	}

}
