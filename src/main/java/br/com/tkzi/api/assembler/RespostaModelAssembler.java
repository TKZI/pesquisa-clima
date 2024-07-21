package br.com.tkzi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tkzi.api.model.RespostaModel;
import br.com.tkzi.model.Resposta;

@Component
public class RespostaModelAssembler {
	
	@Autowired
	private ModelMapper mapper;

	
	public RespostaModel toModel(Resposta resposta) {
		RespostaModel respostaModel = mapper.map(resposta, RespostaModel.class);
		//respostaModel.setPerguntaDescricao(resposta.getPergunta().getDescricao());
		return respostaModel;
	}
	
	public List<RespostaModel> toCollectionModel(List<Resposta> respostas){
		return respostas.stream().map(resp -> toModel(resp)).collect(Collectors.toList());
	}
}
