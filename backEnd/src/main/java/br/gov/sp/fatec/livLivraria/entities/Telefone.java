package br.gov.sp.fatec.livLivraria.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.sp.fatec.livLivraria.dto.TelefoneDTO;
import br.gov.sp.fatec.livLivraria.entities.enums.TipoTelefone;
import br.gov.sp.fatec.livLivraria.entities.enums.converters.TipoTelefoneConverter;

@Entity
@Table(name = "TELEFONES")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TEL")
	@SequenceGenerator(name = "SQ_TEL", sequenceName = "SQ_TEL", allocationSize = 1)
	@Column(name = "TEL_ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "TEL_DDI")
	private String ddi;

	@Column(name = "TEL_DDD")
	private String ddd;

	@Column(name = "TEL_NUMERO")
	private String numero;

	@Column(name = "TEL_TIPO")
	@Convert(converter = TipoTelefoneConverter.class)
	private TipoTelefone tipoTelefone;

	public Telefone() {
	}

	public Telefone(Long id, String ddi, String ddd, String numero, TipoTelefone tipoTelefone) {
		super();
		this.id = id;
		this.ddi = ddi;
		this.ddd = ddd;
		this.numero = numero;
		this.tipoTelefone = tipoTelefone;
	}
	
	public Telefone(TelefoneDTO dto) {
		this.id = dto.getId();
		this.ddi = dto.getDdi();
		this.ddd = dto.getDdd();
		this.numero = dto.getNumero();
		this.tipoTelefone = TipoTelefone.valorToEnum(Integer.parseInt(dto.getTipoTelefone().getValorNumerico()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
