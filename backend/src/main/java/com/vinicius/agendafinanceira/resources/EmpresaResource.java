package com.vinicius.agendafinanceira.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.agendafinanceira.domain.Empresa;
import com.vinicius.agendafinanceira.services.EmpresaService;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResource {
	
	@Autowired
	private EmpresaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Empresa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
