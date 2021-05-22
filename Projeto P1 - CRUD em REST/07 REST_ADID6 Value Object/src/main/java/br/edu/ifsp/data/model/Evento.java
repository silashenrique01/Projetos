package br.edu.ifsp.data.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long evento_id;
	
	@Column(name = "local", nullable = true, length = 80)
	public String local;
	
	@Column(name = "data_evento", nullable = true, length = 80)
	public Date data_evento;
	
	@Column(name = "tema", nullable = true, length = 80)
	public String tema;
	
	@Column(name = "quantidade_pessoas", nullable = true, length = 999)
	public int quantidade_pessoas;
	
	@OneToMany(mappedBy="lote_id", targetEntity=Lote.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<Lote> lotes;
	
	@Column(name = "imagem_URL", nullable = true, length = 80)
	public String imagem_URL;
	
	@Column(name="telefone", nullable=true, length=80)
	public String telefone;
	
	@Column(name="email", nullable=true, length=80)
	public String email;

	@OneToMany(mappedBy="rede_social_id", targetEntity=RedeSocial.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<RedeSocial> redes_sociais;
	
	@ManyToMany(mappedBy="artista", targetEntity=ArtistaEvento.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public List<ArtistaEvento> artistas;

	public Evento() {
	
	}

	public Long getEvento_id() {
		return evento_id;
	}

	public void setEvento_id(Long evento_id) {
		this.evento_id = evento_id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getData_evento() {
		return data_evento;
	}

	public void setData_evento(Date data_evento) {
		this.data_evento = data_evento;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getQuantidade_pessoas() {
		return quantidade_pessoas;
	}

	public void setQuantidade_pessoas(int quantidade_pessoas) {
		this.quantidade_pessoas = quantidade_pessoas;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
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

	public List<ArtistaEvento> getArtista() {
		return artistas;
	}

	public void setArtista_eventos(List<ArtistaEvento> artistas) {
		this.artistas = artistas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistas == null) ? 0 : artistas.hashCode());
		result = prime * result + ((data_evento == null) ? 0 : data_evento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((evento_id == null) ? 0 : evento_id.hashCode());
		result = prime * result + ((imagem_URL == null) ? 0 : imagem_URL.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((lotes == null) ? 0 : lotes.hashCode());
		result = prime * result + quantidade_pessoas;
		result = prime * result + ((redes_sociais == null) ? 0 : redes_sociais.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
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
		Evento other = (Evento) obj;
		if (artistas == null) {
			if (other.artistas != null)
				return false;
		} else if (!artistas.equals(other.artistas))
			return false;
		if (data_evento == null) {
			if (other.data_evento != null)
				return false;
		} else if (!data_evento.equals(other.data_evento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (evento_id == null) {
			if (other.evento_id != null)
				return false;
		} else if (!evento_id.equals(other.evento_id))
			return false;
		if (imagem_URL == null) {
			if (other.imagem_URL != null)
				return false;
		} else if (!imagem_URL.equals(other.imagem_URL))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (lotes == null) {
			if (other.lotes != null)
				return false;
		} else if (!lotes.equals(other.lotes))
			return false;
		if (quantidade_pessoas != other.quantidade_pessoas)
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
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		return true;
	}
	
	
}
