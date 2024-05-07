package br.com.tkzi.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	
	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado","Recurso não encontrado"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	DADOS_INVALIDOS("/dados-invalidos", "Dados Invalidos");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title){
		this.uri = "https://clima.com.br" + path;
		this.title = title;
	}
}
