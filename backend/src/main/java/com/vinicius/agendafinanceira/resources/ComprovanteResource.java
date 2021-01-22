package com.vinicius.agendafinanceira.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vinicius.agendafinanceira.domain.Comprovante;
import com.vinicius.agendafinanceira.domain.Conta;
import com.vinicius.agendafinanceira.dto.ComprovanteDTO;
import com.vinicius.agendafinanceira.enums.EstadoPagamento;
import com.vinicius.agendafinanceira.services.ComprovanteService;
import com.vinicius.agendafinanceira.services.ContaService;

@RestController
@RequestMapping(value="/comprovantes")
public class ComprovanteResource {
	
	@Autowired
	private ComprovanteService service;
	
	@Autowired
	private ContaService contaService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Comprovante> find(@PathVariable Integer id){
		Comprovante obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ComprovanteDTO objDTO){
		Conta conta = contaService.find(objDTO.getConta());
		Comprovante comp = new Comprovante (null, conta, objDTO.getDataPagamento());
		comp = service.insert(comp);
		conta.setEstadoPagamento(EstadoPagamento.PAGO);
		conta = contaService.update(conta);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(comp.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
