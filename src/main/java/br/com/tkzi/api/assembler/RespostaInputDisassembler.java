package br.com.tkzi.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tkzi.api.input.RespostaInput;
import br.com.tkzi.model.Resposta;

@Component
public class RespostaInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Resposta toDomainObject(RespostaInput respostaInput) {
		return modelMapper.map(respostaInput, Resposta.class);
	}
	
	public void copyToDomainObject(RespostaInput respostaInput, Resposta resposta) {
		modelMapper.map(respostaInput, resposta);
	}

}
