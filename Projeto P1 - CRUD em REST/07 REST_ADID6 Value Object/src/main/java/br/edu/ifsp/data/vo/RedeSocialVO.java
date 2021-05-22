package br.edu.ifsp.data.vo;

import java.io.Serializable;

public class RedeSocialVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long rede_social_id;
	private String nome;
	private String URL;
	
	public RedeSocialVO() {
	}

	public Long getRede_social_id() {
		return rede_social_id;
	}

	public void setRede_social_id(Long rede_social_id) {
		this.rede_social_id = rede_social_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rede_social_id == null) ? 0 : rede_social_id.hashCode());
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
		RedeSocialVO other = (RedeSocialVO) obj;
		if (URL == null) {
			if (other.URL != null)
				return false;
		} else if (!URL.equals(other.URL))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rede_social_id == null) {
			if (other.rede_social_id != null)
				return false;
		} else if (!rede_social_id.equals(other.rede_social_id))
			return false;
		return true;
	}

	
}
