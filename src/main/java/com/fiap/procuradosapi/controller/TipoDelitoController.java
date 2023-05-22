package com.fiap.procuradosapi.controller;

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
import com.fiap.procuradosapi.model.TipoDelito;
import com.fiap.procuradosapi.service.TipoDelitoService;

@RestController
@RequestMapping("/tipo-delito")
public class TipoDelitoController {
	
	@Autowired
	private TipoDelitoService tipoDelitoService;
	
	@GetMapping
	public ResponseEntity<List<TipoDelito>> getAllTiposDelito(){
		return ResponseEntity.ok().body(tipoDelitoService.getAllTiposDelito());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoDelito> getTipoDelitoById(@PathVariable long id){
		return ResponseEntity.ok().body(tipoDelitoService.getTipoDelitoById(id));
	}
	
	@PostMapping
	public ResponseEntity<Object> createTipoDelito(@RequestBody TipoDelito tipoDelito){
		return ResponseEntity.ok().body(this.tipoDelitoService.createTipoDelito(tipoDelito));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTipoDelito(@PathVariable long id, @RequestBody TipoDelito tipoDelito){
		tipoDelito.setId(id);
		return ResponseEntity.ok().body(this.tipoDelitoService.updateTipoDelito(tipoDelito));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTipoDelito(@PathVariable long id, @RequestBody TipoDelito tipoDelito){
		this.tipoDelitoService.deleteTipoDelito(id);
		return ResponseEntity.ok().body("Delito " + tipoDelito.getNomeDelito() + " com id: " + id + " apagado!");
	}
}
