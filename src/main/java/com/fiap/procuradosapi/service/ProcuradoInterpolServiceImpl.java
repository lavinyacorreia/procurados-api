package com.fiap.procuradosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fiap.procuradosapi.exception.ResourceNotFoundException;
import com.fiap.procuradosapi.model.ProcuradoInterpol;
import com.fiap.procuradosapi.repository.ProcuradoInterpolRepository;

@Service
@Transactional
public class ProcuradoInterpolServiceImpl implements ProcuradoInterpolService{

	@Autowired
	public ProcuradoInterpolRepository procuradoRepository;
	
	@Override
	public ProcuradoInterpol createProcurado(ProcuradoInterpol procurado) {
		return procuradoRepository.save(procurado);
	}

	@Override
	public ProcuradoInterpol updateProcurado(ProcuradoInterpol procurado) {
		Optional<ProcuradoInterpol> procuradoBD = this.procuradoRepository.findById(procurado.getId());
		if(procuradoBD.isPresent()) {
			procuradoRepository.save(procurado);
			return procurado;
		}else {
			throw new ResourceNotFoundException("Record not found with id " +procurado.getId());
		}
	}

	@Override
	public List<ProcuradoInterpol> getAllProcurados() {
		return this.procuradoRepository.findAll();
	}

	@Override
	public ProcuradoInterpol getProcuradoById(long procuradoId) {
		Optional<ProcuradoInterpol> procuradoBD = this.procuradoRepository.findById(procuradoId);
		if(procuradoBD.isPresent()) {
			return procuradoBD.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id " + procuradoId);
		}	
	}

	@Override
	public void deleteProcurado(long procuradoId) {
		Optional<ProcuradoInterpol> procuradoBD = this.procuradoRepository.findById(procuradoId);
		if(procuradoBD.isPresent()) {
			this.procuradoRepository.delete(procuradoBD.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id " + procuradoId);
		}
		
	}

}
