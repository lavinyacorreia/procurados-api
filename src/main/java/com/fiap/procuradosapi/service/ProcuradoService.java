package com.fiap.procuradosapi.service;

import java.util.List;

import com.fiap.procuradosapi.model.Procurado;

public interface ProcuradoService {
	Procurado createProcurado(Procurado procurado);
	Procurado updateProcurado(Procurado procurado);
	List<Procurado> getAllProcurados();
	Procurado getProcuradoById(long procuradoId);
	void deleteProcurado(long procuradoId);

}
