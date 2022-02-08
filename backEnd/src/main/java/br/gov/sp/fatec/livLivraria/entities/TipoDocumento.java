package br.gov.sp.fatec.livLivraria.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.gov.sp.fatec.livLivraria.dto.TipoDocumentoDTO;


@Entity
public class TipoDocumento  {
	
	@Id
	@Column(name = "TPD_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TPD")
	@SequenceGenerator(name = "SQ_TPD", sequenceName = "SQ_TPD", allocationSize = 1)
	private Long id;
	
	@Column(name = "TPD_DESCRICAO")
	private String descricao;

	@Column(name = "TPD_NOME")
	private String nome;
	
	@Column(name = "TPD_DATA_CADASTRO")
	private Instant dataCadastro;

	public TipoDocumento() {

	}

	public TipoDocumento(String descricao, String nome) {
		super();
		this.descricao = descricao;
		this.nome = nome;
	}
	
	public TipoDocumento(TipoDocumentoDTO dto) {
		this.setId(dto.getId());	
		this.setDataCadastro(dto.getDataCadastro());
		this.descricao = dto.getDescricao();
		this.nome = dto.getNome();
	}

	public TipoDocumento(Long id) {
		this.setId(id);
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
