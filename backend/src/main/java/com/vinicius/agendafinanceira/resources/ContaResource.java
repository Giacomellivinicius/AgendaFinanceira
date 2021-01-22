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

import com.vinicius.agendafinanceira.domain.Conta;
import com.vinicius.agendafinanceira.domain.Empresa;
import com.vinicius.agendafinanceira.dto.ContaDTO;
import com.vinicius.agendafinanceira.enums.EstadoPagamento;
import com.vinicius.agendafinanceira.enums.TipoCusto;
import com.vinicius.agendafinanceira.services.ContaService;
import com.vinicius.agendafinanceira.services.EmpresaService;

@RestController
@RequestMapping(value="/contas")
public class ContaResource {
	
	@Autowired
	private ContaService service;
	
	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ContaDTO> find(@PathVariable Integer id){
		Conta obj = service.find(id);
		ContaDTO objDTO = new ContaDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ContaDTO objDTO){
		Empresa emp = empresaService.find(objDTO.getEmpresa());
		Conta c = new Conta (null, emp, objDTO.getValor(), objDTO.getDataVencimento(),
				TipoCusto.toEnum(objDTO.getTipoCusto()), EstadoPagamento.toEnum(objDTO.getEstadoPagamento()), null);
		c = service.insert(c);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
