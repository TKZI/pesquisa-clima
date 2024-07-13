package br.com.tkzi.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tkzi.api.model.FuncionarioModel;
import br.com.tkzi.model.Funcionario;

@Component
public class FuncionarioModelAssembler {
	

	@Autowired
	private ModelMapper modelMapper;

	public FuncionarioModel toModel(Funcionario funcionario) {
		
		return modelMapper.map(funcionario, FuncionarioModel.class);
	}
	
	public List<FuncionarioModel> toCollectionModel(List<Funcionario> funcionarios){
		
		List<FuncionarioModel> mapeamento = funcionarios.stream().map(func -> toModel(func)).collect(Collectors.toList());
		
		return mapeamento;
	}
}
