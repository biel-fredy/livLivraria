package br.gov.sp.fatec.livLivraria.dto;

import br.gov.sp.fatec.livLivraria.entities.ItemPedido;
import br.gov.sp.fatec.livLivraria.entities.enums.StatusVenda;

public class ItemPedidoDTO {
	
	private Long id;
	private Integer quantidade;
	private Double valorVenda;
	private StatusVenda status;
	private LivroDTO livro;
	private PedidoDTO pedido;
	private CupomDTO cupom;
	
	public ItemPedidoDTO() {}
		
	public ItemPedidoDTO(Long id, Integer quantidade, Double valorVenda, StatusVenda status, LivroDTO livro,
			PedidoDTO pedido, CupomDTO cupom) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valorVenda = valorVenda;
		this.status = status;
		this.livro = livro;
		this.pedido = pedido;
		this.cupom = cupom;
	}
	
	public ItemPedidoDTO(ItemPedido entity) {
		this.setId(entity.getId());
		this.setQuantidade(entity.getQuantidade());
		this.setValorVenda(entity.getValorVenda());
		this.setStatus(entity.getStatus());
		this.setLivro(new LivroDTO(entity.getLivro()));
		this.setPedido(new PedidoDTO(entity.getVenda()));
		this.setCupom(new CupomDTO(entity.getCupom()));
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

	public LivroDTO getLivro() {
		return livro;
	}

	public void setLivro(LivroDTO livro) {
		this.livro = livro;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public CupomDTO getCupom() {
		return cupom;
	}

	public void setCupom(CupomDTO cupom) {
		this.cupom = cupom;
	}


	
	
	
	

}
