package br.gov.sp.fatec.livLivraria.entities.enums.converters;

import javax.persistence.AttributeConverter;

import br.gov.sp.fatec.livLivraria.entities.enums.TipoEndereco;

public class TipoEnderecoConverter implements AttributeConverter<TipoEndereco, Integer>{
	

	@Override
	public Integer convertToDatabaseColumn(TipoEndereco attribute) {
		return attribute.getValorNumerico();
	}

	@Override
	public TipoEndereco convertToEntityAttribute(Integer dbData) {
		return TipoEndereco.valorToEnum(dbData);
	}

}
