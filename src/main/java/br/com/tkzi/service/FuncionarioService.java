package br.com.tkzi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tkzi.exception.FuncionarioNaoEncontradoException;
import br.com.tkzi.model.Funcionario;
import br.com.tkzi.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario buscarOuFalhar(Long funcionarioId) {
		return funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new FuncionarioNaoEncontradoException(funcionarioId));
	}

	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@Transactional
	public Funcionario atualizar(Long funcionarioId, Funcionario funcionarioAtualizado) {
		Funcionario funcionario = buscarOuFalhar(funcionarioId);
		BeanUtils.copyProperties(funcionarioAtualizado, funcionario,"id");

		return funcionario;
	}

	@Transactional
	public void excluir(Long funcionarioId) {

		funcionarioRepository.delete(buscarOuFalhar(funcionarioId));
	}

}
