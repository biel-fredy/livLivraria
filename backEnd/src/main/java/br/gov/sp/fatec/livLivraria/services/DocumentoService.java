package br.gov.sp.fatec.livLivraria.services;

import br.gov.sp.fatec.livLivraria.entities.Documento;
import br.gov.sp.fatec.livLivraria.results.ResultadoDocumento;

public interface DocumentoService {
	
	public ResultadoDocumento salvar(Documento documento);

	public ResultadoDocumento editar(Documento documento);

	public ResultadoDocumento excluir(Documento documento);

	public ResultadoDocumento buscarPorId(Long id);

	public ResultadoDocumento buscarTodos();


}
