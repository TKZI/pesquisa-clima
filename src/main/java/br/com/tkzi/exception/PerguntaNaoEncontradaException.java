package br.com.tkzi.exception;

public class PerguntaNaoEncontradaException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;

	public PerguntaNaoEncontradaException(String mensagem) {
		super(mensagem);
		
	}
	
	public PerguntaNaoEncontradaException(Long perguntaId) {
		super(String.format("Pergunta de id %d não existe!", perguntaId));
	}

}
