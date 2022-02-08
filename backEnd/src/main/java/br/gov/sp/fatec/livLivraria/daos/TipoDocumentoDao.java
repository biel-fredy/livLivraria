package br.gov.sp.fatec.livLivraria.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.livLivraria.entities.TipoDocumento;

@Repository
public interface TipoDocumentoDao {

	void save(TipoDocumento tipoDocumento);

	void update(TipoDocumento tipoDocumento);

	void delete(Long id);

	TipoDocumento findById(Long id);
	
	TipoDocumento getReference(Long id);

	List<TipoDocumento> findAll();

}
