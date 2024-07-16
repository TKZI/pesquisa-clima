package br.com.tkzi.api.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class FuncionarioIdInput {
	
	@NotNull
	private Long id;

}
