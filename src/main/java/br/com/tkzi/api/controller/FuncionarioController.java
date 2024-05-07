package br.com.tkzi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.model.Funcionario;
import br.com.tkzi.repository.FuncionarioRepository;
import br.com.tkzi.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}

	@GetMapping("/{funcionarioId}")
	public Funcionario buscarPorId(@PathVariable Long funcionarioId) {
		return funcionarioService.buscarOuFalhar(funcionarioId);
	}

	@PostMapping
	public Funcionario salvar(@RequestBody Funcionario funcionario) {
		return funcionarioService.salvar(funcionario);
	}

	@PutMapping("/{funcionarioId}")
	public Funcionario atualizar(@PathVariable Long funcionarioId, @RequestBody Funcionario funcionarioNovo) {
		Funcionario funcionarioAtualizado = funcionarioService.atualizar(funcionarioId, funcionarioNovo);
		return funcionarioAtualizado;
	}

	@DeleteMapping("/{funcionarioId}")
	public void excluir(@PathVariable Long funcionarioId) {
		funcionarioService.excluir(funcionarioId);
	}
}
