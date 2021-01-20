package com.vinicius.agendafinanceira.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vinicius.agendafinanceira.enums.Prioridade;

public class Empresas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	private Integer prioridade;
	
	private List<Conta> contas = new ArrayList<>();
	
	public Empresas() {}

	public Empresas(Integer id, String nome, Prioridade prioridade) {
		super();
		this.id = id;
		this.nome = nome;
		this.prioridade = prioridade.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Prioridade getPrioridade() {
		return Prioridade.toEnum(prioridade);
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade.getCod();
	};
	
	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Empresas other = (Empresas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
