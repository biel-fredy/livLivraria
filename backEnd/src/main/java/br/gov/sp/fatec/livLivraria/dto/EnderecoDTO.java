package br.gov.sp.fatec.livLivraria.dto;

import java.time.Instant;

import br.gov.sp.fatec.livLivraria.dto.enums.EnumDTO;
import br.gov.sp.fatec.livLivraria.entities.Endereco;

public class EnderecoDTO {

	private Long id;
	private String apelido;
	private String logradouro;
	private String numero;
	private String cep;
	private String complemento;
	private EnumDTO tipoEndereco;
	private String bairro;
	private String observacoes;
	private Boolean enderecoCobranca;
	private Boolean enderecoEntrega;
	private String cidade;
	private String estado;
	private String pais;
	private Instant dataCadastro;

	public EnderecoDTO() {
	}

	public EnderecoDTO(Long id, String apelido, String logradouro, String numero, String cep, String complemento,
			EnumDTO tipoEndereco, String bairro, String observacoes, Boolean enderecoCobranca, Boolean enderecoEntrega,
			String cidade, String estado, String pais, Instant dataCadastro) {
		super();
		this.id = id;
		this.apelido = apelido;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
		this.tipoEndereco = tipoEndereco;
		this.bairro = bairro;
		this.observacoes = observacoes;
		this.enderecoCobranca = enderecoCobranca;
		this.enderecoEntrega = enderecoEntrega;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.dataCadastro = dataCadastro;
	}

	public EnderecoDTO(Endereco entity) {
		this.setId(entity.getId());
		this.setApelido(entity.getApelido());
		this.setLogradouro(entity.getLogradouro());
		this.setNumero(entity.getNumero());
		this.setCep(entity.getCep());
		this.setComplemento(entity.getComplemento());
		this.tipoEndereco = new EnumDTO(entity.getTipoEndereco().getValorNumerico().toString(),
				entity.getTipoEndereco().getDescricao());
		this.setBairro(entity.getBairro());
		this.setObservacoes(entity.getObservacoes());
		this.setEnderecoCobranca(entity.getEnderecoCobranca());
		this.setEnderecoEntrega(entity.getEnderecoEntrega());
		this.setCidade(entity.getCidade().getDescricao());
		this.setEstado(entity.getCidade().getEstado().getDescricao());
		this.setPais(entity.getCidade().getEstado().getPais().getDescricao());
		this.setDataCadastro(entity.getDataCadastro());
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public EnumDTO getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(EnumDTO tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Boolean getEnderecoCobranca() {
		return enderecoCobranca;
	}

	public void setEnderecoCobranca(Boolean enderecoCobranca) {
		this.enderecoCobranca = enderecoCobranca;
	}

	public Boolean getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Boolean enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
