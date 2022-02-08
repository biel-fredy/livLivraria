package br.gov.sp.fatec.livLivraria.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.gov.sp.fatec.livLivraria.dto.CartaoDTO;

@Entity
public class Cartao {

	@Id
	@Column(name = "CAR_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CAR")
	@SequenceGenerator(name = "SQ_CAR", sequenceName = "SQ_CAR", allocationSize = 1)
	private Long id;

	@Column(name = "CAR_NUMERO")
	private String numero;

	@Column(name = "CAR_NOME_IMPRESSO")
	private String nomeImpresso;

	@ManyToOne
	@JoinColumn(name = "CAR_BAN_ID")
	private Bandeira bandeira;

	@Column(name = "CAR_DATA_CADASTRO")
	private Instant dataCadastro;

	private String codSeguranca;

	public Cartao() {
	}

	public Cartao(Long id, String numero, String nomeImpresso, Bandeira bandeira, Instant dataCadastro,
			String codSeguranca) {
		super();
		this.id = id;
		this.numero = numero;
		this.nomeImpresso = nomeImpresso;
		this.bandeira = bandeira;
		this.dataCadastro = dataCadastro;
		this.codSeguranca = codSeguranca;
	}

	public Cartao(CartaoDTO dto) {
		this.setId(dto.getId());
		this.setNumero(dto.getNumero());
		this.setNomeImpresso(dto.getNomeImpresso());
		this.setBandeira(new Bandeira(dto.getBandeira()));
		this.setCodSeguranca(dto.getCodSeguranca());
		if(dto.getDataCadastro() != null) {
			this.dataCadastro = Instant.parse(dto.getDataCadastro());
		}		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNomeImpresso() {
		return nomeImpresso;
	}

	public void setNomeImpresso(String nomeImpresso) {
		this.nomeImpresso = nomeImpresso;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public String getCodSeguranca() {
		return codSeguranca;
	}

	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
