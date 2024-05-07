package br.com.tkzi.exception;

public class FuncionarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontradoException(String mensagem) {
		super(mensagem);
		
	}
	
	public FuncionarioNaoEncontradoException(Long funcionarioId) {
		super(String.format("Não possui funcionario com id %d", funcionarioId));
	}

}
