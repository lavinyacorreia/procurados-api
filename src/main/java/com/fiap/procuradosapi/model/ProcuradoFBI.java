package com.fiap.procuradosapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_PROCURADOS_FBI")
public class ProcuradoFBI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nm_pessoa")
	@NotBlank
	@JsonProperty("nome_procurado")
	private String nome;
	
	@Column(name = "nr_documento")
	@NotBlank
	@JsonProperty("numero_documento")
	private String numeroDocumento;
	
	@Column(name = "nacionalidade")
	@NotBlank
	@JsonProperty("nacionalidade")
	private String nacionalidadeProcurado;
	 
	@Column(name = "desc_pessoa")
	@JsonProperty("description_procurado")
	private String descriptionProcurado;
	
	@Column(name = "dt_nasc")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
	@JsonProperty("data_nascimento")
	private Date dataNascimento;
	
	@Column(name = "list_id_delitos")
	@JsonProperty("list_id_delitos")
	private List<Long> list_id_delitos = new ArrayList<>();

	public ProcuradoFBI(@NotBlank String nome,
			@NotBlank String numeroDocumento,
			@NotBlank String nacionalidadeProcurado, 
			String descriptionProcurado, 
			Date dataNascimento,
			List<Long> list_id_delitos) {
		this.nome = nome;
		this.numeroDocumento = numeroDocumento;
		this.nacionalidadeProcurado = nacionalidadeProcurado;
		this.descriptionProcurado = descriptionProcurado;
		this.dataNascimento = dataNascimento;
		this.list_id_delitos = list_id_delitos;
	}
	
}
