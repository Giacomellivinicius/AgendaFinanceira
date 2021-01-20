package com.vinicius.agendafinanceira.enums;

public enum EstadoPagamento {

	PAGO(1,"Pago"),
	PENDENTE(2,"Pendente"),
	VENCIDA(3,"Vencido");
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Código :"+cod+", não encontrado em EstadoPagamento");
	}
	
}
