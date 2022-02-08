package br.gov.sp.fatec.livLivraria.daos.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.livLivraria.daos.AbstractDao;
import br.gov.sp.fatec.livLivraria.daos.ClienteDao;
import br.gov.sp.fatec.livLivraria.entities.Cliente;

@Repository
public class ClienteDaoImpl extends AbstractDao<Cliente, Long> implements ClienteDao {
	
	public List<Cliente> find(Long idCliente, String nome, Boolean status, String email, String genero,
			LocalDate dataNascimento){
		
		CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
		
		CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
		Root<Cliente> root = criteriaQuery.from(Cliente.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(idCliente != null && idCliente != 0) {
			predicates.add(criteriaBuilder.equal(root.get("id"), idCliente));
		}
		
		if(nome != null && nome.trim() != "") {
			nome= "%" + nome + "%";
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), nome.toLowerCase()));
		}
		
		if(status != null) {
			predicates.add(criteriaBuilder.equal(root.get("status"), status));
		}
		
		if(email != null && email.trim() != "") {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), email.toLowerCase()));
		}
		
		if(genero != null && genero.trim() != "") {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("genero")), genero.toLowerCase()));
		}
		
		if(dataNascimento != null) {
			predicates.add(criteriaBuilder.equal(root.get("dataNascimento"), dataNascimento));
		}
		
		criteriaQuery.select(root).where(predicates.toArray(new Predicate[] {}));
		
		TypedQuery<Cliente> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		List<Cliente> lista = typedQuery.getResultList();
		
		return lista;
		
	}


}
