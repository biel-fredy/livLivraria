package br.gov.sp.fatec.livLivraria.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import br.gov.sp.fatec.livLivraria.dto.EstadoDTO;

@Embeddable
public class Estado {

	@Column(name = "nome_estado")
	private String descricao;

	@Embedded
	private Pais pais;

	public Estado() {

	}
	
	public Estado(String descricao, String pais) {
		super();
		this.descricao = descricao;
		this.pais = new Pais(pais);
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado(String descricao) {
		super();
		this.descricao = descricao;
	}

	public Estado(EstadoDTO dto) {
		this.descricao = dto.getDescricao();
		this.pais = new Pais(dto.getPais());
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
