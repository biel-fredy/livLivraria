package br.gov.sp.fatec.livLivraria.results;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.dto.BandeiraDTO;
import br.gov.sp.fatec.livLivraria.entities.Bandeira;

public class ResultadoBandeira extends AbstractResultado {

	private List<BandeiraDTO> resultadoLista = new ArrayList<BandeiraDTO>();

	public ResultadoBandeira() {
	}

	public ResultadoBandeira(Bandeira bandeira) {
		this.addBandeiraDTO(new BandeiraDTO(bandeira));
	}

	public ResultadoBandeira(List<Bandeira> bandeiras) {
		bandeiras.forEach(ban -> this.addBandeiraDTO(new BandeiraDTO(ban)));
	}

	public List<BandeiraDTO> getResultadoLista() {
		return this.resultadoLista;
	}

	public void setResultadoLista(List<BandeiraDTO> resultadoLista) {
		this.resultadoLista = resultadoLista;
	}

	public void addBandeiraDTO(BandeiraDTO bandeira) {
		this.resultadoLista.add(bandeira);
	}
	
	public void addBandeiraDTO(Bandeira bandeira) {
		this.addBandeiraDTO(new BandeiraDTO(bandeira));
	}

	public void removeBandeiraDTO(int idBandeiraDTO) {
		for (BandeiraDTO bandeira : this.resultadoLista) {
			if (bandeira.getId() == idBandeiraDTO) {
				this.resultadoLista.remove(bandeira);
			}
		}
	}

}
