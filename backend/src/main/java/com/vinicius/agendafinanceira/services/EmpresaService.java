package com.vinicius.agendafinanceira.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.vinicius.agendafinanceira.domain.Empresa;
import com.vinicius.agendafinanceira.repositories.EmpresaRepository;
import com.vinicius.agendafinanceira.services.exceptions.DataIntegrityException;
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
	
	public Empresa update(Empresa obj){
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma empresa que possua contas cadastradas");
		}
	}

}
