package br.gov.sp.fatec.livLivraria.results;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.dto.EnderecoDTO;

public class ResultadoEndereco extends AbstractResultado {

	private List<EnderecoDTO> resultadoLista = new ArrayList<EnderecoDTO>();

	public List<EnderecoDTO> getResultadoLista() {
		return this.resultadoLista;
	}

	public void setResultadoLista(List<EnderecoDTO> resultadoLista) {
		this.resultadoLista = resultadoLista;
	}

	public void addEnderecoDTO(EnderecoDTO endereco) {
		this.resultadoLista.add(endereco);
	}

	public void removeEnderecoDTO(int idEnderecoDTO) {
		for (EnderecoDTO endereco : this.resultadoLista) {
			if (endereco.getId() == idEnderecoDTO) {
				this.resultadoLista.remove(endereco);
			}
		}
	}

}
