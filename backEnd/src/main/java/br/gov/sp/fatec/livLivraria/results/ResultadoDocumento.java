package br.gov.sp.fatec.livLivraria.results;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.dto.DocumentoDTO;

public class ResultadoDocumento extends AbstractResultado {

	private List<DocumentoDTO> resultadoLista = new ArrayList<DocumentoDTO>();

	public List<DocumentoDTO> getResultadoLista() {
		return this.resultadoLista;
	}

	public void setResultadoLista(List<DocumentoDTO> resultadoLista) {
		this.resultadoLista = resultadoLista;
	}

	public void addDocumentoDTO(DocumentoDTO documento) {
		this.resultadoLista.add(documento);
	}

	public void removeDocumentoDTO(int idDocumentoDTO) {
		for (DocumentoDTO documento : this.resultadoLista) {
			if (documento.getId() == idDocumentoDTO) {
				this.resultadoLista.remove(documento);
			}
		}
	}

}
