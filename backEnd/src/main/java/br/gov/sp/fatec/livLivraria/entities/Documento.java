package br.gov.sp.fatec.livLivraria.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.gov.sp.fatec.livLivraria.dto.DocumentoDTO;

@Entity
public class Documento {

	@Id
	@Column(name = "DOC_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DOC")
	@SequenceGenerator(name = "SQ_DOC", sequenceName = "SQ_DOC", allocationSize = 1)
	private Long id;

	@Column(name = "DOC_COD")
	private String codigo;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE", name = "DOC_VALIDADE")
	private Instant validade;

	@Column(name = "DOC_DATA_CADASTRO")
	private Instant dataCadastro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private TipoDocumento tipoDocumento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Cliente cliente;

	public Documento() {

	}

	public Documento(String codigo, Instant validade, TipoDocumento tipoDocumento, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.validade = validade;
		this.tipoDocumento = tipoDocumento;
		this.cliente = cliente;
	}

	public Documento(DocumentoDTO dto) {
		this.setId(dto.getId());
		this.setDataCadastro(dto.getDataCadastro());
		this.codigo = dto.getCodigo();
		this.validade = dto.getValidade();
		this.tipoDocumento = new TipoDocumento(dto.getTipoDocumento());
	}

	public Documento(Long id) {
		this.setId(id);
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

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
