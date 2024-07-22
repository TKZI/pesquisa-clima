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

import br.com.tkzi.api.assembler.PesquisaInputDisassembler;
import br.com.tkzi.api.assembler.PesquisaModelAssembler;
import br.com.tkzi.api.input.PesquisaInput;
import br.com.tkzi.api.model.PesquisaModel;
import br.com.tkzi.service.PesquisaService;

@RestController
@RequestMapping("/pesquisa")
public class PesquisaController {

	@Autowired
	private PesquisaService pesquisaService;
	
	@Autowired
	private PesquisaModelAssembler pesquisaModelAssembler;
	
	@Autowired
	private PesquisaInputDisassembler pesquisaInputDisassembler;

	@GetMapping
	public List<PesquisaModel> listar() {
		return pesquisaModelAssembler.toCollectionModel(pesquisaService.listar());
	}

	@GetMapping("/{pesquisaId}")
	public PesquisaModel buscarPorId(@PathVariable Long pesquisaId) {
		return pesquisaModelAssembler.toModel(pesquisaService.buscarOuFalhar(pesquisaId));
	}

	@PostMapping
	public PesquisaModel salvar(@RequestBody PesquisaInput pesquisaInput) {
		var pesquisa = pesquisaInputDisassembler.toDomainObject(pesquisaInput);
		return pesquisaModelAssembler.toModel(pesquisaService.salvar(pesquisa));
	}

	@PutMapping("/{pesquisaId}")
	public PesquisaModel atualizar(@PathVariable Long pesquisaId, @RequestBody PesquisaInput pesquisaInput) {
		var pesquisa = pesquisaInputDisassembler.toDomainObject(pesquisaInput);
		return pesquisaModelAssembler.toModel(pesquisaService.atualizar(pesquisaId, pesquisa));

	}

	@DeleteMapping("/{pesquisaId}")
	public void deletar(@PathVariable Long pesquisaId) {
		pesquisaService.deletar(pesquisaId);
	}

}
