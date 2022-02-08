package br.gov.sp.fatec.livLivraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.livLivraria.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	// @Query("select e from Endereco e where e.end_cli_id = ?1")
	// public List<Endereco> findByCliente(String idCliente);

}
