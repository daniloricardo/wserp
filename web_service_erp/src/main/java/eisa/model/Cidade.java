package eisa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="idcidade")
	private @Id String id;
	@Column(name="cdchamada")
	private String codigo;
	@Column(name="nmcidade")
	private String nome;
	private String iduf;
	private String cdibge;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIduf() {
		return iduf;
	}
	public void setIduf(String iduf) {
		this.iduf = iduf;
	}
	public String getCdibge() {
		return cdibge;
	}
	public void setCdibge(String cdibge) {
		this.cdibge = cdibge;
	}
	
	

}