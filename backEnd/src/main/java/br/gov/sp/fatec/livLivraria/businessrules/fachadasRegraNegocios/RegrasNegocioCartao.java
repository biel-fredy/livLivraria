package br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioCartao;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCartao;
import br.gov.sp.fatec.livLivraria.businessrules.rules.cartao.PreencherDataCartao;
import br.gov.sp.fatec.livLivraria.businessrules.rules.cartao.VerificarCamposObrigatoriosCartao;
import br.gov.sp.fatec.livLivraria.entities.Cartao;

@Service
public class RegrasNegocioCartao {

	private Map<String, Map<String, List<RegraNegocioCartao>>> regrasDeNegocio = new HashMap<String, Map<String, List<RegraNegocioCartao>>>();

	public RegrasNegocioCartao() {

		PreencherDataCartao preencherDataCartao = new PreencherDataCartao();
		VerificarCamposObrigatoriosCartao verificaObrigatoriosCartao = new VerificarCamposObrigatoriosCartao();

		List<RegraNegocioCartao> rnsSalvarCartao = new ArrayList<RegraNegocioCartao>();
		rnsSalvarCartao.add(preencherDataCartao);
		rnsSalvarCartao.add(verificaObrigatoriosCartao);

		List<RegraNegocioCartao> rnsAlterarCartao = new ArrayList<RegraNegocioCartao>();
		rnsAlterarCartao.add(verificaObrigatoriosCartao);

		Map<String, List<RegraNegocioCartao>> rnsCartao = new HashMap<String, List<RegraNegocioCartao>>();
		rnsCartao.put("SALVAR", rnsSalvarCartao);
		rnsCartao.put("ALTERAR", rnsAlterarCartao);

		regrasDeNegocio.put(Cartao.class.getName(), rnsCartao);
	}

	public ResultadoStrategyCartao executarRegras(Cartao cartao, String operacao) {
		ResultadoStrategyCartao resultado = new ResultadoStrategyCartao();
		resultado.setCartao(cartao);
		String nmClasse = cartao.getClass().getName();

		Map<String, List<RegraNegocioCartao>> regrasClasse = regrasDeNegocio.get(nmClasse);

		if (regrasClasse != null) {
			List<RegraNegocioCartao> regrasOperacao = regrasClasse.get(operacao);

			if (regrasOperacao != null) {
				for (RegraNegocioCartao strategies : regrasOperacao) {
					ResultadoStrategyCartao resultadoStrategy = strategies.processar(resultado.getCartao());

					if (resultadoStrategy.getMensagens() != null) {
						for (String mensagemErro : resultadoStrategy.getMensagens()) {
							resultado.addMensagem(mensagemErro);
						}
					}
					resultado.setCartao(resultadoStrategy.getCartao());

				}
			}
		}
		return resultado;
	}

}
