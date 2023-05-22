package com.fiap.procuradosapi.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_PROCURADOS_INTERPOL")
public class ProcuradoInterpol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nm_pessoa")
	private String nome;
	
	@Column(name = "nr_documento")
	private String numeroDocumento;
	
	@Column(name = "nacionalidade")
	private String nacionalidadeProcurado;
	 
	@Column(name = "desc_pessoa")
	private String descriptionProcurado;
	
	@Column(name = "dt_nasc")
	private Date dataNascimento;

	@Column(name = "tipo_delito")
	private List<String> listDelito;
	
	

}
