package com.vinicius.agendafinanceira.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vinicius.agendafinanceira.domain.Comprovante;
import com.vinicius.agendafinanceira.repositories.ComprovanteRepository;
import com.vinicius.agendafinanceira.services.exceptions.DataIntegrityException;
import com.vinicius.agendafinanceira.services.exceptions.ObjectNotFoundException;

@Service
public class ComprovanteService {
	
	@Autowired
	private ComprovanteRepository repo;
	
	public Comprovante find(Integer id) {
		 Optional<Comprovante> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Comprovante.class.getName()));
				}
	
	@Transactional
	public Comprovante insert (Comprovante obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir o comprovante"
			);
		}
	}

}
