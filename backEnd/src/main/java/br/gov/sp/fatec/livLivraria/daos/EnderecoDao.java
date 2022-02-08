package br.gov.sp.fatec.livLivraria.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.livLivraria.entities.Endereco;

@Repository
public interface EnderecoDao {
	
	void save (Endereco endereco);
	
	void update (Endereco endereco);
	
	void delete (Long id);
	
	Endereco findById(Long id);
	
	Endereco getReference(Long id);
	
	List<Endereco> findAll();

}
