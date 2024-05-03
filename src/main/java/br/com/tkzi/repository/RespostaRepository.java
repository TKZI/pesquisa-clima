package br.com.tkzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tkzi.model.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

}
