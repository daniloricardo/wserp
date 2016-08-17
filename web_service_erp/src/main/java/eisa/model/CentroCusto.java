package eisa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Centrodecusto")
public class CentroCusto {

	@Id
	@Column(name="Idcentrodecusto")
	private String id;
	@Column(name="Nmcentrodecusto")
	private String nome;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
