package br.gov.sp.fatec.livLivraria.dto;

import br.gov.sp.fatec.livLivraria.entities.Cartao;

public class CartaoDTO {

	private Long id;

	private String numero;

	private String nomeImpresso;

	private BandeiraDTO bandeira;

	private String codSeguranca;

	private String dataCadastro;

	public CartaoDTO() {
	}

	public CartaoDTO(Long id, String numero, String nomeImpresso, String bandeira, String codSeguranca,
			String dataCadastro) {
		super();
		this.id = id;
		this.numero = numero;
		this.nomeImpresso = nomeImpresso;
		this.bandeira = new BandeiraDTO(bandeira);
		this.codSeguranca = codSeguranca;
		this.dataCadastro = dataCadastro;
	}

	public CartaoDTO(Cartao entity) {
		this.setId(entity.getId());
		this.setNumero(entity.getNumero());
		this.setNomeImpresso(entity.getNomeImpresso());
		this.setBandeira(new BandeiraDTO(entity.getBandeira()));
		this.setCodSeguranca(entity.getCodSeguranca());
		this.setDataCadastro(entity.getDataCadastro().toString());
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

	public BandeiraDTO getBandeira() {
		return bandeira;
	}

	public void setBandeira(BandeiraDTO bandeira) {
		this.bandeira = bandeira;
	}

	public String getCodSeguranca() {
		return codSeguranca;
	}

	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
