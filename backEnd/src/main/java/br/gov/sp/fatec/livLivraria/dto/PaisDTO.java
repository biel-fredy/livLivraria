package br.gov.sp.fatec.livLivraria.dto;

import br.gov.sp.fatec.livLivraria.entities.Pais;

public class PaisDTO {
	
	private String descricao;

	public PaisDTO() {

	}

	public PaisDTO(String descricao) {
		super();
		this.descricao = descricao;
	}

	public PaisDTO(Pais entity) {
		this.descricao = entity.getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
