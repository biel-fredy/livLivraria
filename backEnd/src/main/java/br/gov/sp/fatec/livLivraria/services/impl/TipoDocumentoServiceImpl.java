package br.gov.sp.fatec.livLivraria.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.livLivraria.entities.TipoDocumento;
import br.gov.sp.fatec.livLivraria.results.ResultadoTipoDocumento;
import br.gov.sp.fatec.livLivraria.services.TipoDocumentoService;

@Service
@Transactional(readOnly = false)
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Override
	public ResultadoTipoDocumento salvar(TipoDocumento tipoDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoTipoDocumento editar(TipoDocumento tipoDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoTipoDocumento excluir(TipoDocumento tipoDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoTipoDocumento buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoTipoDocumento buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}