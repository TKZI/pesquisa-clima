package br.com.tkzi.exception;

public class RespostaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public RespostaNaoEncontradaException(String mensagem) {
		super(mensagem);
		
	}
	
	public RespostaNaoEncontradaException(Long respostaId) {
		super(String.format("Não existe resposta de id ", respostaId));
	}

}
