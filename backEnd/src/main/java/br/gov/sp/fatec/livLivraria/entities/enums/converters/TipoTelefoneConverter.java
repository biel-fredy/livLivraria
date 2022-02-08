package br.gov.sp.fatec.livLivraria.entities.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.sp.fatec.livLivraria.entities.enums.TipoTelefone;

@Converter
public class TipoTelefoneConverter implements AttributeConverter<TipoTelefone, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoTelefone attribute) {
		return attribute.getValorNumerico();
	}

	@Override
	public TipoTelefone convertToEntityAttribute(Integer dbData) {
		return TipoTelefone.valorToEnum(dbData);
	}
}
