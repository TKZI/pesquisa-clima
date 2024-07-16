package br.com.tkzi.api.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaInput {
	
	
	private int pontuacao;
	
	private String respostaLivre;
	
	@NotNull
	private PerguntaIdInput perguntaIdInput;
	
	@NotNull
	private FuncionarioIdInput funcionarioIdInput;

}
