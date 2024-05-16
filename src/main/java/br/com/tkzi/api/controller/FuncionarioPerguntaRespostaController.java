package br.com.tkzi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.model.Resposta;
import br.com.tkzi.service.RespostaService;

@RestController
@RequestMapping("/funcionario/{funcionarioId}")
public class FuncionarioPerguntaRespostaController {

	@Autowired
	private RespostaService respostaService;
	
	@GetMapping("/respostas")
	public List<Resposta> findRespostasDoFuncionario(@PathVariable Long funcionarioId){
		return respostaService.findRespostasFuncionario(funcionarioId);
	}
	
	@PostMapping("/pergunta/{perguntaId}/resposta")
	public Resposta salvarResposta(@PathVariable Long funcionarioId, @PathVariable Long perguntaId, @RequestBody Resposta resposta) {
		return respostaService.salvar(perguntaId, funcionarioId, resposta);
	}
}
