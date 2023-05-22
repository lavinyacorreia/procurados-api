package com.fiap.procuradosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
		title = "PROCURADOS FBI E INTERPOL",
		version = "1.0.0",
		description = "Projeto da faculdade FIAP"
				))
public class ProcuradosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcuradosApiApplication.class, args);
	}

}
