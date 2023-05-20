package com.fiap.procuradosapi.service;

import java.util.List;

import com.fiap.procuradosapi.model.ProcuradoFBI;

public interface ProcuradoService {
	ProcuradoFBI createProcurado(ProcuradoFBI procurado);
	ProcuradoFBI updateProcurado(ProcuradoFBI procurado);
	List<ProcuradoFBI> getAllProcurados();
	ProcuradoFBI getProcuradoById(long procuradoId);
	void deleteProcurado(long procuradoId);

}
