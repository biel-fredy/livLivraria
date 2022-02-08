package br.gov.sp.fatec.livLivraria.dto;

import br.gov.sp.fatec.livLivraria.entities.Cidade;

public class CidadeDTO {

	private String descricao;

	private EstadoDTO estado;

	public CidadeDTO() {
	}

	public CidadeDTO(String descricao, EstadoDTO estado) {
		super();
		this.descricao = descricao;
		this.estado = estado;
	}

	public CidadeDTO(Cidade entity) {
		this.descricao = entity.getDescricao();
		this.estado = new EstadoDTO(entity.getEstado());
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

}
