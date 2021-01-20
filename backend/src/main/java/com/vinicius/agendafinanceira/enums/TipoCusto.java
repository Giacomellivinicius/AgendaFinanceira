package com.vinicius.agendafinanceira.enums;

public enum TipoCusto {

	CUSTOFIXO(1,"Custo Fixo"),
	CUSTOVARIAVEL(2,"Custo Variável");
	
	private int cod;
	private String descricao;
	
	private TipoCusto(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCusto toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoCusto x : TipoCusto.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código :"+cod+", não encontrado em TipoCusto");
	}
	
	
}

