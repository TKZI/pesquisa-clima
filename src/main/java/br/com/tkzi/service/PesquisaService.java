package br.com.tkzi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tkzi.exception.PesquisaNaoEncontradaException;
import br.com.tkzi.model.Pesquisa;
import br.com.tkzi.repository.PesquisaRepository;
import jakarta.transaction.Transactional;

@Service
public class PesquisaService {

	@Autowired
	private PesquisaRepository pesquisaRepository;

	public Pesquisa buscarOuFalhar(Long pesquisaId) {
		return pesquisaRepository.findById(pesquisaId)
				.orElseThrow(() -> new PesquisaNaoEncontradaException(pesquisaId));
	}
	
	public List<Pesquisa> listar(){
		return pesquisaRepository.findAll();
	}
	
	@Transactional
	public Pesquisa salvar(Pesquisa pesquisa) {
		return pesquisaRepository.save(pesquisa);
	}
	
	@Transactional
	public Pesquisa atualizar(Long pesquisaId, Pesquisa pesquisa) {
		Pesquisa pesquisaAtual = buscarOuFalhar(pesquisaId);
		pesquisa.setDataInicio(pesquisaAtual.getDataInicio());
		pesquisa.setDataFim(pesquisaAtual.getDataFim());
		
		BeanUtils.copyProperties(pesquisa, pesquisaAtual, "id");
		
		return pesquisaAtual;
	}
	
	@Transactional
	public void deletar(Long pesquisaId) {
		Pesquisa pesquisa = buscarOuFalhar(pesquisaId);
		pesquisaRepository.delete(pesquisa);
	}

}
