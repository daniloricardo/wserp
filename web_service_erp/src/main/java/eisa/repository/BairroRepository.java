package eisa.repository;

import java.util.List;

import eisa.model.Bairro;


import org.springframework.stereotype.Repository;

@Repository
public class BairroRepository extends GenericDAO<Bairro> {

	public BairroRepository() {
		super(Bairro.class);
		
	}
	@SuppressWarnings("unchecked")
	public List<Bairro> findByLike(String nome){
		nome = nome.toUpperCase();
		nome = "%"+nome+"%";
		return getEntityManager().createQuery("from Bairro b where UPPER(b.nome) like :nome ")
		.setParameter("nome", nome)
		.getResultList();
		
	}

}
