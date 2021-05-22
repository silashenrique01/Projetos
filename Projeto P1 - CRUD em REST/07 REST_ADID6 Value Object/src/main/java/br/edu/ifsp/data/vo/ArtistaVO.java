package br.edu.ifsp.data.vo;

import java.io.Serializable;
import java.util.List;

public class ArtistaVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long artista_id;
	private String nome;
	private String imagemURL;
	private String telefone;
	private String email;
	private List<RedeSocialVO> redes_sociaisVO;
	private EventoVO EventoVO;
	
	
	public ArtistaVO() {
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


	public String getImagemURL() {
		return imagemURL;
	}


	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
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


	public List<RedeSocialVO> getRedes_sociaisVO() {
		return redes_sociaisVO;
	}


	public void setRedes_sociaisVO(List<RedeSocialVO> redes_sociaisVO) {
		this.redes_sociaisVO = redes_sociaisVO;
	}


	public EventoVO getEventoVO() {
		return EventoVO;
	}


	public void setEventoVO(EventoVO eventoVO) {
		EventoVO = eventoVO;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EventoVO == null) ? 0 : EventoVO.hashCode());
		result = prime * result + ((artista_id == null) ? 0 : artista_id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((imagemURL == null) ? 0 : imagemURL.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((redes_sociaisVO == null) ? 0 : redes_sociaisVO.hashCode());
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
		ArtistaVO other = (ArtistaVO) obj;
		if (EventoVO == null) {
			if (other.EventoVO != null)
				return false;
		} else if (!EventoVO.equals(other.EventoVO))
			return false;
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
		if (imagemURL == null) {
			if (other.imagemURL != null)
				return false;
		} else if (!imagemURL.equals(other.imagemURL))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (redes_sociaisVO == null) {
			if (other.redes_sociaisVO != null)
				return false;
		} else if (!redes_sociaisVO.equals(other.redes_sociaisVO))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
}
