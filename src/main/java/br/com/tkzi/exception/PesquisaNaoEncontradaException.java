package br.com.tkzi.exception;

public class PesquisaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public PesquisaNaoEncontradaException(String mensagem) {
		super(mensagem);
		
	}
	
	public PesquisaNaoEncontradaException(Long pesquisaId) {
		super(String.format("Não existe pesquisa com id %d", pesquisaId));
	}

}
