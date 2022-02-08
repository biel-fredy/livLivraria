package br.gov.sp.fatec.livLivraria.entities;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	private List<ItemPedido> itensVenda = new ArrayList<ItemPedido>();

	public Carrinho() {
	}

	public List<ItemPedido> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemPedido> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public void addItem(ItemPedido itemVenda) {
		this.itensVenda.add(itemVenda);
	}

	public void removeItem(Long id) {
		for (int i = 0; i < this.itensVenda.size(); i++) {
			if (this.itensVenda.get(i).getLivro().getId() == id) {
				this.getItensVenda().remove(i);
			}
		}
	}
	
	public void removeItem(ItemPedido item) {
		this.itensVenda.remove(item);
	}
	
	public Double totalCarrinho(){
		Double total = 0d;
		for (ItemPedido item : this.itensVenda) {
			total += item.getValorVenda() * item.getQuantidade();
		}
		return total;
	}
}
