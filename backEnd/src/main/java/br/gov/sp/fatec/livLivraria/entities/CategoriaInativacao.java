package br.gov.sp.fatec.livLivraria.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "0")
public class CategoriaInativacao extends CategoriaStatus{

	private static final long serialVersionUID = 1L;

}
