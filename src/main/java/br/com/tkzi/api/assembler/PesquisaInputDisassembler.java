package br.com.tkzi.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tkzi.api.input.PesquisaInput;
import br.com.tkzi.model.Pesquisa;

@Component
public class PesquisaInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Pesquisa toDomainObject(PesquisaInput pesquisaInput) {
		return modelMapper.map(pesquisaInput, Pesquisa.class);
	}
	
	public void copyToDomainObject(PesquisaInput pesquisaInput, Pesquisa pesquisa) {
		modelMapper.map(pesquisaInput, pesquisa);
	}

}
