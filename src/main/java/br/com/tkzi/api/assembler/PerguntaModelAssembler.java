package br.com.tkzi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tkzi.api.model.PerguntaModel;
import br.com.tkzi.model.Pergunta;

@Component
public class PerguntaModelAssembler {

	@Autowired
	private ModelMapper modelMapeer;

	public PerguntaModel toModel(Pergunta pergunta) {
		return modelMapeer.map(pergunta, PerguntaModel.class);
	}

	public List<PerguntaModel> toCollectionModel(List<Pergunta> perguntas) {

		return perguntas.stream().map(perg -> toModel(perg)).collect(Collectors.toList());
	}

}
