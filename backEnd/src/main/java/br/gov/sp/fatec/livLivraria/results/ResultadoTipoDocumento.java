package br.gov.sp.fatec.livLivraria.results;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.dto.TipoDocumentoDTO;

public class ResultadoTipoDocumento extends AbstractResultado {

	private List<TipoDocumentoDTO> resultadoLista = new ArrayList<TipoDocumentoDTO>();

	public List<TipoDocumentoDTO> getResultadoLista() {
		return this.resultadoLista;
	}

	public void setResultadoLista(List<TipoDocumentoDTO> resultadoLista) {
		this.resultadoLista = resultadoLista;
	}

	public void addTipoDocumentoDTO(TipoDocumentoDTO tipoDocumento) {
		this.resultadoLista.add(tipoDocumento);
	}

	public void removeTipoDocumentoDTO(int idTipoDocumentoDTO) {
		for (TipoDocumentoDTO tipoDocumento : this.resultadoLista) {
			if (tipoDocumento.getId() == idTipoDocumentoDTO) {
				this.resultadoLista.remove(tipoDocumento);
			}
		}
	}

}
