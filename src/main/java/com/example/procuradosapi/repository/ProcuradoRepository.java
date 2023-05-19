package com.example.procuradosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.procuradosapi.model.Procurado;

public interface ProcuradoRepository extends JpaRepository<Procurado, Long> {

}
