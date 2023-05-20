package com.fiap.procuradosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiap.procuradosapi.exception.ResourceNotFoundException;
import com.fiap.procuradosapi.model.ProcuradoFBI;
import com.fiap.procuradosapi.repository.ProcuradoRepository;


@Service
@Transactional
public class ProcuradoServiceImpl implements ProcuradoService{

	@Autowired
	public ProcuradoRepository procuradoRepository;
	
	@Override
	public ProcuradoFBI createProcurado(ProcuradoFBI procurado) {
		return procuradoRepository.save(procurado);
	}

	@Override
	public ProcuradoFBI updateProcurado(ProcuradoFBI procurado) {
		Optional<ProcuradoFBI> procuradoBD = this.procuradoRepository.findById(procurado.getId());
		if(procuradoBD.isPresent()) {
			procuradoRepository.save(procurado);
			return procurado;
		}else {
			throw new ResourceNotFoundException("Record not found with id " +procurado.getId());
		}
	}

	@Override
	public List<ProcuradoFBI> getAllProcurados() {
		return this.procuradoRepository.findAll();
	}

	@Override
	public ProcuradoFBI getProcuradoById(long procuradoId) {
		Optional<ProcuradoFBI> procuradoBD = this.procuradoRepository.findById(procuradoId);
		if(procuradoBD.isPresent()) {
			return procuradoBD.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id " + procuradoId);
		}	
	}

	@Override
	public void deleteProcurado(long procuradoId) {
		Optional<ProcuradoFBI> procuradoBD = this.procuradoRepository.findById(procuradoId);
		if(procuradoBD.isPresent()) {
			this.procuradoRepository.delete(procuradoBD.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id " + procuradoId);
		}
		
	}

}
