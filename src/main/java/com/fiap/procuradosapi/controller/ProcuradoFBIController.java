package com.fiap.procuradosapi.controller;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.procuradosapi.dto.ProcuradoDto;
import com.fiap.procuradosapi.model.ProcuradoFBI;
import com.fiap.procuradosapi.service.ProcuradoService;

import jakarta.validation.Valid;

@RestController
public class ProcuradoFBIController {

	@Autowired
	private ProcuradoService procuradoService;
	
	@GetMapping("/procuradosFBI")
	public ResponseEntity<List<ProcuradoFBI>> getAllProcurados(){
		return ResponseEntity.ok().body(procuradoService.getAllProcurados());
	}
	
	@GetMapping("/procuradosFBI/{id}")
	public ResponseEntity<ProcuradoFBI> getProcuradoById(@PathVariable long id){
		return ResponseEntity.ok().body(procuradoService.getProcuradoById(id));
	}
	
	@PostMapping("/procuradosFBI")
	public ResponseEntity<Object> createProcurado(@RequestBody @Valid ProcuradoDto procuradoDto){
		var procurado = new ProcuradoFBI();
        BeanUtils.copyProperties(procuradoDto, procurado);
		return ResponseEntity.ok().body(this.procuradoService.createProcurado(procurado));
	}
	
	@PutMapping("/procuradosFBI/{id}")
	public ResponseEntity<Object> updateProcurado(@PathVariable long id, @RequestBody @Valid ProcuradoDto procuradoDto){
		var procurado = new ProcuradoFBI();
        BeanUtils.copyProperties(procuradoDto, procurado);
		return ResponseEntity.ok().body(this.procuradoService.updateProcurado(procurado));
	}
	
	@DeleteMapping("/procuradosFBI/{id}")
	public ResponseEntity<Object> deleteProcurado(@PathVariable long id, @RequestBody ProcuradoDto procuradoDto){
		this.procuradoService.deleteProcurado(id);
		return ResponseEntity.ok().body("Procurado " + procuradoDto.getName() + " com id: " + id + " apagado!");
	}
}
