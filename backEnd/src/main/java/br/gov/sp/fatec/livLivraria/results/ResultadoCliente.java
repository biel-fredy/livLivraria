package br.gov.sp.fatec.livLivraria.results;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.dto.ClienteDTO;
import br.gov.sp.fatec.livLivraria.entities.Cliente;

public class ResultadoCliente extends AbstractResultado {

	private List<ClienteDTO> resultadoLista = new ArrayList<ClienteDTO>();
	
	public ResultadoCliente() {}
	
	public ResultadoCliente(Cliente cliente) {
		this.addClienteDTO(new ClienteDTO(cliente));
	}

	public List<ClienteDTO> getResultadoLista() {
		return this.resultadoLista;
	}

	public void setResultadoLista(List<ClienteDTO> resultadoLista) {
		this.resultadoLista = resultadoLista;
	}

	public void addClienteDTO(ClienteDTO cliente) {
		this.resultadoLista.add(cliente);
	}
	
	public void addClienteDTO(Cliente cliente) {
		this.addClienteDTO(new ClienteDTO(cliente));
	}

	public void removeClienteDTO(int idClienteDTO) {
		for (ClienteDTO cliente : this.resultadoLista) {
			if (cliente.getId() == idClienteDTO) {
				this.resultadoLista.remove(cliente);
			}
		}
	}

}
