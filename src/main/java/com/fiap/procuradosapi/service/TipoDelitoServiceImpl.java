package com.fiap.procuradosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.procuradosapi.exception.ResourceNotFoundException;
import com.fiap.procuradosapi.model.TipoDelito;
import com.fiap.procuradosapi.repository.TipoDelitoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoDelitoServiceImpl implements TipoDelitoService{
	
	@Autowired
	public TipoDelitoRepository tipoDelitoRepository;

	@Override
	public TipoDelito createTipoDelito(TipoDelito tipoDelito) {
		return tipoDelitoRepository.save(tipoDelito);
	}

	@Override
	public TipoDelito updateTipoDelito(TipoDelito tipoDelito) {
		Optional<TipoDelito> tipoDelitoBD = this.tipoDelitoRepository.findById(tipoDelito.getId());
		if(tipoDelitoBD.isPresent()) {
			tipoDelitoRepository.save(tipoDelito);
			return tipoDelito;
		}else {
			throw new ResourceNotFoundException("Record TipoDelito not found with id " +tipoDelito.getId());
		}
	}

	@Override
	public List<TipoDelito> getAllTiposDelito() {
		return this.tipoDelitoRepository.findAll();
	}

	@Override
	public TipoDelito getTipoDelitoById(long tipoDelitoId) {
		Optional<TipoDelito> tipoDelitoBD = this.tipoDelitoRepository.findById(tipoDelitoId);
		if(tipoDelitoBD.isPresent()) {
			return tipoDelitoBD.get();
		}else {
			throw new ResourceNotFoundException("Record TipoDelito not found with id " + tipoDelitoId);
		}	
	}

	@Override
	public void deleteTipoDelito(long tipoDelitoId) {
		Optional<TipoDelito> tipoDelitoBD = this.tipoDelitoRepository.findById(tipoDelitoId);
		if(tipoDelitoBD.isPresent()) {
			this.tipoDelitoRepository.delete(tipoDelitoBD.get());
		}else {
			throw new ResourceNotFoundException("Record not TipoDelito found with id " + tipoDelitoId);
		}
		
	}
}
