package br.edu.ifsp.data.vo.v1;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@SuppressWarnings("rawtypes")
@JsonPropertyOrder({"evento_id", "local", "data_evento", "tema", "quantidade_pessoas", "telefone", "email"})
public class EventoVO extends RepresentationModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Mapping("evento_id")
	private Long evento_id;
	private String local;
	private Date data_evento;
	private String tema;
	private int quantidade_pessoas;
	private String telefone;
	private String email;
	
	public EventoVO() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_evento == null) ? 0 : data_evento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((evento_id == null) ? 0 : evento_id.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + quantidade_pessoas;
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
		EventoVO other = (EventoVO) obj;
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
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (quantidade_pessoas != other.quantidade_pessoas)
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