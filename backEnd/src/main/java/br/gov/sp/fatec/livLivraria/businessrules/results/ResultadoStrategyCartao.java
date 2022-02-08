package br.gov.sp.fatec.livLivraria.businessrules.results;

import java.util.List;

import br.gov.sp.fatec.livLivraria.entities.Cartao;

public class ResultadoStrategyCartao extends AbstractResultadoStrategy {
	
	private Cartao cartao;

	public ResultadoStrategyCartao() {
	}

	public ResultadoStrategyCartao(List<String> mensagens, Cartao cartao) {
		super(mensagens);
		this.cartao = cartao;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}	

}
