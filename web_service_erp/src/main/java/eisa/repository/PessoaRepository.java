package eisa.repository;

import java.util.List;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import eisa.model.Pessoa;

import org.springframework.stereotype.Repository;





@Repository
public class PessoaRepository extends GenericDAO<Pessoa> {

	public PessoaRepository() {
		super(Pessoa.class);
		
	}
	@SuppressWarnings("unchecked")
	public List<Pessoa> findAll(){
		return super.em.createQuery("from Pessoa p order by p.id desc ")
				.setMaxResults(300)
				.getResultList();
	}
	
	
}
