package br.com.tkzi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tkzi.exception.RespostaNaoEncontradaException;
import br.com.tkzi.model.Funcionario;
import br.com.tkzi.model.Pergunta;
import br.com.tkzi.model.Resposta;
import br.com.tkzi.repository.RespostaRepository;
import jakarta.transaction.Transactional;

@Service
public class RespostaService {

	@Autowired
	private RespostaRepository respostaRepository;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private PerguntaService perguntaService;

	public Resposta buscarOuFalhar(Long perguntaId, Long funcionarioId) {
		return respostaRepository.findByPerguntaIdAndFuncionarioId(perguntaId, funcionarioId);
	}

	@Transactional
	public Resposta salvar(Long perguntaId, Long funcionarioId, Resposta resposta) {
		Funcionario funcionario = funcionarioService.buscarOuFalhar(funcionarioId);
		Pergunta pergunta = perguntaService.buscarOuFalhar(perguntaId);
		resposta.setFuncionario(funcionario);
		resposta.setPergunta(pergunta);

		Resposta respostaSalva = respostaRepository.save(resposta);
		return respostaSalva;
	}

	public List<Resposta> findRespostasFuncionario(Long funcionarioId) {
		Funcionario funcionario = funcionarioService.buscarOuFalhar(funcionarioId);
		List<Resposta> respostasFuncionario = respostaRepository.todasRespostasFuncionario(funcionario.getId());

		if (respostasFuncionario.isEmpty()) {
			throw new RespostaNaoEncontradaException(String.format("não encotrado nenhuma resposta do funcionario de id %d",funcionarioId));	
				}
		return respostasFuncionario;
	}

}
