package br.gov.sp.fatec.livLivraria.services;

import br.gov.sp.fatec.livLivraria.entities.TipoDocumento;
import br.gov.sp.fatec.livLivraria.results.ResultadoTipoDocumento;

public interface TipoDocumentoService {
	
	public ResultadoTipoDocumento salvar(TipoDocumento tipoDocumento);

	public ResultadoTipoDocumento editar(TipoDocumento tipoDocumento);

	public ResultadoTipoDocumento excluir(TipoDocumento tipoDocumento);

	public ResultadoTipoDocumento buscarPorId(Long id);

	public ResultadoTipoDocumento buscarTodos();

}
