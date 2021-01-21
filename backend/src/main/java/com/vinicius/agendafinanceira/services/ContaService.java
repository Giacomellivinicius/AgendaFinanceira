package com.vinicius.agendafinanceira.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.agendafinanceira.domain.Conta;
import com.vinicius.agendafinanceira.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;
	
	public Conta find(Integer id) {
		 Optional<Conta> obj = repo.findById(id);
		return obj.orElse(null);
		}

}
