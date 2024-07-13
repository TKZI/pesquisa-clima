package br.com.tkzi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.api.assembler.PerguntaModelAssembler;
import br.com.tkzi.api.model.PerguntaModel;
import br.com.tkzi.model.Pergunta;
import br.com.tkzi.service.PerguntaService;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
	
	@Autowired
	private PerguntaService perguntaService;
	
	@Autowired
	private PerguntaModelAssembler perguntaModelAssembler;

	
	@GetMapping
	public List<PerguntaModel> listar(){
		return perguntaModelAssembler.toCollectionModel(perguntaService.listar());
	}
	
	@GetMapping("/{perguntaId}")
	public PerguntaModel buscarPorId(@PathVariable Long perguntaId) {
		return perguntaModelAssembler.toModel(perguntaService.buscarOuFalhar(perguntaId));
	}
	
	@PostMapping
	public PerguntaModel salvar(@RequestBody Pergunta pergunta) {
		return perguntaModelAssembler.toModel(perguntaService.salvar(pergunta));
	}
}
