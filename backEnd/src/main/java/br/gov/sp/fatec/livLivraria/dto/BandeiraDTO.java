package br.gov.sp.fatec.livLivraria.dto;

import br.gov.sp.fatec.livLivraria.entities.Bandeira;

public class BandeiraDTO {

	private Long id;

	private String nomeBandeira;

	private String dataCadastro;

	public BandeiraDTO() {
	}

	public BandeiraDTO(String idBandeira) {
		super();
		this.id = Long.parseLong(idBandeira);
	}

	public BandeiraDTO(Long id, String nomeBandeira, String dataCadastro) {
		super();
		this.id = id;
		this.nomeBandeira = nomeBandeira;
		this.dataCadastro = dataCadastro;
	}

	public BandeiraDTO(Bandeira entity) {
		this.setId(entity.getId());
		this.setNomeBandeira(entity.getNomeBandeira());
		if(entity.getDataCadastro() != null) {
			this.setDataCadastro(entity.getDataCadastro().toString());
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

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
