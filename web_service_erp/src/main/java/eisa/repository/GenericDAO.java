package eisa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;




@PersistenceContext
public abstract class GenericDAO<T> {
	
	
	@Autowired
	EntityManager em;
	
	private Class<T> classe;
	
	public GenericDAO(Class<T> classe){
		this.classe = classe;
	}
	@Transactional
	public void save(T entity){
		em.persist(entity);
	}
	@Transactional
	public void update(T entity){
		em.merge(entity);
	}
	public T findById(String id){
		em.clear();
		return em.find(classe, id);
	}
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
	        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	        cq.select(cq.from(classe));
	        return em.createQuery(cq).setMaxResults(500).getResultList();
	    }
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAllMax10() {
	        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
	        cq.select(cq.from(classe));
	        return em.createQuery(cq)
	        		.setMaxResults(10)
	        		.getResultList();
	    }

	
	 public String converteB36(int valor){
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("sp_IntToB36");
			query.setParameter("x", valor);
			query.execute();
			String dado = (String) query.getOutputParameterValue("dado").toString();
			return dado;
		}
		public int pegaUltimoCodigo(String tabela,String campo){
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("sp_GetNextCode");
			query.setParameter("TableName", tabela);
			query.setParameter("FieldName", campo);
			query.setParameter("GravaCodigo","S");
			query.execute();
			Integer dado = (Integer) query.getSingleResult();
			return dado;
		}
		
		

	 
	 public EntityManager getEntityManager(){
		 return em;
	 }
	 
//	 public static Connection getConnection() throws SQLException {
//		return dataSource.getConnection();
//	}
//	 public static DataSource getDataSourceQC() {
//		return dataSourceQC;
//	}
}
