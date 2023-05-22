package com.fiap.procuradosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fiap.procuradosapi.model.TipoDelito;

public interface TipoDelitoRepository extends JpaRepository<TipoDelito, Long> {

}
