package com.fiap.procuradosapi.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.procuradosapi.dto.ProcuradoDto;
import com.fiap.procuradosapi.model.ProcuradoFBI;
import com.fiap.procuradosapi.model.TipoDelito;
import com.fiap.procuradosapi.service.ProcuradoFBIService;
import com.fiap.procuradosapi.service.TipoDelitoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/procurados-FBI")
public class ProcuradoFBIController {

	@Autowired
	private ProcuradoFBIService procuradoService;
	
	@Autowired
	private TipoDelitoService tipoDelitoService;
	
	@GetMapping
	public ResponseEntity<List<ProcuradoFBI>> getAllProcurados(){
		return ResponseEntity.ok().body(procuradoService.getAllProcurados());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProcuradoFBI> getProcuradoById(@PathVariable long id){
		return ResponseEntity.ok().body(procuradoService.getProcuradoById(id));
	}
	
	@PostMapping
	public ResponseEntity<Object> createProcurado(@RequestBody @Valid ProcuradoDto procuradoDto){
		List<TipoDelito> delitos = new ArrayList<TipoDelito>();
		for(Long id : procuradoDto.getListDelito()) {
			TipoDelito delito = tipoDelitoService.getTipoDelitoById(id);
			delitos.add(delito);
		}
		ProcuradoFBI procurado = new ProcuradoFBI(
				procuradoDto.getNome(), 
				procuradoDto.getNumeroDocumento(), 
				procuradoDto.getNacionalidadeProcurado(),
				procuradoDto.getDescriptionProcurado(),
				procuradoDto.getDataNascimento(),
				delitos
				);
		return ResponseEntity.ok().body(this.procuradoService.createProcurado(procurado));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProcurado(@PathVariable long id, @RequestBody @Valid ProcuradoDto procuradoDto){
		List<TipoDelito> delitos = new ArrayList<TipoDelito>();
		for(Long idDelito : procuradoDto.getListDelito()) {
			TipoDelito delito = tipoDelitoService.getTipoDelitoById(idDelito);
			delitos.add(delito);
		}
		ProcuradoFBI procurado = new ProcuradoFBI(
				procuradoDto.getNome(), 
				procuradoDto.getNumeroDocumento(), 
				procuradoDto.getNacionalidadeProcurado(),
				procuradoDto.getDescriptionProcurado(),
				procuradoDto.getDataNascimento(),
				delitos
				);
		return ResponseEntity.ok().body(this.procuradoService.updateProcurado(procurado));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProcurado(@PathVariable long id, @RequestBody ProcuradoFBI procurado){
		this.procuradoService.deleteProcurado(id);
		return ResponseEntity.ok().body("Procurado " + procurado.getNome() + " com id: " + id + " apagado!");
	}
}
