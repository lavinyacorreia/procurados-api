package com.fiap.procuradosapi.model;

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
public class TipoDelito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDelito;
	
	@Column(name = "nm_delito")
	private String nameDelito;
}
