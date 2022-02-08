package br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioBandeira;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyBandeira;
import br.gov.sp.fatec.livLivraria.entities.Bandeira;

@Service
public class RegrasNegocioBandeira {

	private Map<String, Map<String, List<RegraNegocioBandeira>>> regrasDeNegocio = new HashMap<String, Map<String, List<RegraNegocioBandeira>>>();

	public RegrasNegocioBandeira() {

		// PreencherDataBandeira preencherDataBandeira = new PreencherDataBandeira();

		List<RegraNegocioBandeira> rnsSalvarBandeira = new ArrayList<RegraNegocioBandeira>();
		// rnsSalvarBandeira.add(preencherDataBandeira);

		List<RegraNegocioBandeira> rnsAlterarBandeira = new ArrayList<RegraNegocioBandeira>();
		// rnsAlterarBandeira.add(verificaObrigatoriosBandeira);

		Map<String, List<RegraNegocioBandeira>> rnsBandeira = new HashMap<String, List<RegraNegocioBandeira>>();
		rnsBandeira.put("SALVAR", rnsSalvarBandeira);
		rnsBandeira.put("ALTERAR", rnsAlterarBandeira);

		regrasDeNegocio.put(Bandeira.class.getName(), rnsBandeira);
	}

	public ResultadoStrategyBandeira executarRegras(Bandeira bandeira, String operacao) {
		ResultadoStrategyBandeira resultado = new ResultadoStrategyBandeira();
		resultado.setBandeira(bandeira);
		String nmClasse = bandeira.getClass().getName();

		Map<String, List<RegraNegocioBandeira>> regrasClasse = regrasDeNegocio.get(nmClasse);

		if (regrasClasse != null) {
			List<RegraNegocioBandeira> regrasOperacao = regrasClasse.get(operacao);

			if (regrasOperacao != null) {
				for (RegraNegocioBandeira strategies : regrasOperacao) {
					ResultadoStrategyBandeira resultadoStrategy = strategies.processar(resultado.getBandeira());

					if (resultadoStrategy.getMensagens() != null) {
						for (String mensagemErro : resultadoStrategy.getMensagens()) {
							resultado.addMensagem(mensagemErro);
						}
					}
					resultado.setBandeira(resultadoStrategy.getBandeira());

				}
			}
		}
		return resultado;
	}

}
