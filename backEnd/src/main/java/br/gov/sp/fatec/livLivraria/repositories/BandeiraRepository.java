package br.gov.sp.fatec.livLivraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.livLivraria.entities.Bandeira;

@Repository
public interface BandeiraRepository extends JpaRepository<Bandeira, Long> {

}
