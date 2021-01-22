package com.vinicius.agendafinanceira.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vinicius.agendafinanceira.domain.Conta;
import com.vinicius.agendafinanceira.repositories.ContaRepository;
import com.vinicius.agendafinanceira.services.exceptions.DataIntegrityException;
import com.vinicius.agendafinanceira.services.exceptions.ObjectNotFoundException;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;
	
	public Conta find(Integer id) {
		 Optional<Conta> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Conta.class.getName()));
				}

	@Transactional
	public Conta insert (Conta obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Conta update(Conta obj){
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma Conta que possua comprovantes cadastradas"
			);
		}
	}

}
