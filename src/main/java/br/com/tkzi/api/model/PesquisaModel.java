package br.com.tkzi.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PesquisaModel {
	
	private Long id;
	
	private String titulo;
	
	private List<PerguntaModel> perguntas;

}
