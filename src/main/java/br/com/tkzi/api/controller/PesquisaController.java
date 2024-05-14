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

import br.com.tkzi.model.Pesquisa;
import br.com.tkzi.service.PesquisaService;

@RestController
@RequestMapping("/pesquisa")
public class PesquisaController {

	@Autowired
	private PesquisaService pesquisaService;

	@GetMapping
	public List<Pesquisa> listar() {
		return pesquisaService.listar();
	}

	@GetMapping("/{pesquisaId}")
	public Pesquisa buscarPorId(@PathVariable Long pesquisaId) {
		return pesquisaService.buscarOuFalhar(pesquisaId);
	}

	@PostMapping
	public Pesquisa salvar(@RequestBody Pesquisa pesquisa) {
		return pesquisaService.salvar(pesquisa);
	}

	@PutMapping("/{pesquisaId}")
	public Pesquisa atualizar(@PathVariable Long pesquisaId, @RequestBody Pesquisa pesquisa) {
		return pesquisaService.atualizar(pesquisaId, pesquisa);

	}

	@DeleteMapping("/{pesquisaId}")
	public void deletar(@PathVariable Long pesquisaId) {
		pesquisaService.deletar(pesquisaId);
	}

}
