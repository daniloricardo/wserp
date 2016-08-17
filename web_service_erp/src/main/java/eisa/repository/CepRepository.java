package eisa.repository;

import java.util.List;

import javax.persistence.NoResultException;

import eisa.model.Bairro;
import eisa.model.CEP;


import org.springframework.stereotype.Repository;

@Repository
public class CepRepository extends GenericDAO<CEP> {

	public CepRepository() {
		super(CEP.class);
		
	}
	@SuppressWarnings("unchecked")
	public CEP findByCdCep(String cep){
		if(!cep.contains("-")){
			cep = cep.substring(0, 5)+"-"+cep.substring(5, 8);
		}
		try{
		return (CEP) super.em.createQuery("from CEP c where c.CdCEP = :cep ")
		.setParameter("cep", cep)
		.getSingleResult();
		}
		catch(NoResultException e){
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
