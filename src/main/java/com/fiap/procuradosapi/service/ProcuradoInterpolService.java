package com.fiap.procuradosapi.service;

import java.util.List;
import com.fiap.procuradosapi.model.ProcuradoInterpol;

public interface ProcuradoInterpolService {
	ProcuradoInterpol createProcurado(ProcuradoInterpol procurado);
	ProcuradoInterpol updateProcurado(ProcuradoInterpol procurado);
	List<ProcuradoInterpol> getAllProcurados();
	ProcuradoInterpol getProcuradoById(long procuradoId);
	void deleteProcurado(long procuradoId);

}
