package br.com.tkzi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.model.Pergunta;
import br.com.tkzi.service.PerguntaService;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
	
	@Autowired
	private PerguntaService perguntaService;

	
	@GetMapping
	List<Pergunta> listar(){
		return perguntaService.listar();
	}
	
	@GetMapping("/{perguntaId}")
	Pergunta buscarPorId(@PathVariable Long perguntaId) {
		return perguntaService.buscarOuFalhar(perguntaId);
	}
	
	@PostMapping
	Pergunta salvar(@RequestBody Pergunta pergunta) {
		return perguntaService.salvar(pergunta);
	}
}
