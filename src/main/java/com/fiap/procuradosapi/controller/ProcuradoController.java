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
import com.fiap.procuradosapi.model.Procurado;
import com.fiap.procuradosapi.service.ProcuradoService;

import jakarta.validation.Valid;

@RestController
public class ProcuradoController {

	@Autowired
	private ProcuradoService procuradoService;
	
	@GetMapping("/procurados")
	public ResponseEntity<List<Procurado>> getAllProcurados(){
		return ResponseEntity.ok().body(procuradoService.getAllProcurados());
	}
	
	@GetMapping("/procurados/{id}")
	public ResponseEntity<Procurado> getProcuradoById(@PathVariable long id){
		return ResponseEntity.ok().body(procuradoService.getProcuradoById(id));
	}
	
	@PostMapping("/procurados")
	public ResponseEntity<Object> createProcurado(@RequestBody @Valid ProcuradoDto procuradoDto){
		var procurado = new Procurado();
        BeanUtils.copyProperties(procuradoDto, procurado);
		return ResponseEntity.ok().body(this.procuradoService.createProcurado(procurado));
	}
	
	@PutMapping("/procurados/{id}")
	public ResponseEntity<Object> updateProcurado(@PathVariable long id, @RequestBody @Valid ProcuradoDto procuradoDto){
		var procurado = new Procurado();
        BeanUtils.copyProperties(procuradoDto, procurado);
		return ResponseEntity.ok().body(this.procuradoService.updateProcurado(procurado));
	}
	
	@DeleteMapping("/procurados/{id}")
	public ResponseEntity<Object> deleteProcurado(@PathVariable long id, @RequestBody ProcuradoDto procuradoDto){
		this.procuradoService.deleteProcurado(id);
		return ResponseEntity.ok().body("Procurado " + procuradoDto.getName() + " com id: " + id + " apagado!");
	}
}
