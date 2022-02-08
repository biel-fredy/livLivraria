package br.gov.sp.fatec.livLivraria.dto.enums;

import br.gov.sp.fatec.livLivraria.entities.enums.TipoLogradouro;

public class TipoLogradouroDTO extends EnumDTO {
	
	public TipoLogradouroDTO(TipoLogradouro tipoLogradouro) {
		this.setValorNumerico(tipoLogradouro.getValorNumerico().toString());
		this.setDescricao(tipoLogradouro.getDescricao());
	}

}
