package com.fiap.procuradosapi.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.fiap.procuradosapi.exception.ResourceNotFoundException;
import com.fiap.procuradosapi.model.ProcuradoInterpol;
import com.fiap.procuradosapi.model.TipoDelito;
import com.fiap.procuradosapi.service.ProcuradoInterpolService;
import com.fiap.procuradosapi.service.TipoDelitoService;

@RestController
@RequestMapping("/procurados-interpol")
public class ProcuradoInterpolController {

	@Autowired
	private ProcuradoInterpolService procuradoService;
	
	@Autowired
	private TipoDelitoService tipoDelitoService;
	
	@GetMapping
	public ResponseEntity<List<ProcuradoInterpol>> getAllProcurados(){
		return ResponseEntity.ok().body(procuradoService.getAllProcurados());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProcuradoInterpol> getProcuradoById(@PathVariable long id){
		return ResponseEntity.ok().body(procuradoService.getProcuradoById(id));
	}
	
	@PostMapping
	public ResponseEntity<Object> createProcurado(@RequestBody ProcuradoDto procuradoDto){
		List<TipoDelito> delitos = new ArrayList<TipoDelito>();
		for(Long id : procuradoDto.getListDelito()) {
			try {
				TipoDelito delito = tipoDelitoService.getTipoDelitoById(id);
				delitos.add(delito);
			}catch(ResourceNotFoundException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo delito com id "+id+ " não encontrado");
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exceção inesperada! " + e.getMessage());
			}
		}
		
		ProcuradoInterpol procurado = new ProcuradoInterpol(
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
	public ResponseEntity<Object> updateProcurado(@PathVariable long id, @RequestBody ProcuradoDto procuradoDto){
		List<TipoDelito> delitos = new ArrayList<TipoDelito>();
		for(Long idDelito : procuradoDto.getListDelito()) {
			try {
				TipoDelito delito = tipoDelitoService.getTipoDelitoById(idDelito);
				delitos.add(delito);
			}catch(ResourceNotFoundException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo delito com id "+id+ " não encontrado");
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exceção inesperada! " + e.getMessage());
			}
		}
		
		ProcuradoInterpol procurado = new ProcuradoInterpol(
				procuradoDto.getNome(), 
				procuradoDto.getNumeroDocumento(), 
				procuradoDto.getNacionalidadeProcurado(),
				procuradoDto.getDescriptionProcurado(),
				procuradoDto.getDataNascimento(),
				delitos
				);
		procurado.setId(id);
		return ResponseEntity.ok().body(this.procuradoService.updateProcurado(procurado));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProcurado(@PathVariable long id, @RequestBody ProcuradoDto procuradoDto){
		this.procuradoService.deleteProcurado(id);
		return ResponseEntity.ok().body("Procurado " + procuradoDto.getNome() + " com id: " + id + " apagado!");
	}
}
