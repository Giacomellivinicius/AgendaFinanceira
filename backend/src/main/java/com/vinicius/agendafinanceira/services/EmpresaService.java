package com.vinicius.agendafinanceira.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.agendafinanceira.domain.Empresa;
import com.vinicius.agendafinanceira.repositories.EmpresaRepository;
import com.vinicius.agendafinanceira.services.exceptions.ObjectNotFoundException;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repo;
	
	public Empresa find(Integer id) {
		 Optional<Empresa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Empresa.class.getName()));
		}
	
	public Empresa insert (Empresa obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
