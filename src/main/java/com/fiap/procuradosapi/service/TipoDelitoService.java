package com.fiap.procuradosapi.service;

import java.util.List;
import com.fiap.procuradosapi.model.TipoDelito;

public interface TipoDelitoService {
	TipoDelito createTipoDelito(TipoDelito tipoDelito);
	TipoDelito updateTipoDelito(TipoDelito tipoDelito);
	List<TipoDelito> getAllTiposDelito();
	TipoDelito getTipoDelitoById(long tipoDelitoId);
	void deleteTipoDelito(long tipoDelitoId);
}
