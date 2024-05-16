package br.com.tkzi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tkzi.model.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

	
	public Resposta findByPerguntaIdAndFuncionarioId(Long perguntaId, Long funcionarioId);
	
	
	@Query("select r from Resposta r join fetch r.pergunta where r.funcionario.id = :funcionario")
	public List<Resposta> todasRespostasFuncionario(@Param("funcionario") Long funcionarioId);
}
