package br.gov.sp.fatec.livLivraria.dto;

import br.gov.sp.fatec.livLivraria.dto.enums.EnumDTO;
import br.gov.sp.fatec.livLivraria.entities.Telefone;

public class TelefoneDTO {

	private Long id;
	private String ddi;
	private String ddd;
	private String numero;
	private EnumDTO tipoTelefone;

	public TelefoneDTO() {
	}

	public TelefoneDTO(Long id, String ddi, String ddd, String numero, EnumDTO tipoTelefone) {
		super();
		this.id = id;
		this.ddi = ddi;
		this.ddd = ddd;
		this.numero = numero;
		this.tipoTelefone = tipoTelefone;
	}

	public TelefoneDTO(Telefone entity) {
		this.setId(entity.getId());
		this.setDdi(entity.getDdi());
		this.setDdd(entity.getDdd());
		this.setNumero(entity.getNumero());
		this.setTipoTelefone(new EnumDTO(entity.getTipoTelefone().getValorNumerico().toString(),
				entity.getTipoTelefone().getDescricao()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public EnumDTO getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(EnumDTO tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

}
