package br.com.tkzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tkzi.model.Pesquisa;

@Repository
public interface PesquisaRepository extends JpaRepository<Pesquisa, Long> {

}
