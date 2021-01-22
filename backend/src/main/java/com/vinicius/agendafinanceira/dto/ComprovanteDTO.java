package com.vinicius.agendafinanceira.dto;

import java.util.Date;

import com.vinicius.agendafinanceira.domain.Comprovante;

public class ComprovanteDTO {
	
	private Integer id;
	
	private Integer conta;
	
	private Date dataPagamento;
	
	public ComprovanteDTO(){}
	
	public ComprovanteDTO(Integer id, Integer conta, Date dataPagamento) {
		this.id = id;
		this.conta = conta;
		this.dataPagamento = dataPagamento;
	}
	
	public ComprovanteDTO(Comprovante comp) {
		id = comp.getId();
		conta = comp.getConta().getId();
		dataPagamento = comp.getDataPagamento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
