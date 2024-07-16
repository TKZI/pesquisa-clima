package br.com.tkzi.api.input;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class PesquisaInput {
	
	@NotBlank
	private String titulo;
	
	@NotNull
	private List<PerguntaIdInput> perguntaIdInput;

}
