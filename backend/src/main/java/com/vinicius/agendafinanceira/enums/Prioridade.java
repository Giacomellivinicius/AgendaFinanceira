package com.vinicius.agendafinanceira.enums;

public enum Prioridade {
	
	ESSENCIAL(1,"Serviço Essencial"),
	DESEJAVEL(2,"Serviço desejável"),
	DISPENSAVEL(3,"Serviço Dispensável");
	
	private int cod;
	private String descricao;
	
	private Prioridade(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static Prioridade toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Prioridade x : Prioridade.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código :"+cod+", não encontrado em Prioridade");
	}
}
