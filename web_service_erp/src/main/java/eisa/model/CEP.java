package eisa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;



@Entity
public class CEP {
	@Id
	private String CdCEP;
	private String nmlogradouro;
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToOne
	@JoinColumn(name="Idbairro")
	private Bairro bairro;
	@NotFound(action=NotFoundAction.IGNORE)
	@OneToOne
	@JoinColumn(name="Idcidade")
	private Cidade cidade;
	private String IdUF;
	private String tplogradouro;
	public String getCdCEP() {
		return CdCEP;
	}
	public void setCdCEP(String cdCEP) {
		CdCEP = cdCEP;
	}
	
	
	public String getIdUF() {
		return IdUF;
	}
	public void setIdUF(String idUF) {
		IdUF = idUF;
	}
	
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getNmlogradouro() {
		return nmlogradouro;
	}
	public void setNmlogradouro(String nmlogradouro) {
		this.nmlogradouro = nmlogradouro;
	}
	public String getTplogradouro() {
		return tplogradouro;
	}
	public void setTplogradouro(String tplogradouro) {
		this.tplogradouro = tplogradouro;
	}
	
	
	
	

}
