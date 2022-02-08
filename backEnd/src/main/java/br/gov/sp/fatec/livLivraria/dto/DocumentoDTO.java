package br.gov.sp.fatec.livLivraria.dto;

import java.time.Instant;

import br.gov.sp.fatec.livLivraria.entities.Documento;

public class DocumentoDTO {

	private Long id;
	private String codigo;
	private Instant validade;
	private TipoDocumentoDTO tipoDocumento;
	private ClienteDTO cliente;
	private Instant dataCadastro;

	public DocumentoDTO() {

	}

	public DocumentoDTO(String codigo, Instant validade, TipoDocumentoDTO tipoDocumento, ClienteDTO cliente) {
		super();
		this.codigo = codigo;
		this.validade = validade;
		this.tipoDocumento = tipoDocumento;
		this.cliente = cliente;
	}

	public DocumentoDTO(Documento entity) {
		this.setId(entity.getId());
		this.setDataCadastro(entity.getDataCadastro());
		this.codigo = entity.getCodigo();
		this.validade = entity.getValidade();
		this.tipoDocumento = new TipoDocumentoDTO(entity.getTipoDocumento());
		this.cliente = new ClienteDTO(entity.getCliente());
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Instant getValidade() {
		return validade;
	}

	public void setValidade(Instant validade) {
		this.validade = validade;
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
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

}
