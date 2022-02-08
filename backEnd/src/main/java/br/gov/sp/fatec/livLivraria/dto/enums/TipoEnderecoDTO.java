package br.gov.sp.fatec.livLivraria.dto.enums;

import br.gov.sp.fatec.livLivraria.entities.enums.TipoEndereco;

public class TipoEnderecoDTO extends EnumDTO {
	
	public TipoEnderecoDTO(TipoEndereco tipoEndereco) {
		this.setValorNumerico(tipoEndereco.getValorNumerico().toString());
		this.setDescricao(tipoEndereco.getDescricao());
	}

}
