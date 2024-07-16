package br.com.tkzi.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tkzi.api.input.FuncionarioInput;
import br.com.tkzi.model.Funcionario;

@Component
public class FuncionarioInputDisassembler {

	
	@Autowired
	private ModelMapper modelMapper;
	
	public Funcionario toDomainObject(FuncionarioInput funcionarioInput) {
		return modelMapper.map(funcionarioInput, Funcionario.class);
	}
	
	public void copyToDomainObject(FuncionarioInput funcionarioInput, Funcionario Funcionario) {
		modelMapper.map(funcionarioInput, Funcionario);
	}
}
