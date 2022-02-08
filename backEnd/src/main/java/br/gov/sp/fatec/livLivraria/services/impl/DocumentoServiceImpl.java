package br.gov.sp.fatec.livLivraria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios.RegrasNegocioDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyDocumento;
import br.gov.sp.fatec.livLivraria.daos.DocumentoDao;
import br.gov.sp.fatec.livLivraria.dto.DocumentoDTO;
import br.gov.sp.fatec.livLivraria.entities.Documento;
import br.gov.sp.fatec.livLivraria.results.ResultadoDocumento;
import br.gov.sp.fatec.livLivraria.services.DocumentoService;

@Service
@Transactional(readOnly = false)
public class DocumentoServiceImpl implements DocumentoService {

	@Autowired
	private DocumentoDao daoDocumento;
	
	private RegrasNegocioDocumento fachadaRegraNegocioDocumento;

	@Override
	public ResultadoDocumento salvar(Documento documento) {

		ResultadoDocumento resultado = new ResultadoDocumento();

		ResultadoStrategyDocumento resultadoStrategyDocumento = fachadaRegraNegocioDocumento.executarRegras(documento,
				"SALVAR");

		documento = resultadoStrategyDocumento.getDocumento();

		for (String mensagemErroDocumento : resultadoStrategyDocumento.getMensagens()) {
			resultado.addMensagem(mensagemErroDocumento);
		}

		if (resultado.getMensagens().size() <= 0) {
			daoDocumento.save(documento);
			resultado.addDocumentoDTO(new DocumentoDTO(documento));
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

	@Override
	public ResultadoDocumento editar(Documento documento) {
		ResultadoDocumento resultado = new ResultadoDocumento();

		ResultadoStrategyDocumento resultadoStrategyDocumento = fachadaRegraNegocioDocumento.executarRegras(documento,
				"ALTERAR");
		documento = resultadoStrategyDocumento.getDocumento();

		for (String mensagemErroDocumento : resultadoStrategyDocumento.getMensagens()) {
			resultado.addMensagem(mensagemErroDocumento);
		}

		if (resultado.getMensagens().size() <= 0) {
			daoDocumento.update(documento);
			resultado.addDocumentoDTO(new DocumentoDTO(documento));
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

	@Override
	public ResultadoDocumento excluir(Documento documento) {
		ResultadoDocumento resultado = new ResultadoDocumento();

		ResultadoStrategyDocumento resultadoStrategyDocumento = fachadaRegraNegocioDocumento.executarRegras(documento,
				"EXCLUIR");
		documento = resultadoStrategyDocumento.getDocumento();

		for (String mensagemErroDocumento : resultadoStrategyDocumento.getMensagens()) {
			resultado.addMensagem(mensagemErroDocumento);
		}

		if (resultado.getMensagens().size() <= 0) {
			daoDocumento.delete(documento.getId());
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ResultadoDocumento buscarPorId(Long id) {
		ResultadoDocumento resultado = new ResultadoDocumento();
		resultado.addDocumentoDTO(new DocumentoDTO(daoDocumento.findById(id)));
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ResultadoDocumento buscarTodos() {
		ResultadoDocumento resultado = new ResultadoDocumento();
		List<Documento> listaDocumento = daoDocumento.findAll();

		List<DocumentoDTO> listaDTO = listaDocumento.stream().map(x -> new DocumentoDTO(x)).collect(Collectors.toList());

		resultado.setResultadoLista(listaDTO);

		return resultado;
	}

}