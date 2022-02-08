package br.gov.sp.fatec.livLivraria.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.sp.fatec.livLivraria.entities.enums.FormaPagamento;
import br.gov.sp.fatec.livLivraria.entities.enums.StatusVenda;

@Entity
@Table(name = "PEDIDOS")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PED_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PED")
	@SequenceGenerator(name = "SQ_PED", sequenceName = "SQ_PED", allocationSize = 1)
	private Long id;

	@Column(name = "PED_STATUS")
	private StatusVenda status;

	@Column(name = "PED_VALOR_FINAL")
	private Double valorFinal;

	@Column(name = "PED_FORMA_PAGAMENTO")
	private FormaPagamento formaPagamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PED_CLI_ID")
	private Cliente cliente;

	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemPedido> itensVenda = new ArrayList<ItemPedido>();

	public Pedido() {
	}

	public Pedido(Long id, StatusVenda status, FormaPagamento formaPagamento, Cliente cliente) {
		super();
		this.id = id;
		this.status = status;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
	}

	public void addItemVenda(ItemPedido itemVenda) {
		this.itensVenda.add(itemVenda);
	}

	public void removeItemVenda(int indexItemVenda) {
		this.itensVenda.remove(indexItemVenda);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusVenda getStatus() {
		return status;
	}

	public void setStatus(StatusVenda status) {
		this.status = status;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public List<ItemPedido> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemPedido> itensVenda) {
		this.itensVenda = itensVenda;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
