package br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.rules.documento.PreencherDataDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.rules.documento.VerificarCamposObrigatoriosDocumento;
import br.gov.sp.fatec.livLivraria.entities.Documento;

@Service
public class RegrasNegocioDocumento {

	private Map<String, Map<String, List<RegraNegocioDocumento>>> regrasDeNegocio = new HashMap<String, Map<String, List<RegraNegocioDocumento>>>();

	public RegrasNegocioDocumento() {

		PreencherDataDocumento preencherDataDocumento = new PreencherDataDocumento();
		VerificarCamposObrigatoriosDocumento verificaObrigatoriosDocumento = new VerificarCamposObrigatoriosDocumento();

		List<RegraNegocioDocumento> rnsSalvarDocumento = new ArrayList<RegraNegocioDocumento>();
		rnsSalvarDocumento.add(preencherDataDocumento);
		rnsSalvarDocumento.add(verificaObrigatoriosDocumento);

		List<RegraNegocioDocumento> rnsAlterarDocumento = new ArrayList<RegraNegocioDocumento>();
		rnsAlterarDocumento.add(verificaObrigatoriosDocumento);

		Map<String, List<RegraNegocioDocumento>> rnsDocumento = new HashMap<String, List<RegraNegocioDocumento>>();
		rnsDocumento.put("SALVAR", rnsSalvarDocumento);
		rnsDocumento.put("ALTERAR", rnsAlterarDocumento);

		regrasDeNegocio.put(Documento.class.getName(), rnsDocumento);
	}

	public ResultadoStrategyDocumento executarRegras(Documento documento, String operacao) {
		ResultadoStrategyDocumento resultado = new ResultadoStrategyDocumento();
		resultado.setDocumento(documento);
		String nmClasse = documento.getClass().getName();
		
		Map<String, List<RegraNegocioDocumento>> regrasClasse = regrasDeNegocio.get(nmClasse);

		if (regrasClasse != null) {
			List<RegraNegocioDocumento> regrasOperacao = regrasClasse.get(operacao);

			if (regrasOperacao != null) {
				for (RegraNegocioDocumento strategies : regrasOperacao) {
					ResultadoStrategyDocumento resultadoStrategy = strategies.processar(resultado.getDocumento());
					
					if (resultadoStrategy.getMensagens() != null) {
						for (String mensagemErro : resultadoStrategy.getMensagens()) {
							resultado.addMensagem(mensagemErro);
						}
					}
					
					resultado.setDocumento(resultadoStrategy.getDocumento());
				}
			}
		}
		return resultado;
	}

}
