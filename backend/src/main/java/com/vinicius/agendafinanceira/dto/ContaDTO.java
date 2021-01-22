package com.vinicius.agendafinanceira.dto;

import java.io.Serializable;
import java.util.Date;

import com.vinicius.agendafinanceira.domain.Conta;

public class ContaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private Integer empresa;
	
	private Double valor;
	
	private Date dataVencimento;
	
	private Integer tipoCusto;
	
	private Integer estadoPagamento;
	
	public ContaDTO() {}
	
	public ContaDTO(Integer id, Integer empresa, Double valor, Date dataVencimento,
			Integer tipoCusto, Integer estadoPagamento) {
		this.id = id;
		this.empresa = empresa;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.tipoCusto = tipoCusto;
		this.estadoPagamento = estadoPagamento;		
	}
	
	public ContaDTO(Conta entity) {
		id = entity.getId();
		empresa = entity.getEmpresa().getId();
		valor = entity.getValor();
		dataVencimento = entity.getDataVencimento();
		tipoCusto = entity.getTipoCusto().getCod();
		estadoPagamento = entity.getEstadoPagamento().getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getTipoCusto() {
		return tipoCusto;
	}

	public void setTipoCusto(Integer tipoCusto) {
		this.tipoCusto = tipoCusto;
	}

	public Integer getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(Integer estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}
	
	

}
