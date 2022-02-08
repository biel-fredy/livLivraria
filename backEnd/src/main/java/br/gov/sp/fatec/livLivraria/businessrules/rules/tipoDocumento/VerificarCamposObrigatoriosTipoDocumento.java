package br.gov.sp.fatec.livLivraria.businessrules.rules.tipoDocumento;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioTipoDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyTipoDocumento;
import br.gov.sp.fatec.livLivraria.entities.TipoDocumento;

public class VerificarCamposObrigatoriosTipoDocumento implements RegraNegocioTipoDocumento {

	@Override
	public ResultadoStrategyTipoDocumento processar(TipoDocumento tipoDocumento) {
		List<String> mensagensErro = new ArrayList<String>();

		String nome = tipoDocumento.getNome();
		String descricao = tipoDocumento.getDescricao();

		if (nome == null || nome.trim() == "") {
			mensagensErro.add("Nome não pode ser vazio!");
		}

		if (descricao == null || descricao.trim() == "") {
			mensagensErro.add("Descrição não pode ser vazio!");
		}

		if (mensagensErro.size() <= 0) {
			return new ResultadoStrategyTipoDocumento(mensagensErro, tipoDocumento);
		}

		return new ResultadoStrategyTipoDocumento(null, tipoDocumento);
	}

}
