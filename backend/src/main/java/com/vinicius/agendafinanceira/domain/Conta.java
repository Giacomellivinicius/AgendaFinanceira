package com.vinicius.agendafinanceira.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vinicius.agendafinanceira.enums.EstadoPagamento;
import com.vinicius.agendafinanceira.enums.TipoCusto;

@Entity
@Table(name="tb_conta")
public class Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "conta")
	private Comprovante comprovante;
	
	private Date dataVencimento;
	
	private Integer tipoCusto;
	
	private Integer estadoPagamento;
	
	public Conta() {}

	public Conta(Integer id, Empresa empresa,Comprovante comprovante, Date dataVencimento,
			 TipoCusto tipoCusto, EstadoPagamento estadoPagamento) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.comprovante = comprovante;
		this.dataVencimento = dataVencimento;
		this.tipoCusto = tipoCusto.getCod();
		this.estadoPagamento = estadoPagamento.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public Comprovante getComprovante() {
		return comprovante;
	}

	public void setComprovante(Comprovante comprovante) {
		this.comprovante = comprovante;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public TipoCusto getTipoCusto() {
		return TipoCusto.toEnum(tipoCusto);
	}

	public void setTipoCusto(TipoCusto tipoCusto) {
		this.tipoCusto = tipoCusto.getCod();
	}

	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.toEnum(estadoPagamento);
	}

	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento.getCod();
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
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	};
	
	

}
