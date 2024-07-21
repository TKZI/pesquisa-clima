package br.com.tkzi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tkzi.api.assembler.RespostaInputDisassembler;
import br.com.tkzi.api.assembler.RespostaModelAssembler;
import br.com.tkzi.api.input.RespostaInput;
import br.com.tkzi.api.model.PerguntaModel;
import br.com.tkzi.api.model.RespostaModel;
import br.com.tkzi.service.FuncionarioService;
import br.com.tkzi.service.RespostaService;

@RestController
@RequestMapping("/resposta-pergunta/{funcionarioId}")
public class RespostaPerguntaController {

	@Autowired
	private RespostaService respostaService;
	

	
	@Autowired
	private RespostaModelAssembler respostaModelAssembler;
	
	@Autowired
	private RespostaInputDisassembler respostaInputDisassembler;
	

	

	
	@GetMapping
	public List<RespostaModel> listar(@PathVariable Long funcionarioId){
		return respostaModelAssembler.toCollectionModel(respostaService.findRespostasFuncionario(funcionarioId));
		
	}
	
	public RespostaModel salvar(@PathVariable Long funcionarioId,@PathVariable Long perguntaId,@RequestBody RespostaInput respostaInput) {
		var respostaModel = respostaInputDisassembler.toDomainObject(respostaInput);
		return respostaModelAssembler.toModel(respostaService.salvar(perguntaId, funcionarioId, respostaModel));
		
	}
	
}
