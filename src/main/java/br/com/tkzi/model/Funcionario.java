package br.com.tkzi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotNull
	private String nome;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private String cargo;
	
	@Column(name = "status_participacao")
	private Boolean statusParticipacao = Boolean.FALSE;
	

}
