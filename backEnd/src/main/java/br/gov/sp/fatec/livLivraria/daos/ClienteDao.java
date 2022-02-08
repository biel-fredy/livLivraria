package br.gov.sp.fatec.livLivraria.daos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.livLivraria.entities.Cliente;

@Repository
public interface ClienteDao {

	void save(Cliente cliente);

	void update(Cliente cliente);

	void delete(Long id);

	Cliente findById(Long id);
	
	Cliente getReference(Long id);
	
	List<Cliente> findAll();

	List<Cliente> find(Long idCliente, String nome, Boolean status, String email, String genero,
			LocalDate dataNascimento);

}
