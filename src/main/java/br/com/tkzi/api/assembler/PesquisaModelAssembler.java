package br.com.tkzi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tkzi.api.model.PerguntaModel;
import br.com.tkzi.api.model.PesquisaModel;
import br.com.tkzi.model.Pesquisa;

@Component
public class PesquisaModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PerguntaModelAssembler perguntaModelAssembler;

	public PesquisaModel toModel(Pesquisa pesquisa) {
		
		PesquisaModel pesquisaModel = modelMapper.map(pesquisa, PesquisaModel.class);
		List<PerguntaModel> perguntas = pesquisa.getPerguntas().stream().map(perguntaModelAssembler::toModel).collect(Collectors.toList());
		pesquisaModel.setPerguntas(perguntas);
		return pesquisaModel;
	}

	public List<PesquisaModel> toCollectionModel(List<Pesquisa> pesquisas) {
		List<PesquisaModel> pesquisaModels = pesquisas.stream().map(pesq -> toModel(pesq)).collect(Collectors.toList());

		return pesquisaModels;
	}

}
