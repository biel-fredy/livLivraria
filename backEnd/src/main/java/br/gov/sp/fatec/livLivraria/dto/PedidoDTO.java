package br.gov.sp.fatec.livLivraria.dto;

import java.util.ArrayList;
import java.util.List;

import br.gov.sp.fatec.livLivraria.entities.Cliente;
import br.gov.sp.fatec.livLivraria.entities.ItemPedido;
import br.gov.sp.fatec.livLivraria.entities.Pedido;
import br.gov.sp.fatec.livLivraria.entities.enums.FormaPagamento;
import br.gov.sp.fatec.livLivraria.entities.enums.StatusVenda;

public class PedidoDTO {

	private Long id;
	private StatusVenda status;
	private Double valorFinal;
	private FormaPagamento formaPagamento;
	private Cliente cliente;
	private List<ItemPedidoDTO> itensPedido = new ArrayList<ItemPedidoDTO>();

	public PedidoDTO() {

	}

	public PedidoDTO(Long id, StatusVenda status, Double valorFinal, FormaPagamento formaPagamento, Cliente cliente,
			List<ItemPedidoDTO> itensPedido) {
		super();
		this.id = id;
		this.status = status;
		this.valorFinal = valorFinal;
		this.formaPagamento = formaPagamento;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
	}

	public PedidoDTO(Pedido entity) {
		this.setId(entity.getId());
		this.setStatus(entity.getStatus());
		this.setValorFinal(entity.getValorFinal());
		this.setFormaPagamento(entity.getFormaPagamento());
		this.setCliente(entity.getCliente());
	}

	public PedidoDTO(Pedido entity, List<ItemPedido> itensPedido) {
		this(entity);
		itensPedido.forEach(ipd -> this.addItemPedido(new ItemPedidoDTO(ipd)));
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

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
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

	public List<ItemPedidoDTO> getItensPedido() {
		return itensPedido;
	}

	public void addItemPedido(ItemPedidoDTO itemPedido) {
		itensPedido.add(itemPedido);
	}

}
