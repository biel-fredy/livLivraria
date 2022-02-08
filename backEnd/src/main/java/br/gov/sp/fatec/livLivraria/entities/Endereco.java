package br.gov.sp.fatec.livLivraria.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.gov.sp.fatec.livLivraria.dto.EnderecoDTO;
import br.gov.sp.fatec.livLivraria.entities.enums.TipoEndereco;
import br.gov.sp.fatec.livLivraria.entities.enums.converters.TipoEnderecoConverter;

@Entity
public class Endereco {

	@Id
	@Column(name = "END_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_END")
	@SequenceGenerator(name = "SQ_END", sequenceName = "SQ_END", allocationSize = 1)
	private Long id;
	
	@Column(name = "END_APELIDO")
	private String apelido;

	@Column(name = "END_LOGRADOURO")
	private String logradouro;

	@Column(name = "END_NUMERO")
	private String numero;

	@Column(name = "END_CEP")
	private String cep;

	@Column(name = "END_COMPLEMENTO")
	private String complemento;

	@Column(name = "END_TIPO")
	@Convert(converter = TipoEnderecoConverter.class)
	private TipoEndereco tipoEndereco;

	@Column(name = "END_BAIRRO")
	private String bairro;

	@Column(name = "END_OBSERVACOES")
	private String observacoes;
	
	@Column(name = "END_ENDERECO_COBRANCA", columnDefinition="tinyint(1) default 1")
	private Boolean enderecoCobranca;
	
	@Column(name = "END_ENDERECO_ENTREGA", columnDefinition="tinyint(1) default 1")
	private Boolean enderecoEntrega;

	@Embedded
	private Cidade cidade;

	@Column(name = "END_DATA_CADASTRO")
	private Instant dataCadastro;

	public Endereco() {
	}

	public Endereco(Long id, String apelido, String logradouro, String numero, String cep, String complemento,
			TipoEndereco tipoEndereco, String bairro, String observacoes, Boolean enderecoCobranca,
			Boolean enderecoEntrega, Cidade cidade, Instant dataCadastro) {
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
		this.dataCadastro = dataCadastro;
	}

	public Endereco(EnderecoDTO dto) {
		this.setId(dto.getId());
		this.setApelido(dto.getApelido());
		this.setLogradouro(dto.getLogradouro());
		this.setNumero(dto.getNumero());
		this.setCep(dto.getCep());
		this.setComplemento(dto.getComplemento());
		this.setTipoEndereco(TipoEndereco.valorToEnum((Integer.parseInt(dto.getTipoEndereco().getValorNumerico()))));
		this.setBairro(dto.getBairro());
		this.setObservacoes(dto.getObservacoes());
		this.setEnderecoCobranca(dto.getEnderecoCobranca());
		this.setEnderecoEntrega(dto.getEnderecoEntrega());
		this.setCidade(new Cidade(dto.getCidade(), new Estado(dto.getEstado(), dto.getPais())));
		this.setDataCadastro(dto.getDataCadastro());
	}

	public Endereco(Long id) {
		this.setId(id);
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

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
	
	

}
