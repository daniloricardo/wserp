package eisa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="vw_pessoaenderecoprincipal",schema="dbo")
@PrimaryKeyJoinColumn(name = " idpessoa ")
@Inheritance(strategy = InheritanceType.JOINED)
public class Endereco{

	@Id
	@Column(name="idpessoa")
	private String id;
	@Column(name="nmlogradouro")
	private String nome;
	@Column(name="tplogradouro")
	private String tipo;
	@Column(name="nrlogradouro")
	private String numero;
	@Column(name="iduf")
	private String uf;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idbairro")
	@NotFound(action = NotFoundAction.IGNORE)
	private Bairro bairro;

	@Column(name="cdcep")
	private String cep;
	@OneToOne
	@JoinColumn(name="idcidade")
	@NotFound(action = NotFoundAction.IGNORE)
	private Cidade cidade;
	
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
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
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
