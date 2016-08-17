package eisa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PessoaEnderecoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "IdPessoa", referencedColumnName = "IdPessoa")
	private Pessoa pessoa;

	private String CdEndereco;

	public Pessoa getIdPessoa() {
		return pessoa;
	}

	public void setIdPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCdEndereco() {
		return CdEndereco;
	}

	public void setCdEndereco(String cdEndereco) {
		CdEndereco = cdEndereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CdEndereco == null) ? 0 : CdEndereco.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaEnderecoPK other = (PessoaEnderecoPK) obj;
		if (CdEndereco == null) {
			if (other.CdEndereco != null)
				return false;
		} else if (!CdEndereco.equals(other.CdEndereco))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}

}