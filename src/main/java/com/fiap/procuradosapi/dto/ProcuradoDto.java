package com.fiap.procuradosapi.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcuradoDto {

	@NotBlank
	@JsonProperty("nome_procurado")
	private String nome;
	
	@NotBlank
	@JsonProperty("numero_documento")
	private String numeroDocumento;
	
	@NotBlank
	@JsonProperty("nacionalidade")
	private String nacionalidadeProcurado;

	@JsonProperty("description_procurado")
	private String descriptionProcurado;
	
	@NotBlank
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@JsonProperty("data_nascimento")
	private Date dataNascimento;
	
	@NotBlank
	@JsonProperty("list_tipo_delito")
	private List<String> listDelito;
}
