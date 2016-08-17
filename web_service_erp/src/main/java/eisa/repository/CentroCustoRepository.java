package eisa.repository;

import org.springframework.stereotype.Repository;

import eisa.model.CentroCusto;

@Repository
public class CentroCustoRepository extends GenericDAO<CentroCusto> {

	public CentroCustoRepository() {
		super(CentroCusto.class);
		// TODO Auto-generated constructor stub
	}

}
