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
public class AgendafinanceiraApplication implements CommandLineRunner{
	
	
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
		
		Conta c1 = new Conta(null, null, 10.00, sdf.parse("15/01/1991 11:00"),
				TipoCusto.CUSTOFIXO,EstadoPagamento.PAGO, null);
		
		Comprovante comp1 = new Comprovante(null, null, sdf.parse("15/01/1991 11:01"));
		
		c1.setComprovante(comp1);
		comp1.setConta(c1);
				
		emp1.getContas().addAll(Arrays.asList(c1));
				
		c1.setEmpresa(emp1);
		
		empresaRepository.saveAll(Arrays.asList(emp1));
		contaRepository.saveAll(Arrays.asList(c1));
		comprovanteRepository.saveAll(Arrays.asList(comp1));
		
	}
	

}
