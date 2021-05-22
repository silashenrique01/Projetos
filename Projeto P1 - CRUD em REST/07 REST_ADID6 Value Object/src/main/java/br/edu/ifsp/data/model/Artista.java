package br.edu.ifsp.data.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="artista")
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long artista_id;
	
	@Column(name = "nome", nullable = true, length = 80)
	public String nome;
	
	@Column(name = "imagem_URL", nullable = true, length = 80)
	public String imagem_URL;
	
	@Column(name = "telefone", nullable = true, length = 80)
	public String telefone;
	
	@Column(name = "email", nullable = true, length = 80)
	public String email;
	
	@OneToMany(mappedBy="rede_social_id", targetEntity=RedeSocial.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<RedeSocial> redes_sociais;
	
	@OneToMany(mappedBy="evento", targetEntity=ArtistaEvento.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<ArtistaEvento> eventos;

	public Artista() {	
	}

	public Long getArtista_id() {
		return artista_id;
	}

	public void setArtista_id(Long artista_id) {
		this.artista_id = artista_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem_URL() {
		return imagem_URL;
	}

	public void setImagem_URL(String imagem_URL) {
		this.imagem_URL = imagem_URL;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RedeSocial> getRedes_sociais() {
		return redes_sociais;
	}

	public void setRedes_sociais(List<RedeSocial> redes_sociais) {
		this.redes_sociais = redes_sociais;
	}

	public List<ArtistaEvento> getEventos() {
		return eventos;
	}

	public void setEventos(List<ArtistaEvento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista_id == null) ? 0 : artista_id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((eventos == null) ? 0 : eventos.hashCode());
		result = prime * result + ((imagem_URL == null) ? 0 : imagem_URL.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((redes_sociais == null) ? 0 : redes_sociais.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Artista other = (Artista) obj;
		if (artista_id == null) {
			if (other.artista_id != null)
				return false;
		} else if (!artista_id.equals(other.artista_id))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (eventos == null) {
			if (other.eventos != null)
				return false;
		} else if (!eventos.equals(other.eventos))
			return false;
		if (imagem_URL == null) {
			if (other.imagem_URL != null)
				return false;
		} else if (!imagem_URL.equals(other.imagem_URL))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (redes_sociais == null) {
			if (other.redes_sociais != null)
				return false;
		} else if (!redes_sociais.equals(other.redes_sociais))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	  		
}
