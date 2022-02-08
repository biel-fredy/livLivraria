package br.gov.sp.fatec.livLivraria.businessrules.rules.documento;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyDocumento;
import br.gov.sp.fatec.livLivraria.entities.Documento;

public class VerificarCamposObrigatoriosDocumento implements RegraNegocioDocumento {

	@Override
	public ResultadoStrategyDocumento processar(Documento documento) {
		List<String> mensagensErro = new ArrayList<String>();

		String codigo = documento.getCodigo();
		Instant validade = documento.getValidade();

		if (codigo == null || codigo.trim() == "") {
			mensagensErro.add("Código não pode ser vazio!");
		}

		if (validade == null) {
			mensagensErro.add("Validade não pode ser vazio!");
		}

		if (mensagensErro.size() <= 0) {
			return new ResultadoStrategyDocumento (null, documento);
		}

		return new ResultadoStrategyDocumento(mensagensErro, documento);
	}

}
