package br.com.tkzi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Resposta {

	@EqualsAndHashCode.Include
	private Long id;
	
	private int pontuacao;
	
	private String respostaLivre;
	
	private Pergunta pergunta;
	
	private Funcionario funcionario;
}
