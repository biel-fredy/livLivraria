package br.gov.sp.fatec.livLivraria.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.gov.sp.fatec.livLivraria.dto.PaisDTO;

@Embeddable
public class Pais {

	@Column(name = "nome_pais")
	private String descricao;

	public Pais() {
	}

	public Pais(String descricao) {
		this.descricao = descricao;
	}

	public Pais(PaisDTO dto) {
		this.descricao = dto.getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
