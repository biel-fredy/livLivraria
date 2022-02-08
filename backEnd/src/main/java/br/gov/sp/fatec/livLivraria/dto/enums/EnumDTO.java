package br.gov.sp.fatec.livLivraria.dto.enums;

public class EnumDTO {
	
	private String valorNumerico;
	private String descricao;
	
	public EnumDTO() {}
	
	public EnumDTO(String valorNumerico, String descricao) {
		this.valorNumerico = valorNumerico;
		this.descricao = descricao;
	}
	
	public EnumDTO(String valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public String getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(String valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
