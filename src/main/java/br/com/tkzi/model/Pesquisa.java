package br.com.tkzi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pesquisa {
	
	@EqualsAndHashCode.Include
	private Long id;
	
	private String titulo;
	
	private LocalDate dataInicio;
	
	private LocalDate dataFim;
	
	private List<Pergunta> perguntas = new ArrayList<>();

}
