package br.gov.sp.fatec.livLivraria.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.livLivraria.entities.Documento;

@Repository
public interface DocumentoDao {

	void save(Documento documento);

	void update(Documento documento);

	void delete(Long id);

	Documento findById(Long id);
	
	Documento getReference(Long id);
	
	Documento findByCodigo(String codigo);

	List<Documento> findAll();

}
