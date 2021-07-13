package br.edu.ifsp.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //javax.persistence
@Table(name="evento")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	@Column(name="telefone", nullable=true, length=80)
	public String telefone;
	
	@Column(name="email", nullable=true, length=80)
	public String email;
	
	public Evento() {
	
	}

	public Evento(Long evento_id, String local, Date data_evento, String tema,
			      int quantidade_pessoas, String telefone, String email) {
		super();
		this.evento_id = evento_id;
		this.local = local;
		this.data_evento = data_evento;
		this.tema = tema;
		this.quantidade_pessoas = quantidade_pessoas;
		this.telefone = telefone;
		this.email = email;
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


	public void setData_evento(Date date) {
		this.data_evento = date;
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
		Evento other = (Evento) obj;
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