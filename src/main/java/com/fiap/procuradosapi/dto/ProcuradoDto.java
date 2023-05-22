package com.fiap.procuradosapi.dto;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	@JsonProperty("data_nascimento")
	private Date dataNascimento;
	
	@JsonProperty("list_id_delitos")
	private List<Long> listDelito;
}
