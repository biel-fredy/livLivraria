package br.gov.sp.fatec.livLivraria.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import br.gov.sp.fatec.livLivraria.dto.CidadeDTO;

@Embeddable
public class Cidade  {
	
	@Column(name = "nome_cidade")
	private String descricao;
	
	@Embedded
	private Estado estado;

	public Cidade() {

	}
	
	public Cidade(String cidade, String estado) {
		super();
		this.descricao = cidade;
		this.estado = new Estado(estado);
	}

	public Cidade(String descricao, Estado estado) {
		super();
		this.descricao = descricao;
		this.estado = estado;
	}

	public Cidade(CidadeDTO dto) {
		this.descricao = dto.getDescricao();
		this.estado = new Estado(dto.getEstado());
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
