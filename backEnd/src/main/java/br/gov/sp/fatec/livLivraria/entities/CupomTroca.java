package br.gov.sp.fatec.livLivraria.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "0")
public class CupomTroca extends Cupom {

	private static final long serialVersionUID = 1L;
	
	private ItemPedido itemVendaTrocado;

	public ItemPedido getItemVenda() {
		return itemVendaTrocado;
	}

	public void setItemVenda(ItemPedido itemVendaTrocado) {
		this.itemVendaTrocado = itemVendaTrocado;
	}

}
