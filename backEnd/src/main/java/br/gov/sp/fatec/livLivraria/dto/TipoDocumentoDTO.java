package br.gov.sp.fatec.livLivraria.dto;

import java.time.Instant;

import br.gov.sp.fatec.livLivraria.entities.TipoDocumento;

public class TipoDocumentoDTO {
	
	private Long id;
	private String descricao;
	private String nome;
	private Instant dataCadastro;
	
	public TipoDocumentoDTO() {

	}

	public TipoDocumentoDTO(String descricao, String nome) {
		super();
		this.descricao = descricao;
		this.nome = nome;
	}
	
	public TipoDocumentoDTO(TipoDocumento entity) {
		this.setId(entity.getId());
		this.setDataCadastro(entity.getDataCadastro());
		this.descricao = entity.getDescricao();
		this.nome = entity.getNome();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
