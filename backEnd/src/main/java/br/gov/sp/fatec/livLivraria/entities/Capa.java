package br.gov.sp.fatec.livLivraria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CAPAS")
public class Capa {

	@Id
	@Column(name = "CAP_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CAP")
	@SequenceGenerator(name = "SQ_CAP", sequenceName = "SQ_CAP", allocationSize = 1)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CAP_URL")
	private String url;

	@Column(name = "CAP_DESCRICAO")
	private String descricao;

	@OneToOne(mappedBy = "capa")
	private Livro livro;

	public Capa() {
	}

	public Capa(String url, String descricao, Livro livro) {
		super();
		this.url = url;
		this.descricao = descricao;
		this.livro = livro;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
