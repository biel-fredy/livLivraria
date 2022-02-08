package br.gov.sp.fatec.livLivraria.entities.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.sp.fatec.livLivraria.entities.enums.TipoResidencia;

@Converter
public class TipoResidenciaConverter implements AttributeConverter<TipoResidencia, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TipoResidencia attribute) {
		return attribute.getValorNumerico();
	}

	@Override
	public TipoResidencia convertToEntityAttribute(Integer dbData) {
		return TipoResidencia.valorToEnum(dbData);
	}

}
