package com.vinicius.agendafinanceira.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.agendafinanceira.domain.Empresa;
import com.vinicius.agendafinanceira.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repo;
	
	public Empresa find(Integer id) {
		 Optional<Empresa> obj = repo.findById(id);
		return obj.orElse(null);
		}

}