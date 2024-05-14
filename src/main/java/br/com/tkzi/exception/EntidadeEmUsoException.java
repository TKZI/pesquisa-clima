package br.com.tkzi.exception;

public class EntidadeEmUsoException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
		// TODO Auto-generated constructor stub
	}

	public EntidadeEmUsoException(Long id) {
		super(String.format("A entidade de id %d não pode ser excluida pois está em uso",id));
	}
}
