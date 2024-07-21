package br.com.tkzi.api.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"perguntaDescricao", "pontuacao", "respostaLivre"})
public class RespostaModel {
	
	private String PerguntaDescricao;
	
	private int pontuacao;
	
	private String respostaLivre;

}
