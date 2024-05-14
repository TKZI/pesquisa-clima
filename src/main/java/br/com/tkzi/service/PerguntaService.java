package br.com.tkzi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tkzi.exception.PerguntaNaoEncontradaException;
import br.com.tkzi.model.Pergunta;
import br.com.tkzi.model.Pesquisa;
import br.com.tkzi.repository.PerguntaRepository;
import jakarta.transaction.Transactional;

@Service
public class PerguntaService {
	
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	@Autowired
	private PesquisaService pesquisaService;
	
	
	public List<Pergunta> listar(){
		return perguntaRepository.findAll();
	}
	
	public Pergunta buscarOuFalhar(Long perguntaId) {
		return perguntaRepository.findById(perguntaId).orElseThrow(() -> new PerguntaNaoEncontradaException(perguntaId));
	}
	
	@Transactional
	public Pergunta salvar(Pergunta pergunta) {
		Pesquisa pesquisa = pesquisaService.buscarOuFalhar(pergunta.getPesquisa().getId());
		
		pergunta.setPesquisa(pesquisa);
		return perguntaRepository.save(pergunta);
		
	}
	
	@Transactional
	public Pergunta atualizar(Pergunta pergunta, Long perguntaId) {
		Pergunta perguntaAtual = buscarOuFalhar(perguntaId);
		Pesquisa pesquisa = pesquisaService.buscarOuFalhar(perguntaAtual.getPesquisa().getId()); 
		
		BeanUtils.copyProperties(pergunta, perguntaAtual, "id");
		perguntaAtual.setPesquisa(pesquisa);
		
		return perguntaAtual;
	}
	
	

}
