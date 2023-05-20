package com.fiap.procuradosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.procuradosapi.model.Procurado;

public interface ProcuradoRepository extends JpaRepository<Procurado, Long> {

}
