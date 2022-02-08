package br.gov.sp.fatec.livLivraria.entities.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.gov.sp.fatec.livLivraria.entities.enums.StatusVenda;

@Converter
public class StatusVendaConverter implements AttributeConverter<StatusVenda, Integer> {

	@Override
	public Integer convertToDatabaseColumn(StatusVenda attribute) {
		return attribute.getValorNumerico();
	}

	@Override
	public StatusVenda convertToEntityAttribute(Integer dbData) {
		return StatusVenda.valorToEnum(dbData);
	}

}
