package eisa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.StoredProcedureParameter;


@NamedStoredProcedureQuery(
		name = "sp_GetNextCode", 
		procedureName = "sp_GetNextCode", 
		parameters = { 
			@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "TableName"),
			@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "FieldName"),
			@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "GravaCodigo")
//			@StoredProcedureParameter(mode = ParameterMode.OUT, type = Integer.class, name = "dado")
			
		}
	)


@Entity
@PrimaryKeyJoinColumn(name = " idbairro ")
@Inheritance(strategy = InheritanceType.JOINED)
public class Bairro {

	@Id
	@Column(name="idbairro")
	private String id;
	@Column(name="cdchamada")
	private String codigo;
	@Column(name="nmbairro")
	private String nome;

	

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

	
}

