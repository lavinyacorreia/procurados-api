package com.fiap.procuradosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.procuradosapi.model.ProcuradoFBI;

public interface ProcuradoRepository extends JpaRepository<ProcuradoFBI, Long> {

}
