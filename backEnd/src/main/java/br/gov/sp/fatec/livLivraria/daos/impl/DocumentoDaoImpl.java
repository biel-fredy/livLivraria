package br.gov.sp.fatec.livLivraria.daos.impl;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.livLivraria.daos.AbstractDao;
import br.gov.sp.fatec.livLivraria.daos.DocumentoDao;
import br.gov.sp.fatec.livLivraria.entities.Documento;

@Repository
public class DocumentoDaoImpl extends AbstractDao<Documento, Long> implements DocumentoDao {

	@Override
	public Documento findByCodigo(String codigo) {

		TypedQuery<Documento> query = getEntityManager()
				.createQuery("select d from Documento d where d.codigo like :codigo", Documento.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

}
