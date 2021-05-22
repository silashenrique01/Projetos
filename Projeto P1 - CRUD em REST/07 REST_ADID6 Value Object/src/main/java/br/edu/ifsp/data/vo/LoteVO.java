package br.edu.ifsp.data.vo;

import java.io.Serializable;
import java.util.Date;

public class LoteVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long lote_id;
	private String nome;
	private Date data_inicio;
	private Date data_fim;
	private int quantidade;
	private double preco;
	

	public LoteVO() {
	}


	public Long getLote_id() {
		return lote_id;
	}


	public void setLote_id(Long lote_id) {
		this.lote_id = lote_id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getData_inicio() {
		return data_inicio;
	}


	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}


	public Date getData_fim() {
		return data_fim;
	}


	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_fim == null) ? 0 : data_fim.hashCode());
		result = prime * result + ((data_inicio == null) ? 0 : data_inicio.hashCode());
		result = prime * result + ((lote_id == null) ? 0 : lote_id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantidade;
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
		LoteVO other = (LoteVO) obj;
		if (data_fim == null) {
			if (other.data_fim != null)
				return false;
		} else if (!data_fim.equals(other.data_fim))
			return false;
		if (data_inicio == null) {
			if (other.data_inicio != null)
				return false;
		} else if (!data_inicio.equals(other.data_inicio))
			return false;
		if (lote_id == null) {
			if (other.lote_id != null)
				return false;
		} else if (!lote_id.equals(other.lote_id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

}
