package br.gov.sp.fatec.livLivraria.dto.enums;

import br.gov.sp.fatec.livLivraria.entities.enums.TipoTelefone;

public class TipoTelefoneDTO extends EnumDTO {
	
	public TipoTelefoneDTO(TipoTelefone tipoTelefone) {
		this.setValorNumerico(tipoTelefone.getValorNumerico().toString());
		this.setDescricao(tipoTelefone.getDescricao());
	}

}
