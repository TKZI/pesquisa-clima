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

import br.com.tkzi.api.assembler.FuncionarioModelAssembler;
import br.com.tkzi.api.model.FuncionarioModel;
import br.com.tkzi.model.Funcionario;
import br.com.tkzi.repository.FuncionarioRepository;
import br.com.tkzi.service.FuncionarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioModelAssembler funcionarioAssembler;

	@GetMapping
	public List<FuncionarioModel> listar() {
		return funcionarioAssembler.toCollectionModel(funcionarioRepository.findAll());
	}

	@GetMapping("/{funcionarioId}")
	public FuncionarioModel buscarPorId(@PathVariable Long funcionarioId) {
		return funcionarioAssembler.toModel(funcionarioService.buscarOuFalhar(funcionarioId));
	}

	@PostMapping
	public FuncionarioModel salvar(@RequestBody @Valid Funcionario funcionario) {
		
		return funcionarioAssembler.toModel(funcionarioService.salvar(funcionario));
	}

	@PutMapping("/{funcionarioId}")
	public FuncionarioModel atualizar(@PathVariable Long funcionarioId, @RequestBody Funcionario funcionarioNovo) {
		Funcionario funcionarioAtualizado = funcionarioService.atualizar(funcionarioId, funcionarioNovo);
		return funcionarioAssembler.toModel(funcionarioAtualizado);
	}

	@DeleteMapping("/{funcionarioId}")
	public void excluir(@PathVariable Long funcionarioId) {
		funcionarioService.excluir(funcionarioId);
	}
}
