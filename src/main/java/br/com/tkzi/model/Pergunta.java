package br.com.tkzi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pergunta {
	
	@EqualsAndHashCode.Include
	private Long id;
	
	private String descricao;
	
	private TipoResposta tipoResposta;
	
	private Pesquisa pesquisa;
	
	

}
