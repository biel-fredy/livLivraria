package br.gov.sp.fatec.livLivraria.dto;

import br.gov.sp.fatec.livLivraria.entities.Estado;

public class EstadoDTO {

	private String descricao;

	private PaisDTO pais;

	public EstadoDTO() {

	}

	public EstadoDTO(String descricao, PaisDTO pais) {
		super();
		this.descricao = descricao;
		this.pais = pais;
	}

	public EstadoDTO(Estado entity) {
		this.descricao = entity.getDescricao();
		this.pais = new PaisDTO(entity.getPais());
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

}
