package com.fiap.procuradosapi.dto;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.procuradosapi.model.TipoDelito;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcuradoDto {
	
	@NotBlank
	@JsonProperty("id_procurado")
	private long id; 

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
	@JsonProperty("data_nascimento")
	private Date dataNascimento;
	
	@NotBlank
	@JsonProperty("list_tipo_delito")
	private List<TipoDelito> listDelito;
}
