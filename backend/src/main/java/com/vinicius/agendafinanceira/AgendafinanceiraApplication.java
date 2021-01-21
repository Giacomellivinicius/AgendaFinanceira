package com.vinicius.agendafinanceira;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vinicius.agendafinanceira.domain.Comprovante;
import com.vinicius.agendafinanceira.domain.Conta;
import com.vinicius.agendafinanceira.domain.Empresa;
import com.vinicius.agendafinanceira.enums.EstadoPagamento;
import com.vinicius.agendafinanceira.enums.Prioridade;
import com.vinicius.agendafinanceira.enums.TipoCusto;
import com.vinicius.agendafinanceira.repositories.ComprovanteRepository;
import com.vinicius.agendafinanceira.repositories.ContaRepository;
import com.vinicius.agendafinanceira.repositories.EmpresaRepository;

@SpringBootApplication
public class AgendafinanceiraApplication  implements CommandLineRunner{
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ComprovanteRepository comprovanteRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 


	public static void main(String[] args) {
		SpringApplication.run(AgendafinanceiraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Empresa emp1 = new Empresa(null, "Teste", Prioridade.DESEJAVEL);
		Empresa emp2 = new Empresa(null, "Teste2", Prioridade.DISPENSAVEL);
		
		Conta c1 = new Conta(null, null, null, 10.00, 
				sdf.parse("15/01/1991 11:00"), TipoCusto.CUSTOFIXO,EstadoPagamento.PAGO);
		Conta c2 = new Conta(null, null, null, 22.00, 
				sdf.parse("15/01/1992 22:00"), TipoCusto.CUSTOVARIAVEL,EstadoPagamento.PENDENTE);
		Conta c3 = new Conta(null, null, null, 33.00, 
				sdf.parse("15/01/1992 22:00"), TipoCusto.CUSTOVARIAVEL,EstadoPagamento.PAGO);
		
		Comprovante comp1 = new Comprovante(null, null, sdf.parse("15/02/1922 11:01"));
		Comprovante comp2 = new Comprovante(null, null, sdf.parse("15/02/1922 12:01"));
		
		c1.setComprovante(comp1);
		comp1.setConta(c1);
		
		c3.setComprovante(comp2);
		comp2.setConta(c3);
		
		emp1.getContas().addAll(Arrays.asList(c1));
		emp2.getContas().addAll(Arrays.asList(c2,c3));
		
		c1.setEmpresa(emp1);
		c2.setEmpresa(emp2);
		c3.setEmpresa(emp2);
		
		empresaRepository.saveAll(Arrays.asList(emp1,emp2));
		contaRepository.saveAll(Arrays.asList(c1,c2));
		comprovanteRepository.saveAll(Arrays.asList(comp1,comp2));
		
	}

}
