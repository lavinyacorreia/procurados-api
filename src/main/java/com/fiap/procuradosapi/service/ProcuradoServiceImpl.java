package com.fiap.procuradosapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fiap.procuradosapi.exception.ResourceNotFoundException;
import com.fiap.procuradosapi.model.Procurado;
import com.fiap.procuradosapi.repository.ProcuradoRepository;

public class ProcuradoServiceImpl implements ProcuradoService{

	@Autowired
	public ProcuradoRepository procuradoRepository;
	
	@Override
	public Procurado createProcurado(Procurado procurado) {
		return procuradoRepository.save(procurado);
	}

	@Override
	public Procurado updateProcurado(Procurado procurado) {
		Optional<Procurado> procuradoBD = this.procuradoRepository.findById(procurado.getId());
		if(procuradoBD.isPresent()) {
			procuradoRepository.save(procurado);
			return procurado;
		}else {
			throw new ResourceNotFoundException("Record not found with id " +procurado.getId());
		}
	}

	@Override
	public List<Procurado> getAllProcurados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Procurado getProcuradoById(long procuradoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProcurado(long procuradoId) {
		// TODO Auto-generated method stub
		
	}

}
