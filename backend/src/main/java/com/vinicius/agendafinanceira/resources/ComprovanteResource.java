package com.vinicius.agendafinanceira.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.agendafinanceira.domain.Comprovante;
import com.vinicius.agendafinanceira.services.ComprovanteService;

@RestController
@RequestMapping(value="/comprovante")
public class ComprovanteResource {
	
	@Autowired
	private ComprovanteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Comprovante obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
