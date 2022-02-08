package br.gov.sp.fatec.livLivraria.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.gov.sp.fatec.livLivraria.dto.BandeiraDTO;

@Entity
public class Bandeira {

	@Id
	@Column(name = "BAN_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BAN")
	@SequenceGenerator(name = "SQ_BAN", sequenceName = "SQ_BAN", initialValue = 10, allocationSize = 1)
	private Long id;

	@Column(name = "BAN_NOME")
	private String nomeBandeira;

	@Column(name = "BAN_DATA_CADASTRO")
	private Instant dataCadastro;

	public Bandeira() {
	}

	public Bandeira(Long id, String nomeBandeira, Instant dataCadastro) {
		super();
		this.id = id;
		this.nomeBandeira = nomeBandeira;
		this.dataCadastro = dataCadastro;
	}

	public Bandeira(BandeiraDTO dto) {
		System.out.println("id bandeira - Constructor Bandeira:" + dto.getId());
		this.setId(dto.getId());
		this.setNomeBandeira(dto.getNomeBandeira());
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

	public String getNomeBandeira() {
		return nomeBandeira;
	}

	public void setNomeBandeira(String nomeBandeira) {
		this.nomeBandeira = nomeBandeira;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
