package br.com.tkzi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pesquisa {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String titulo;
	
	
	private LocalDate dataInicio;
	
	private LocalDate dataFim;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pesquisa")
	private List<Pergunta> perguntas = new ArrayList<>();
	
	@PrePersist
	protected void onCreate() {
		setDataInicio(LocalDate.now());
		
		setDataFim(dataInicio.plusDays(30));
	}

}
