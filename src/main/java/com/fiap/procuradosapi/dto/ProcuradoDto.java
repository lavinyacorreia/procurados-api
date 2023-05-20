package com.fiap.procuradosapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcuradoDto {
	
	private long id;

	
	private String name;
	 
	
	private String description;
}
