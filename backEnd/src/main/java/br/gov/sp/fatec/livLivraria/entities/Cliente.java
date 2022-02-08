package br.gov.sp.fatec.livLivraria.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.gov.sp.fatec.livLivraria.dto.CartaoDTO;
import br.gov.sp.fatec.livLivraria.dto.ClienteDTO;
import br.gov.sp.fatec.livLivraria.dto.DocumentoDTO;
import br.gov.sp.fatec.livLivraria.dto.EnderecoDTO;
import br.gov.sp.fatec.livLivraria.dto.TelefoneDTO;

@Entity
public class Cliente {

	@Id
	@Column(name = "CLI_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLI")
	@SequenceGenerator(name = "SQ_CLI", sequenceName = "SQ_CLI", allocationSize = 1)
	private Long id;

	@Column(name = "CLI_NOME")
	private String nome;

	@Column(name = "CLI_STATUS")
	private Boolean status;

	@Column(name = "CLI_GENERO")
	private String genero;

	@Column(name = "CLI_DATA_NASCIMENTO", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDate dataNascimento;

	@Column(name = "CLI_CPF")
	private String cpf;

	@Column(name = "CLI_EMAIL")
	private String email;

	@Column(name = "CLI_DATA_CADASTRO")
	private Instant dataCadastro;

	@Column(name = "CLI_RANKING")
	private Long ranking;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "TEL_CLI_ID")
	private List<Telefone> telefones = new ArrayList<Telefone>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "END_CLI_ID")
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Documento> documentos = new ArrayList<Documento>();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CAR_CLI_ID")
	private List<Cartao> cartoes = new ArrayList<Cartao>();

	public Cliente() {

	}

	public Cliente(Long id, String nome, Boolean status, String genero, LocalDate dataNascimento, String cpf,
			String email, Instant dataCadastro, Long ranking) {
		super();
		this.id = id;
		this.nome = nome;
		this.status = status;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.ranking = ranking;
	}

	public Cliente(ClienteDTO dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.status = dto.getStatus();
		this.genero = dto.getGenero();
		if(dto.getDataNascimento() != null) {
			this.dataNascimento = LocalDate.parse(dto.getDataNascimento(), formatter);
		}
		this.cpf = dto.getCpf();
		this.email = dto.getEmail();
		if(dto.getDataCadastro() != null) {
			this.dataCadastro = Instant.parse(dto.getDataCadastro());
		}		
		this.ranking = dto.getRanking();
	}

	public Cliente(ClienteDTO dto, List<DocumentoDTO> documentosDTO, List<EnderecoDTO> enderecosDTO,
			List<TelefoneDTO> telefonesDTO, List<CartaoDTO> cartoesDTO) {
		this(dto);
		documentosDTO.forEach(doc -> this.addDocumento(new Documento(doc)));
		enderecosDTO.forEach(end -> this.addEndereco(new Endereco(end)));
		telefonesDTO.forEach(tel -> this.addTelefone(new Telefone(tel)));
		cartoesDTO.forEach(car -> this.addCartao(new Cartao(car)));
	}

	public Cliente(Long id) {
		this.setId(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void removeEndereco(Endereco endereco) {
		this.enderecos.remove(endereco);
	}

	public void addDocumento(Documento documento) {
		this.documentos.add(documento);
	}

	public void removeDocumento(Documento documento) {
		this.documentos.remove(documento);
	}
	
	public void addCartao(Cartao cartao) {
		this.cartoes.add(cartao);
	}
	
	public void removeCartao(Cartao cartao) {
		this.cartoes.remove(cartao);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + this.getId() + ", nome=" + nome + ", enderecos=" + enderecos + "]";
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRanking() {
		return ranking;
	}

	public void setRanking(Long ranking) {
		this.ranking = ranking;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public List<Pedido> getCompras() {
		return pedidos;
	}
	
	public List<Cartao> getCartoes(){
		return cartoes;
	}

	public void addTelefone(Telefone telefone) {
		this.telefones.add(telefone);
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

}
