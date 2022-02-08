package br.gov.sp.fatec.livLivraria.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.sp.fatec.livLivraria.entities.enums.StatusVenda;

@Entity
@Table(name = "ITENS_PEDIDO")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IPD_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_IPD")
	@SequenceGenerator(name = "SQ_IPD", sequenceName = "SQ_IPD", allocationSize = 1)
	private Long id;

	@Column(name = "IPD_QUANTIDADE")
	private Integer quantidade;

	@Column(name = "IPD_VALOR_VENDA")
	private Double valorVenda;

	@Column(name = "IPD_STATUS")
	private StatusVenda status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IPD_CLI_ID")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IPD_LIV_ID")
	private Livro livro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IPD_VND_ID")
	private Pedido venda;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IPD_CUP_ID", referencedColumnName = "CUP_ID")
	private Cupom cupom;

	public ItemPedido() {
	}

	public ItemPedido(Long id, Integer quantidade, Double valorVenda, StatusVenda status, Cliente cliente, Livro livro,
			Pedido venda, Cupom cupom) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valorVenda = valorVenda;
		this.status = status;
		this.cliente = cliente;
		this.livro = livro;
		this.venda = venda;
		this.cupom = cupom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public StatusVenda getStatus() {
		return status;
	}

	public void setStatus(StatusVenda status) {
		this.status = status;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Pedido getVenda() {
		return venda;
	}

	public void setVenda(Pedido venda) {
		this.venda = venda;
	}

	public Cupom getCupom() {
		return cupom;
	}

	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addQuantidade() {
		this.quantidade++;
	}

	public void removeQuantidade() {
		this.quantidade--;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
