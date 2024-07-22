package br.com.tkzi.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.tkzi.api.input.RespostaInput;
import br.com.tkzi.model.Resposta;

@Configuration
public class ModelMapperConfig {

	
	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		
		
		modelMapper.addMappings(new PropertyMap<RespostaInput, Resposta>() {
			@Override
			protected void configure() {
				skip(destination.getId());
				map().getFuncionario().setId(source.getFuncionarioIdInput().getId());
				map().getPergunta().setId(source.getPerguntaIdInput().getId());
			}});
		
		
		return modelMapper;
	}
}
