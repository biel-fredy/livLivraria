package br.gov.sp.fatec.livLivraria.dto;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.entities.Cartao;
import br.gov.sp.fatec.livLivraria.entities.Cliente;
import br.gov.sp.fatec.livLivraria.entities.Documento;
import br.gov.sp.fatec.livLivraria.entities.Endereco;
import br.gov.sp.fatec.livLivraria.entities.Pedido;
import br.gov.sp.fatec.livLivraria.entities.Telefone;

public class ClienteDTO {

	private Long id;
	private String nome;
	private String dataCadastro;
	private Boolean status;
	private String genero;
	private String dataNascimento;
	private String cpf;
	private String email;
	private Long ranking;
	private List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
	private List<DocumentoDTO> documentos = new ArrayList<DocumentoDTO>();
	private List<PedidoDTO> pedidos = new ArrayList<PedidoDTO>();
	private List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
	private List<CartaoDTO> cartoes = new ArrayList<CartaoDTO>();

	public ClienteDTO() {
	}

	public ClienteDTO(Long id, String nome, String dataCadastro, Boolean status, String genero, String dataNascimento,
			String cpf, String email, Long ranking, List<EnderecoDTO> enderecos, List<DocumentoDTO> documentos,
			List<PedidoDTO> pedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.email = email;
		this.ranking = ranking;
		this.enderecos = enderecos;
		this.documentos = documentos;
		this.pedidos = pedidos;
	}

	public ClienteDTO(Cliente entity) {
		this.setId(entity.getId());
		this.setNome(entity.getNome());
		this.setDataCadastro(entity.getDataCadastro().toString());
		this.setStatus(entity.getStatus());
		this.setGenero(entity.getGenero());
		this.setDataNascimento(entity.getDataNascimento().toString());
		this.setCpf(entity.getCpf());
		this.setEmail(entity.getEmail());
		this.setRanking(entity.getRanking());
	}

	public ClienteDTO(Cliente entity, List<Documento> documentos, List<Endereco> enderecos, List<Pedido> pedidos,
			List<Telefone> telefones, List<Cartao> cartoes) {
		this(entity);
		documentos.forEach(doc -> this.addDocumento(new DocumentoDTO(doc)));
		enderecos.forEach(end -> this.addEndereco(new EnderecoDTO(end)));
		pedidos.forEach(ped -> this.addPedido(new PedidoDTO(ped)));
		telefones.forEach(tel -> this.addTelefone(new TelefoneDTO(tel)));
		cartoes.forEach(car -> this.addCartao(new CartaoDTO(car)));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DocumentoDTO> getDocumentos() {
		return documentos;
	}

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void addDocumento(DocumentoDTO documento) {
		this.documentos.add(documento);
	}

	public void addEndereco(EnderecoDTO endereco) {
		this.enderecos.add(endereco);
	}

	public void addTelefone(TelefoneDTO telefone) {
		this.telefones.add(telefone);
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
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

	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void addPedido(PedidoDTO pedido) {
		this.addPedido(pedido);
	}

	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}

	public void addCartao(CartaoDTO cartao) {
		this.cartoes.add(cartao);
	}

	public List<CartaoDTO> getCartoes() {
		return cartoes;
	}

}
