package br.edu.ifsp.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rede_social")
public class RedeSocial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long rede_social_id;
	
	@Column(name = "nome", nullable = true, length = 80)
	public String nome;
	
	@Column(name = "URL", nullable = true, length = 80)
	public String URL;
	
	@ManyToOne
	@JoinColumn(name="evento_id")
	public Evento evento;
	
	@ManyToOne
	@JoinColumn(name="artista_id")
	public Artista artista;
	
	
	public RedeSocial() {
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


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public Artista getArtista() {
		return artista;
	}


	public void setArtista(Artista artista) {
		this.artista = artista;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
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
		RedeSocial other = (RedeSocial) obj;
		if (URL == null) {
			if (other.URL != null)
				return false;
		} else if (!URL.equals(other.URL))
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
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
