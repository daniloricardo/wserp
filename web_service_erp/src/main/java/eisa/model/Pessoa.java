package eisa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQuery(
		name = "sp_IntToB36", 
		procedureName = "sp_IntToB36", 
		parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "x"), 
			@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "dado")
		}
	)



@Entity
public class Pessoa implements Serializable {

	@Id
	@Column(name="idpessoa")
	private String id;
	@Column(name="nmpessoa")
	private String nome;
	@Column(name="cdchamada")
	private String codigo;
	@Column(name="cdcpf_cgc")
	private String cpfcnpj;
	@Column(name="nmcurto")
	private String nmfantasia;
	@OneToOne
	@JoinColumn(name="idpessoa")
	private Endereco endereco;
	
	
	public String getCpfcnpj() {
		return cpfcnpj;
	}
	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}
	public String getNmfantasia() {
		return nmfantasia;
	}
	public void setNmfantasia(String nmfantasia) {
		this.nmfantasia = nmfantasia;
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
